package com.mylab.learn.util;

import java.io.IOException;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JarAnalyzerTest {
    Logger logger = LoggerFactory.getLogger(getClass());

    final String PATH = "/home/cmartin/.m2/repository";
    JarAnalyzer analyzer = new JarAnalyzer();
    String jarFilePath = "/home/cmartin/.m2/repository/org/springframework/spring-core/4.1.6.RELEASE/spring-core-4.1.6.RELEASE.jar";

    @Test
    public void testFindJarFiles() {
        Collection<JarFileBean> jarFileList = this.analyzer.findJarFiles(PATH);
        Assert.assertFalse(jarFileList.isEmpty());
        jarFileList.forEach(f -> this.logger.debug(f.toString()));
    }

    @Test
    public void testFindJarFilesNotFound() {
        Collection<JarFileBean> jarFileList = this.analyzer.findJarFiles("/tmp");
        Assert.assertTrue(jarFileList.isEmpty());
    }

    @Test
    public void testFindClassesByJarFile() {
        Collection<ClassFileBean> classList = this.analyzer
                .findClassFileByJarFile(this.jarFilePath);
        Assert.assertFalse("jar must have java classes", classList.isEmpty());
        classList.forEach(c -> this.logger.debug(c.toString()));
    }

    @Test
    public void test() throws IOException {
        Collection<JarFileBean> jarFileList = this.analyzer.findJarFiles(PATH);
        jarFileList.forEach(jarFile -> this.m(jarFile));
        this.logger.debug("list size: {}", jarFileList.size());
    }

    private void m(final JarFileBean jarFileBean) {
        Collection<ClassFileBean> classList =
                this.analyzer.findClassFileByJarFile(jarFileBean.getFullname());
        // classList.forEach(c -> this.logger.debug(c.toString()));
    }

    @Test
    public void testfindJarFileBySha1sum() {
        String sha1sum = "19d4e90b43059058f6e056f794f0ea4030d60b86";
        // String sha1sum = "ce2d409d470948f11fad41ffdf37dcff4d28cd7c";
        String result = this.analyzer.findJarFileBySha1sum(sha1sum);
    }
    
    @Test
    public void testFindJarFileListBySha1sum() {
        Collection<JarFileBean> jarFileList = this.analyzer.findJarFiles(PATH);
        jarFileList.forEach(jarFile -> this.analyzer.findJarFileBySha1sum(jarFile.getSha1Hex()));
    }

}
