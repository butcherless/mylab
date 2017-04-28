package com.cmartin.learn.repository;

import org.springframework.stereotype.Repository;

/**
 * Created by cmartin on 28/04/2017.
 */
@Repository
public class DummyRepository {

    public String getMessageByName(String messageName) {
        return messageName.toUpperCase();
    }
}
