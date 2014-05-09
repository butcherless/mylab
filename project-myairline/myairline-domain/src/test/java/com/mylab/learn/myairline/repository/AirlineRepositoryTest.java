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
import com.mylab.learn.myairline.domain.Destination;
import com.mylab.learn.myairline.domain.DomainFactory;
import com.mylab.learn.myairline.domain.Route;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:airline-domain-unit-test.xml")
public class AirlineRepositoryTest {

    @Autowired
    protected AirlineRepository airlineRepository;

    @Autowired
    protected DestinationRepository destinationRepository;
    @Autowired
    protected RouteRepository routeRepository;

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
    public void testCreateDestination() {
        Destination destination = this.createBarajasDestination();

        this.destinationRepository.save(destination);

        Assert.assertNotNull(destination.getId());
        Assert.assertEquals("entity count", 1L, this.destinationRepository.count());
    }

    @Transactional
    @Test
    public void testCreateRoute() {
        String name = "Madrid-LasPalmas";
        Destination startDestination = this.createBarajasDestination();
        this.destinationRepository.save(startDestination);
        Destination stopDestination = this.createLasPalmasDestination();
        this.destinationRepository.save(stopDestination);
        
        Route route = DomainFactory.newRoute(name, startDestination, stopDestination);

        this.routeRepository.save(route);
        Assert.assertNotNull(route.getId());
        Assert.assertEquals("entity count", 1L, this.routeRepository.count());
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

    private Route createRouteMAD2LPA() {
        String name = "Madrid-LasPalmas";
        Destination startDestination = this.createBarajasDestination();
        Destination stopDestination = this.createLasPalmasDestination();
        Route route = DomainFactory.newRoute(name, startDestination, stopDestination);

        return route;
    }

    private List<Airline> iterableToList(final Iterable<Airline> airlines) {
        List<Airline> list = new ArrayList<Airline>();
        for (Airline airline : airlines) {
            list.add(airline);
        }

        return list;
    }

    private Destination createBarajasDestination() {
        String airportName = "Madrid Barajas";
        String shortCode = "MAD";

        return DomainFactory.newDestination(airportName, shortCode);
    }

    private Destination createLasPalmasDestination() {
        String airportName = "Las Palmas de Gran Canaria";
        String shortCode = "LPA";

        return DomainFactory.newDestination(airportName, shortCode);
    }

}
