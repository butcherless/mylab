package com.mylab.learn.testpoc.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mylab.learn.testpoc.service.MessageService;
import com.mylab.learn.testpoc.service.dto.SendServiceRequest;
import com.mylab.learn.testpoc.service.dto.SendServiceResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:message-service-unit-test.xml")
public class MessageServiceTest {

    @Autowired
    protected MessageService messageService;

    @Before
    public void setUp() {
        Assert.assertNotNull("service unavalible", this.messageService);
    }

    @Test
    public void testSendOk() {
        String subject = null;
        String body = null;
        SendServiceRequest sendServiceRequest = new SendServiceRequest(subject, body);
        SendServiceResponse sendServiceResponse = this.messageService.send(sendServiceRequest);
        
//        Assert.assertNotNull("response unavalible" ,sendServiceResponse);
    }
    
    @Test
    public void testSendKo() {
        String subject = null;
        String body = null;
        SendServiceRequest sendServiceRequest = new SendServiceRequest(subject, body);
        SendServiceResponse sendServiceResponse = this.messageService.send(sendServiceRequest);
        
//        Assert.assertNotNull("response unavalible" ,sendServiceResponse);
    }

}
