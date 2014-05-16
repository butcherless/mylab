package com.mylab.learn.testpoc.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mylab.learn.testpoc.service.MessageService;
import com.mylab.learn.testpoc.service.MessageServiceException;
import com.mylab.learn.testpoc.service.MessageType;
import com.mylab.learn.testpoc.service.dto.SearchServiceRequest;
import com.mylab.learn.testpoc.service.dto.SearchServiceResponse;
import com.mylab.learn.testpoc.service.dto.SendServiceRequest;
import com.mylab.learn.testpoc.service.dto.SendServiceResponse;

/**
 * 
 * @author cmartin
 *
 */
@Service
public class MessageServiceImpl implements MessageService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public SendServiceResponse send(final SendServiceRequest sendServiceRequest)
            throws MessageServiceException {
        Boolean result = null;

        this.validateSendRequest(sendServiceRequest);

        this.logger.debug(sendServiceRequest.toString());

        if (sendServiceRequest.getMessageType().equals(MessageType.STORED)) {
            result = Boolean.TRUE;
        } else {
            result = Boolean.FALSE;
        }

        SendServiceResponse sendServiceResponse = new SendServiceResponse(result);

        this.logger.debug(sendServiceResponse.toString());

        return sendServiceResponse;
    }

    @Override
    public SearchServiceResponse search(final SearchServiceRequest searchServiceRequest)
            throws MessageServiceException {
        // TODO Auto-generated method stub
        this.validateSearchRequest(searchServiceRequest);
        
        return null;
    }


    // H E L P E R S

    private void validateSearchRequest(SearchServiceRequest searchServiceRequest) {
        if (searchServiceRequest == null) {
            throw new MessageServiceException("Validation Exception: " + "empty request");
        }
    }

    private void validateSendRequest(final SendServiceRequest sendServiceRequest) {
        if (sendServiceRequest == null) {
            throw new MessageServiceException("Validation Exception: " + "empty request");
        }

        if (StringUtils.isBlank(sendServiceRequest.getSubject())) {
            throw new MessageServiceException("Validation Exception: " + "empty subject");
        }

        if (StringUtils.isBlank(sendServiceRequest.getBody())) {
            throw new MessageServiceException("Validation Exception: " + "empty body");
        }

    }

}
