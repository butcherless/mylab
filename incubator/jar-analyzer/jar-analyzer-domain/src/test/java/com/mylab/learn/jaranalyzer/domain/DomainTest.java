package com.mylab.learn.jaranalyzer.domain;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mylab.learn.jaranalyzer.repository.JarFileBeanRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/jar-analyzer-domain.xml" })
public class DomainTest {

    @Autowired
    protected JarFileBeanRepository repository;

    @Test
    @Transactional
    public void test() {

        String name = "log4j";
        String path = "/home/user/local/repo/";
        String sha1Hex = "a1b2c3d4";
        JarFileBean bean = new JarFileBean(name, path, sha1Hex);
        JarFileBean beanCreated = this.repository.save(bean);
        JarFileBean beanRetrieved = this.repository.findBySha1Hex(sha1Hex);
        Assert.assertEquals("retrieved jarfile bean matches persisted one",
                beanCreated.getSha1Hex(), beanRetrieved.getSha1Hex());
    }
}
