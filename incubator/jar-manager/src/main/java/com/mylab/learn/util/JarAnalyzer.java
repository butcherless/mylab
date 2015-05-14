package com.mylab.learn.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.jar.JarEntry;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public class JarAnalyzer {

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
}
