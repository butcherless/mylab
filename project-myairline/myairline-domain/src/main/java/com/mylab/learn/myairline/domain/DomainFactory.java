package com.mylab.learn.myairline.domain;

/**
 * Helper for entity creation
 * 
 * @author cmartin
 * 
 */
public class DomainFactory {

    public static Airline newAirline(final String name) {
        Airline airline = new Airline();
        airline.setName(name);

        return airline;
    }

    /**
     * 
     * @param name
     * @param registration
     * @param airline
     * @return
     */
    public static Aircraft newAircraft(final String name, final String registration,
            final Airline airline) {
        Aircraft entity = new Aircraft();
        entity.setName(name);
        entity.setRegistration(registration);
        entity.setAirline(airline);
        airline.addAircraft(entity);

        return entity;
    }

    /**
     * 
     * @param airportName
     * @param shortCode
     * @return
     */
    public static Location newDestination(final String airportName, final String shortCode) {
        Location entity = new Location();
        entity.setAirportName(airportName);
        entity.setShortCode(shortCode);

        return entity;
    }

    public static Route newRoute(final String name, final Location origin,
            final Location destination) {
        Route route = new Route();
        route.setName(name);
        route.setOrigin(origin);
        route.setDestination(destination);

        return route;
    }
}
