package com.mylab.learn.myarchetype.client;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mylab.learn.myarchetype.client.TemplateServiceClient;
import com.mylab.learn.myarchetype.service.BusinessEnum;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:template-service-client-integration-test.xml")
public class TemplateServiceClientTestIT {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected TemplateServiceClient templateServiceClient;

    @Test
    public void testMainTemplateOperation() {
        String dummyProperty = BusinessEnum.MAIN_FLOW.toString();
        Boolean result = this.templateServiceClient.callTemplateOperation(dummyProperty);

        Assert.assertTrue("main flow", result);
    }
}
