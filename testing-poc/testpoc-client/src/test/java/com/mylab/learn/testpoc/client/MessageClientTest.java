package com.mylab.learn.testpoc.client;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;

import com.mylab.learn.testpoc.service.MessageService;
import com.mylab.learn.testpoc.service.MessageServiceException;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:message-client-unit-test.xml")
public class MessageClientTest extends MessageClientTestAdapter {

    private MessageService messageService;

    @Before
    public void setUp() {
        this.messageService = mock(MessageService.class);
        this.messageServiceClient = new MessageServiceClient();
        this.messageServiceClient.setMessageService(messageService);
    }

    @Override
    protected void beforeTestMessageSendAndStore() {
        when(this.messageService.send(this.sendServiceRequest))
                .thenReturn(this.sendServiceResponse);
    }

    @Override
    protected void afterTestMessageSendAndStore() {
        verify(this.messageService).send(this.sendServiceRequest);
    }

    @Override
    protected void beforeTestMessageSendAndNotStore() {
        this.beforeTestMessageSendAndStore();
    }

    @Override
    protected void afterTestMessageSendAndNotStore() {
        this.afterTestMessageSendAndStore();
    }

    @Override
    protected void beforeTestMessageSendError() {
        when(this.messageService.send(this.sendServiceRequest))
                .thenThrow(new MessageServiceException("Invalid Request"));
    }
}
