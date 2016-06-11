package com.mylab.learn.jaranalyzer.service;

import java.io.IOException;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:jar-analyzer-unit-test.xml")
public class JarAnalyzerTest {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${repository.path}")
    String repositoryPath;
    @Value("${jarfile.path}")
    String jarFilePath;
    
    protected JarAnalyzer analyzer = new JarAnalyzer();

    @Test
    public void testProperties() {
    	System.out.println(this.repositoryPath);
    }
    
    @Test
    public void testFindJarFiles() {
        Collection<JarFileBean> jarFileList = this.analyzer.findJarFiles(this.repositoryPath);
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
        Collection<JarFileBean> jarFileList = this.analyzer.findJarFiles(this.repositoryPath);
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

//    @Ignore
    @Test
    public void testFindJarFileListBySha1sum() {
        Collection<JarFileBean> jarFileList = this.analyzer.findJarFiles(this.repositoryPath);
        jarFileList.forEach(jarFile -> this.analyzer.findJarFileBySha1sum(jarFile.getSha1Hex()));
    }

}
