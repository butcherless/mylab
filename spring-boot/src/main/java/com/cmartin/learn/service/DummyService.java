package com.cmartin.learn.service;

import com.cmartin.learn.repository.DummyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cmartin on 28/04/2017.
 */
@Service
public class DummyService {
    @Autowired
    private DummyRepository repository;

    public String upperMessage(String message) {
        return this.repository.getMessageByName(message);
    }

}
