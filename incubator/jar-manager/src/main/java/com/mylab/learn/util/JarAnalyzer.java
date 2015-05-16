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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JarAnalyzer {

    final String SHA1SUM_URI = "http://search.maven.org/solrsearch/select?" +
            "q=1:\"{sha1sum}\"&rows=20&wt=json";

    @Autowired
    private RestTemplate restTemplate;

    public Collection<JarFileBean> findJarFiles(final String pathname) {
        // validation:
        // -file exists
        // -file is a directory
        String[] extensions = { "jar" };
        File file = new File(pathname);
        Collection<File> files = FileUtils.listFiles(file, extensions, Boolean.TRUE);
        files.stream().map(f -> this.createJarFileBean(f));

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

    public String findJarFileBySha1sum(final String sha1sum) throws IOException {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<String, String>();
        params.put("sha1sum", sha1sum);

        String result = restTemplate.getForObject(SHA1SUM_URI, String.class, params);

        this.parseResponse(result);

        return result;
    }

    private void parseResponse(String response) throws IOException {
        // create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(response);
        JsonNode responseNode = rootNode.path("response");
        System.out.println("missing: " + responseNode.isMissingNode());
        System.out.println("numFound: " + responseNode.path("numFound"));
    }

    public Collection<ClassFileBean> findClassFileByJarFile(final String jarFilePath) {
        System.out.println("processing jarfile: " + jarFilePath);

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
