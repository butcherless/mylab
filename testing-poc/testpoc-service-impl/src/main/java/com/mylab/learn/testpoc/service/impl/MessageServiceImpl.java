package com.mylab.learn.testpoc.service.impl;

import org.springframework.stereotype.Service;

import com.mylab.learn.testpoc.service.MessageService;
import com.mylab.learn.testpoc.service.MessageServiceException;
import com.mylab.learn.testpoc.service.dto.SearchServiceRequest;
import com.mylab.learn.testpoc.service.dto.SearchServiceResponse;
import com.mylab.learn.testpoc.service.dto.SendServiceRequest;
import com.mylab.learn.testpoc.service.dto.SendServiceResponse;

@Service
public class MessageServiceImpl implements MessageService {

    @Override
    public SendServiceResponse send(SendServiceRequest sendServiceRequest)
            throws MessageServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SearchServiceResponse search(SearchServiceRequest searchServiceRequest)
            throws MessageServiceException {
        // TODO Auto-generated method stub
        return null;
    }

}
