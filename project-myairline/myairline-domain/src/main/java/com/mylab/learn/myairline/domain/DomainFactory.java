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
     * @return
     */
    public static Aircraft newAircraft(final String name, final String registration) {
        Aircraft entity = new Aircraft();
        entity.setName(name);
        entity.setRegistration(registration);

        return entity;
    }

    /**
     * 
     * @param airportName
     * @param shortCode
     * @return
     */
    public static Destination newDestination(final String airportName, final String shortCode) {
        Destination entity = new Destination();
        entity.setAirportName(airportName);
        entity.setShortCode(shortCode);

        return entity;
    }

    public static Route newRoute(final String name, final Destination startDestination,
            final Destination stopDestination) {
        Route route = new Route();
        route.setName(name);
        route.setStartDestination(startDestination);
        route.setStopDestination(stopDestination);

        return route;
    }
}
