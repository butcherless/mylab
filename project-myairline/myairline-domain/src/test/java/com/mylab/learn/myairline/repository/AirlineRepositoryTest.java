package com.mylab.learn.myairline.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mylab.learn.myairline.domain.Aircraft;
import com.mylab.learn.myairline.domain.Airline;
import com.mylab.learn.myairline.domain.Location;
import com.mylab.learn.myairline.domain.DomainFactory;
import com.mylab.learn.myairline.domain.Route;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:airline-domain-unit-test.xml")
@Ignore
public class AirlineRepositoryTest {

    @Autowired
    protected AirlineRepository airlineRepository;

    @Autowired
    protected AircraftRepository aircraftRepository;

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
    public void testExistsAirline() {
        Airline airline = this.createIberiaAirline();
        this.airlineRepository.save(airline);
        Assert.assertNotNull(airline.getId());
        Assert.assertTrue(this.airlineRepository.exists(airline.getId()));
    }

    @Transactional
    @Test
    public void testCreateAircraft() {
        Airline airline = this.createIberiaAirline();
        this.airlineRepository.save(airline);

        Aircraft aircraft = this.createPicosDeEuropaAircraft(airline);
        long entityCount = this.aircraftRepository.count();
        this.aircraftRepository.save(aircraft);

        Assert.assertNotNull(aircraft.getId());
        Assert.assertEquals("entity count", (entityCount + 1), this.aircraftRepository.count());
    }

    @Transactional
    @Test
    public void testFindAircraftByAirlineName() {
        Airline airline = this.createIberiaAirline();
        this.airlineRepository.save(airline);

        Aircraft aircraft = this.createPicosDeEuropaAircraft(airline);
        long entityCount = this.aircraftRepository.count();
        this.aircraftRepository.save(aircraft);

        aircraft = this.createSierraDeGredosAircraft(airline);
        this.aircraftRepository.save(aircraft);
        
        Assert.assertEquals("entity count", 1L, this.airlineRepository.count());
        Assert.assertEquals("entity count", 2L, this.aircraftRepository.count());
        
        String airlineName = "Iberia";
        Iterable<Aircraft> aircfrafts = this.aircraftRepository.findAll(
                AircraftPredicates.belongsToAirline(airlineName));

        Assert.assertEquals("entity count", 2L, this.iterableToAircraftList(aircfrafts).size());
    }

    
    @Transactional
    @Test
    public void testCreateDestination() {
        Location destination = this.createBarajasDestination();

        this.destinationRepository.save(destination);

        Assert.assertNotNull(destination.getId());
        Assert.assertEquals("entity count", 1L, this.destinationRepository.count());
    }

    @Transactional
    @Test
    public void testCreateRoute() {
        String name = "Madrid-LasPalmas";
        Location startDestination = this.createBarajasDestination();
        this.destinationRepository.save(startDestination);
        Location stopDestination = this.createLasPalmasDestination();
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

        String airlineName = "Iberia";
        Iterable<Airline> airlines = this.airlineRepository.findAll(
                AirlinePredicates.nameEquals(airlineName));

        Assert.assertEquals("entity count", 1L, this.iterableToList(airlines).size());
    }

    // //////// H E L P E R S

    private Aircraft createPicosDeEuropaAircraft(final Airline airline) {
        String name = "Picos de Europa";
        String registration = "EC-LUB";

        return DomainFactory.newAircraft(name, registration, airline);
    }

    private Aircraft createSierraDeGredosAircraft(final Airline airline) {
        String name = "Sierra de Gredos";
        String registration = "EC-LUC";

        return DomainFactory.newAircraft(name, registration, airline);
    }

    private Airline createIberiaAirline() {
        String name = "Iberia";

        return DomainFactory.newAirline(name);
    }

    private Route createRouteMAD2LPA() {
        String name = "Madrid-LasPalmas";
        Location startDestination = this.createBarajasDestination();
        Location stopDestination = this.createLasPalmasDestination();
        Route route = DomainFactory.newRoute(name, startDestination, stopDestination);

        return route;
    }

    private List<Aircraft> iterableToAircraftList(final Iterable<Aircraft> aircrafts) {
        List<Aircraft> list = new ArrayList<Aircraft>();
        for (Aircraft aircraft : aircrafts) {
            list.add(aircraft);
        }

        return list;
    }

    private List<Airline> iterableToList(final Iterable<Airline> airlines) {
        List<Airline> list = new ArrayList<Airline>();
        for (Airline airline : airlines) {
            list.add(airline);
        }

        return list;
    }

    private Location createBarajasDestination() {
        String airportName = "Madrid Barajas";
        String shortCode = "MAD";

        return DomainFactory.newDestination(airportName, shortCode);
    }

    private Location createLasPalmasDestination() {
        String airportName = "Las Palmas de Gran Canaria";
        String shortCode = "LPA";

        return DomainFactory.newDestination(airportName, shortCode);
    }

}
