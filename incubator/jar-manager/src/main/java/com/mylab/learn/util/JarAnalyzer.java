package com.mylab.learn.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JarAnalyzer {
	
	final String SHA1SUM_URI = "http://search.maven.org/solrsearch/select?" +
	"q=1:\"{sha1sum}\"&rows=20&wt=json";

	
	@Autowired
    private RestTemplate restTemplate;
	
	public Collection<File> findJars(final String pathname) {
		// file exists
		// file is a directory

		File file = new File(pathname);
		String[] extensions = { "jar" };
		Boolean recursive = Boolean.TRUE;

		return FileUtils.listFiles(file, extensions, recursive);
	}

	public JarFileBean createJarFileBean(final File file)
			throws FileNotFoundException, IOException {
		String path = FilenameUtils.getPath(file.getPath());
		String name = FilenameUtils.removeExtension(FilenameUtils.getName(file
				.getPath()));
		String sha1Hex = DigestUtils.sha1Hex(new FileInputStream(file));

		return new JarFileBean(name, path, sha1Hex);
	}

	public ClassFileBean createClassFileBean(final JarEntry entry) {

		String fullname = FilenameUtils.removeExtension(entry.getName()).replace('/', '.');
		Long size = entry.getSize();

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
		//create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(response);
		JsonNode responseNode = rootNode.path("response");
		System.out.println("missing: " + responseNode.isMissingNode());
		System.out.println("numFound: " + responseNode.path("numFound"));
	}
}
