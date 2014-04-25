package com.mylab.learn.myarchetype.client;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:template-service-client-integration-test.xml")
public class TemplateServiceClientTestIT extends TemplateServiceClientTestAdapter {

    @Autowired
    private TemplateServiceClient contextService;

    @Before
    public void setUp() {
        Assert.assertNotNull(contextService);
        this.templateServiceClient = contextService;
    }

}
