package com.mylab.learn.myairline.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mylab.learn.myairline.service.api.AirlineService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:airline-service-integration-test.xml")
public class AircraftServiceTest {

    @Autowired
    private AirlineService aircraftService;

    @Before
    public void setUp() {
        Assert.assertNotNull(this.aircraftService);
    }

    @Test
    public void testServiceOperation() {
        // TODO Auto-generated constructor stub
        this.aircraftService.serviceOperation();
    }

}
