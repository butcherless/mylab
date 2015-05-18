package com.mylab.learn.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JarAnalyzer {

    final String SHA1SUM_URI = "http://search.maven.org/solrsearch/select?" +
            "q=1:\"{sha1sum}\"&rows=20&wt=json";

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Finds a list of jar files recursively starting from a filesystem path
     * 
     * @param pathname
     * @return
     */
    public Collection<JarFileBean> findJarFiles(final String pathname) {
        // validation:
        // -file exists
        // -file is a directory
        // -can read

        // configure search
        String[] extensions = { "jar" };
        File file = new File(pathname);

        Collection<File> files = FileUtils.listFiles(file, extensions, Boolean.TRUE);
        this.logger.debug("found {} jar files", files.size());

        return files.stream()
                .map(f -> this.createJarFileBean(f))
                .collect(Collectors.toList());
    }

    public JarFileBean createJarFileBean(final File file) {
        String path = FilenameUtils.getPath(file.getPath());
        String name = FilenameUtils.removeExtension(FilenameUtils.getName(file.getPath()));
        String sha1Hex;
        try {
            sha1Hex = DigestUtils.sha1Hex(new FileInputStream(file));
        } catch (IOException e) {
            throw new JarAnalizerException("unable to calculate sha1sum", e);
        }

        return new JarFileBean(name, path, sha1Hex);
    }

    public ClassFileBean createClassFileBean(final JarEntry entry) {

        String fullname = FilenameUtils.removeExtension(entry.getName()).replace('/', '.');
        Long size = entry.getSize();
        if (size < 0) {
            throw new JarAnalizerException("Class size cannot be negative: " + fullname);
        }

        return new ClassFileBean(fullname, size);
    }

    public String findJarFileBySha1sum(final String sha1sum) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<String, String>();
        params.put("sha1sum", sha1sum);

        String result = restTemplate.getForObject(SHA1SUM_URI, String.class, params);

        try {
            Boolean found = this.parseResponse(result);
//            this.logger.debug("sha1sum exists?: {}:{}", sha1sum, found);
        } catch (IOException e) {
            throw new JarAnalizerException("Error parsing json file", e);
        }

        return result;
    }

    private Boolean parseResponse(final String response) throws JsonProcessingException,
            IOException {
        // create ObjectMapper instance
        Boolean found = false;
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(response);
        JsonNode responseNode = rootNode.path("response");
        if (!responseNode.isMissingNode()) {
            if (!responseNode.path("numFound").isMissingNode()) {
                if (!responseNode.path("numFound").equals("0")) {
                    found = true;
                }
                this.logger.debug("artifact found[{}]: {}", responseNode.path("numFound"), responseNode.path("docs").findPath("id"));
            }
        }
//        System.out.println("missing: " + responseNode.isMissingNode());
//        System.out.println("numFound: " + responseNode.path("numFound"));
//        System.out.println("docs: " + responseNode.path("docs"));
//        System.out.println("id: " + responseNode.path("docs").findPath("id"));
//        System.out.println("group: " + responseNode.path("docs").findPath("g"));
//        System.out.println("artifact: " + responseNode.path("docs").findPath("a"));
//        System.out.println("version: " + responseNode.path("docs").findPath("v"));
//        System.out.println("package: " + responseNode.path("docs").findPath("p"));

        return found;
    }

    public Collection<ClassFileBean> findClassFileByJarFile(final String jarFilePath) {
        this.logger.debug("processing jarfile: {}", jarFilePath);

        JarFile jarFile = null;

        try {
            jarFile = new JarFile(jarFilePath);

            return jarFile.stream()
                    .filter(e -> e.getName().matches(".*class$"))
                    .map(e -> this.createClassFileBean(e))
                    .collect(Collectors.toSet());

        } catch (IOException e) {
            throw new JarAnalizerException("Unable to read jar file: " + jarFilePath, e);
        } finally {
            try {
                jarFile.close();
            } catch (IOException e) {
            }
        }
    }
}
