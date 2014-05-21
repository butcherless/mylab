package com.mylab.learn.testpoc.client;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mylab.learn.testpoc.service.MessageServiceException;
import com.mylab.learn.testpoc.service.MessageType;
import com.mylab.learn.testpoc.service.dto.SendServiceRequest;
import com.mylab.learn.testpoc.service.dto.SendServiceResponse;

public abstract class MessageClientTestAdapter {

    protected SendServiceRequest sendServiceRequest;
    protected SendServiceResponse sendServiceResponse;

    @Autowired
    protected MessageServiceClient messageServiceClient;

    @Test
    public void testMessageSendAndStored() {
        String subject = "stored message";
        String body = "stored message body";
        MessageType messageType = MessageType.STORED;

        this.sendServiceRequest = new SendServiceRequest(messageType, subject, body);
        this.sendServiceResponse = new SendServiceResponse(Boolean.TRUE);
        this.beforeTestMessageSendOk();

        Boolean stored = this.messageServiceClient.send(this.sendServiceRequest);

        this.afterTestMessageSendOk();

        Assert.assertTrue("message not stored", stored);
    }

    @Test
    public void testMessageSendAndNotStored() {
        String subject = "transient message";
        String body = "transient message body";
        MessageType messageType = MessageType.TRANSIENT;

        this.sendServiceRequest = new SendServiceRequest(messageType, subject, body);
        this.sendServiceResponse = new SendServiceResponse(Boolean.FALSE);
        this.beforeTestMessageSendOk();

        Boolean stored = this.messageServiceClient.send(this.sendServiceRequest);

        this.afterTestMessageSendOk();

        Assert.assertFalse("message stored", stored);
    }

    @Test(expected = MessageServiceException.class)
    public void testMessageSendError() {
        String subject = null;
        String body = null;
        MessageType messageType = MessageType.STORED;

        this.sendServiceRequest = new SendServiceRequest(messageType, subject, body);
        this.beforeTestMessageSendError();

        this.messageServiceClient.send(this.sendServiceRequest);
    }

    protected void beforeTestMessageSendOk() {
    }

    protected void afterTestMessageSendOk() {
    }

    protected void beforeTestMessageSendError() {
    }
}
