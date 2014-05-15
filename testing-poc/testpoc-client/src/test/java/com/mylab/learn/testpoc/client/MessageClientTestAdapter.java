package com.mylab.learn.testpoc.client;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mylab.learn.testpoc.service.MessageServiceException;
import com.mylab.learn.testpoc.service.dto.SendServiceRequest;
import com.mylab.learn.testpoc.service.dto.SendServiceResponse;

public abstract class MessageClientTestAdapter {

    protected SendServiceRequest sendServiceRequest;
    protected SendServiceResponse sendServiceResponse;

    protected String subject, body;
    protected Boolean result;

    @Autowired
    protected MessageServiceClient messageServiceClient;

    @Test
    public void testMessageSendAndStored() {
        String subject = "stored message";
        String body = "stored message body";
        this.sendServiceRequest = new SendServiceRequest(subject, body);
        this.sendServiceResponse = new SendServiceResponse(Boolean.TRUE);
        this.beforeTestMessageSendAndStore();

        Boolean stored = this.messageServiceClient.send(this.sendServiceRequest);

        this.afterTestMessageSendAndStore();

        Assert.assertTrue("message not stored", stored);
    }

    @Test
    public void testMessageSendAndNotStored() {
        String subject = "transient message";
        String body = "transient message body";
        this.sendServiceRequest = new SendServiceRequest(subject, body);
        this.sendServiceResponse = new SendServiceResponse(Boolean.FALSE);
        this.beforeTestMessageSendAndNotStore();

        Boolean stored = this.messageServiceClient.send(this.sendServiceRequest);

        this.afterTestMessageSendAndNotStore();

        Assert.assertFalse("message stored", stored);
    }

    @Test(expected = MessageServiceException.class)
    public void testMessageSendError() {
        String subject = null;
        String body = null;
        this.sendServiceRequest = new SendServiceRequest(subject, body);
        this.beforeTestMessageSendError();

        Boolean stored = this.messageServiceClient.send(this.sendServiceRequest);
    }

    protected abstract void beforeTestMessageSendAndStore();

    protected abstract void afterTestMessageSendAndStore();

    protected abstract void beforeTestMessageSendAndNotStore();

    protected abstract void afterTestMessageSendAndNotStore();

    protected abstract void beforeTestMessageSendError();
}
