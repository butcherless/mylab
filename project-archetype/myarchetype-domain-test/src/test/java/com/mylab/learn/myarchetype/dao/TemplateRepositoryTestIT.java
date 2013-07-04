package com.mylab.learn.myarchetype.dao;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:template-domain-integration-test.xml")
public class TemplateRepositoryTestIT extends TemplateRepositoryTestAdapter {

}
