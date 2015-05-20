package com.mylab.learn.jaranalyzer.domain;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mylab.learn.jaranalyzer.repository.ClassFileBeanRepository;
import com.mylab.learn.jaranalyzer.repository.JarFileBeanRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/jar-analyzer-domain.xml" })
public class DomainTest {

    @Autowired
    protected JarFileBeanRepository JarRepository;

    @Autowired
    protected ClassFileBeanRepository classRepository;

    @Test
    @Transactional
    public void testCreateJarFile() {

        String name = "log4j";
        String path = "/home/user/local/repo/";
        String sha1Hex = "a1b2c3d4";
        JarFileBean bean = new JarFileBean(name, path, sha1Hex);

        Assert.assertEquals(0, this.JarRepository.count());
        JarFileBean beanCreated = this.JarRepository.save(bean);
        Assert.assertEquals(1L, this.JarRepository.count());
        JarFileBean beanRetrieved = this.JarRepository.findBySha1Hex(sha1Hex);
        Assert.assertEquals("retrieved jarfile bean matches persisted one",
                beanCreated.getSha1Hex(), beanRetrieved.getSha1Hex());
    }

    @Test
    @Transactional
    public void testCreateClassFile() {
        String fullname = "com.cmartin.learn.MyClass";
        Long size = 128L;
        ClassFileBean classFileBean = new ClassFileBean(fullname, size);
        Assert.assertEquals(0, this.classRepository.count());
        this.classRepository.save(classFileBean);
        Assert.assertEquals(1L, this.classRepository.count());
    }

    @Test
    @Transactional
    public void testCreateRelationShip() {
        String name = "log4j";
        String path = "/home/user/local/repo/";
        String sha1Hex = "a1b2c3d4";
        JarFileBean jarFileBean = new JarFileBean(name, path, sha1Hex);
        this.JarRepository.save(jarFileBean);
        Assert.assertEquals(1L, this.JarRepository.count());

        String fullname = "com.cmartin.learn.MyClass";
        Long size = 128L;
        ClassFileBean classFileBean = new ClassFileBean(fullname, size);
        classFileBean.setJarFileBean(jarFileBean);
        this.classRepository.save(classFileBean);
        Assert.assertEquals(1L, this.classRepository.count());
    }
}
