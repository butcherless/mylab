package com.cmartin.learn.service;

import com.cmartin.learn.repository.DummyRepository;
import org.springframework.stereotype.Service;

/**
 * Created by cmartin on 28/04/2017.
 */
@Service
public class DummyService {

    private final DummyRepository repository;

    public DummyService(DummyRepository repository) {
        this.repository = repository;
    }

    public String upperMessage(final String message) {
        return this.repository.getMessageByName(message);
    }

}
