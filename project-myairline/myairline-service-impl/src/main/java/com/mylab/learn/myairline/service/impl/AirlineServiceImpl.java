package com.mylab.learn.myairline.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mylab.learn.myairline.domain.Airline;
import com.mylab.learn.myairline.domain.DomainFactory;
import com.mylab.learn.myairline.repository.AirlineRepository;
import com.mylab.learn.myairline.service.api.AirlineService;

@Service
public class AirlineServiceImpl implements AirlineService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AirlineRepository airlineRepository;

    public AirlineServiceImpl() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void serviceOperation() {
        // TODO Auto-generated method stub

        Airline airline = DomainFactory.newAirline("Delta");

        this.logger.debug("before service operation");

        this.airlineRepository.save(airline);

        this.logger.debug("after service operation");
    }

}
