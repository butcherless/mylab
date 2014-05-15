package com.mylab.learn.testpoc.client;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mylab.learn.testpoc.service.MessageService;
import com.mylab.learn.testpoc.service.MessageServiceException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:message-service-client-integration-test.xml")
public class MessageClientTestIT extends MessageClientTestAdapter {

//    @Before
//    public void setUp() {
//        this.messageService = mock(MessageService.class);
//        this.messageServiceClient = new MessageServiceClient();
//        this.messageServiceClient.setMessageService(messageService);
//    }

}
