package com.mylab.learn.myairline.repository;

import com.mylab.learn.myairline.domain.QAircraft;
import com.mysema.query.types.Predicate;

public class AircraftPredicates {

    public static Predicate belongsToAirline(final String airlineName) {
        QAircraft aircraft = QAircraft.aircraft;

        return aircraft.airline.name.eq(airlineName);
    }
}
