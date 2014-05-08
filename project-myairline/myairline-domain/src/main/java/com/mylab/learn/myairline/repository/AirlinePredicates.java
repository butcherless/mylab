package com.mylab.learn.myairline.repository;

import com.mylab.learn.myairline.domain.QAirline;
import com.mysema.query.types.Predicate;

public class AirlinePredicates {

    public static Predicate nameEquals(final String searchTerm) {
        QAirline airline = QAirline.airline;

        return airline.name.eq(searchTerm);
    }
}
