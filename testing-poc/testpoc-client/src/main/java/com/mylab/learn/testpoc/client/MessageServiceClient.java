package com.mylab.learn.testpoc.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mylab.learn.testpoc.service.MessageService;
import com.mylab.learn.testpoc.service.dto.SendServiceRequest;
import com.mylab.learn.testpoc.service.dto.SendServiceResponse;

/**
 * 
 * @author cmartin
 *
 */
@Component
public class MessageServiceClient {

    @Autowired
    private MessageService messageService;

    public MessageServiceClient() {
        // TODO Auto-generated constructor stub
    }

    public Boolean send(final SendServiceRequest sendServiceRequest) {
        SendServiceResponse sendServiceResponse = this.messageService.send(sendServiceRequest);
        return this.checkSendServiceResponse(sendServiceResponse);
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    private Boolean checkSendServiceResponse(final SendServiceResponse sendServiceResponse) {
        return sendServiceResponse.isStored();
    }

//    public void search(String subject) {
//
//    }

}
