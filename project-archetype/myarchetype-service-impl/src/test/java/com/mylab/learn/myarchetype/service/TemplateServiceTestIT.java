package com.mylab.learn.myarchetype.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:template-service-integration-test.xml")
public class TemplateServiceTestIT extends TemplateServiceTestAdapter {

    @Autowired
    private TemplateService templateService;

    @Before
    public void setUp() {
        Assert.assertNotNull(this.templateService);
        super.templateService = this.templateService;
    }

    @Override
    public void testAlternateTemplateOperation() {
        this.logger.debug("before service operation");
        super.testAlternateTemplateOperation();
        this.logger.debug("after service operation");
    }

}
