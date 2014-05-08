package com.mylab.learn.myairline.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mylab.learn.myairline.domain.Airline;
import com.mylab.learn.myairline.domain.DomainFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:airline-domain-unit-test.xml")
public class AirlineRepositoryTest {

    @Autowired
    protected AirlineRepository airlineRepository;

    @Transactional
    @Test
    public void testCreateAirline() {
        Airline airline = this.createIberiaAirline();
        this.airlineRepository.save(airline);

        Assert.assertNotNull(airline.getId());
        Assert.assertEquals("entity count", 1L, this.airlineRepository.count());
    }

    @Transactional
    @Test
    public void testFindByNamePredicate() {
        Airline airline = this.createIberiaAirline();
        this.airlineRepository.save(airline);

        Assert.assertNotNull(airline.getId());

        String searchTerm = "Iberia";
        Iterable<Airline> airlines = this.airlineRepository.findAll(
                AirlinePredicates.nameEquals(searchTerm));

        Assert.assertEquals("entity count", 1L, this.iterableToList(airlines).size());
    }

    private Airline createIberiaAirline() {
        String name = "Iberia";

        return DomainFactory.newAirline(name);
    }

    private List<Airline> iterableToList(final Iterable<Airline> airlines) {
        List<Airline> list = new ArrayList<Airline>();
        for (Airline airline : airlines) {
            list.add(airline);
        }

        return list;
    }
}
