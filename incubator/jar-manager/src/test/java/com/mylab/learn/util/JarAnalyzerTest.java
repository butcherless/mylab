package com.mylab.learn.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import org.junit.Assert;
import org.junit.Test;

public class JarAnalyzerTest {

    final String PATH = "/home/cmartin/.m2/repository";
    JarAnalyzer analyzer = new JarAnalyzer();
    String jarFilePath = "/home/cmartin/.m2/repository/org/springframework/spring-core/4.1.6.RELEASE/spring-core-4.1.6.RELEASE.jar";

    @Test
    public void testFindJarFiles() throws FileNotFoundException, IOException {
        Collection<JarFileBean> jarFileList = this.analyzer.findJarFiles(PATH);
        Assert.assertFalse(jarFileList.isEmpty());
        jarFileList.forEach(f -> System.out.println(f));
    }

    @Test
    public void testFindClassesByJarFile() {
        Collection<ClassFileBean> classList = this.analyzer
                .findClassFileByJarFile(this.jarFilePath);
        Assert.assertFalse("jar must have java classes", classList.isEmpty());
        classList.forEach(c -> System.out.println(c));
    }

    @Test
    public void test() throws IOException {
        Collection<JarFileBean> jarFileList = this.analyzer.findJarFiles(PATH);
        jarFileList.stream()
                .forEach(f -> this.analyzer.findClassFileByJarFile(f.getFullname()));
    }

    @Test
    public void testfindJarFileBySha1sum() throws IOException {
        String sha1sum = "19d4e90b43059058f6e056f794f0ea4030d60b86";
//        String sha1sum = "ce2d409d470948f11fad41ffdf37dcff4d28cd7c";
        String result = this.analyzer.findJarFileBySha1sum(sha1sum);
    }

    @Test
    public void testCreateJarEntries() throws FileNotFoundException, IOException {
        // Collection<File> jarList = this.analyzer.findJarFiles(PATH);
        //
        // for (Iterator<File> iterator = jarList.iterator();
        // iterator.hasNext();) {
        // File file = iterator.next();
        // JarInputStream jis = new JarInputStream(new
        // FileInputStream(file.getCanonicalPath()));
        // JarEntry entry;
        // while ((entry = jis.getNextJarEntry()) != null) {
        // String name = entry.getName();
        // if (name.matches(".*class$")) {
        // ClassFileBean classFileBean =
        // this.analyzer.createClassFileBean(entry);
        // System.out.println(classFileBean);
        // }
        // }
        // }
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

}
