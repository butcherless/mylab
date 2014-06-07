package com.mylab.learn.testpoc.client;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;

import com.mylab.learn.testpoc.service.MessageService;
import com.mylab.learn.testpoc.service.MessageServiceException;

public class MessageClientTest extends MessageClientTestAdapter {

    private MessageService messageService;

    @Before
    public void setUp() {
        this.messageService = mock(MessageService.class);
        this.messageServiceClient = new MessageServiceClient();
        this.messageServiceClient.setMessageService(messageService);
    }

    @Override
    protected void beforeSendMessageOk() {
        when(this.messageService.send(this.sendServiceRequest))
                .thenReturn(this.sendServiceResponse);
    }

    @Override
    protected void afterSendMessageOk() {
        verify(this.messageService).send(this.sendServiceRequest);
    }

    @Override
    protected void beforeSendMessageError() {
        when(this.messageService.send(this.sendServiceRequest))
                .thenThrow(new MessageServiceException("Invalid Request"));
    }
}
