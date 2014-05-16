package com.mylab.learn.testpoc.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mylab.learn.testpoc.service.MessageService;
import com.mylab.learn.testpoc.service.MessageServiceException;
import com.mylab.learn.testpoc.service.MessageType;
import com.mylab.learn.testpoc.service.dto.SearchServiceRequest;
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
    public void testSendStoredOk() {
        String subject = "stored message";
        String body = "stored message body";
        MessageType messageType = MessageType.STORED;

        SendServiceRequest sendServiceRequest = new SendServiceRequest(messageType, subject, body);
        SendServiceResponse sendServiceResponse = this.messageService.send(sendServiceRequest);

        Assert.assertNotNull("response unavalible", sendServiceResponse);
        Assert.assertTrue("message not stored", sendServiceResponse.isStored());
    }

    @Test
    public void testSendTransientOk() {
        String subject = "transient message";
        String body = "transient message body";
        MessageType messageType = MessageType.TRANSIENT;

        SendServiceRequest sendServiceRequest = new SendServiceRequest(messageType, subject, body);
        SendServiceResponse sendServiceResponse = this.messageService.send(sendServiceRequest);

        Assert.assertNotNull("response unavalible", sendServiceResponse);
        Assert.assertFalse("message not stored", sendServiceResponse.isStored());
    }

    @Test(expected = MessageServiceException.class)
    public void testSendEmptyRequest() {
        SendServiceRequest sendServiceRequest = null;
        this.messageService.send(sendServiceRequest);
    }

    @Test
    public void testSendInvalidRequest() {
        Boolean exceptionThrown = false;
        String subject = null;
        String body = null;
        MessageType messageType = MessageType.STORED;

        SendServiceRequest sendServiceRequest = new SendServiceRequest(messageType, subject, body);

        try {
            this.messageService.send(sendServiceRequest);
        } catch (MessageServiceException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
        exceptionThrown = false;
        subject = "subject";
        sendServiceRequest = new SendServiceRequest(messageType, subject, body);

        try {
            this.messageService.send(sendServiceRequest);
        } catch (MessageServiceException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void testSearchMessageOk() {
        SearchServiceRequest searchServiceRequest = new SearchServiceRequest();
        this.messageService.search(searchServiceRequest);
        //TODO
    }
    
    @Test(expected = MessageServiceException.class)
    public void testSearchInvalidRequest() {
        SearchServiceRequest searchServiceRequest = null;
        this.messageService.search(searchServiceRequest);
    }

}
