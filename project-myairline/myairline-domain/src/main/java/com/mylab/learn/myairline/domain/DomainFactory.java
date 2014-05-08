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
}
