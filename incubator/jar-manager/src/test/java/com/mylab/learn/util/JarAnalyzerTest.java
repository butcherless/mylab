package com.mylab.learn.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import org.junit.Assert;
import org.junit.Test;

public class JarAnalyzerTest {

	final String PATH = "/home/cmartin/.m2/repository";
	JarAnalyzer analyzer = new JarAnalyzer();
	String jarFilePath = "/home/cmartin/.m2/repository/org/springframework/spring-core/4.1.6.RELEASE/spring-core-4.1.6.RELEASE.jar";

	@Test
	public void testCreateJarFiles() throws FileNotFoundException, IOException {
		Collection<File> jarList = this.analyzer.findJars(PATH);
		Assert.assertFalse(jarList.isEmpty());
		this.printJarCollection(jarList);
	}

	@Test
	public void testCreateJarEntries() throws FileNotFoundException, IOException {
		Collection<File> jarList = this.analyzer.findJars(PATH);
		
		for (Iterator<File> iterator = jarList.iterator(); iterator.hasNext();) {
			File file = iterator.next();
			JarInputStream jis = new JarInputStream(new FileInputStream(file.getCanonicalPath()));
			JarEntry entry;
			while ((entry = jis.getNextJarEntry()) != null) {
				String name = entry.getName();
				if (name.matches(".*class$")) {
					ClassFileBean classFileBean = this.analyzer.createClassFileBean(entry);
					System.out.println(classFileBean);
				}
			}
		}
	}

	@Test
	public void testCreateJarEntriesFromJar() throws FileNotFoundException, IOException {
		JarInputStream jis = new JarInputStream(new FileInputStream(jarFilePath));
		JarEntry entry;
		while ((entry = jis.getNextJarEntry()) != null) {
			String name = entry.getName();
			if (name.matches(".*class$")) {
				ClassFileBean classFileBean = this.analyzer.createClassFileBean(entry);
				System.out.println(classFileBean);
			}
		}
	}
	
	
	private void printJarCollection(final Collection<File> collection)
			throws FileNotFoundException, IOException {
		System.out.println("collection count: " + collection.size());
		for (Iterator<File> iterator = collection.iterator(); iterator.hasNext();) {
			File file = (File) iterator.next();
			System.out.println(this.analyzer.createJarFileBean(file));
		}
	}
}
