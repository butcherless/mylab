package com.mylab.learn.myarchetype.client;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mylab.learn.myarchetype.service.TemplateServiceMockImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:template-service-client-unit-test.xml")
public class TemplateServiceClientUnitTest extends TemplateServiceClientTestAdapter {

    @Before
    public void setUp() {
        TemplateServiceMockImpl templateServiceMockImpl = new TemplateServiceMockImpl();
        TemplateServiceClient templateServiceClient = new TemplateServiceClient();
        templateServiceClient.setTemplateService(templateServiceMockImpl);
        super.templateServiceClient = templateServiceClient;
    }
}
