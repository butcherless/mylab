package com.mylab.learn.myairline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.mylab.learn.myairline.domain.Airline;
import com.mylab.learn.myairline.domain.Location;

/**
 * Persistence operations for {@link Airline} entity.
 * 
 * @author cmartin
 * 
 */
@Repository
public interface DestinationRepository extends JpaRepository<Location, Long>,
        QueryDslPredicateExecutor<Location> {

    Location findByShortCode(String shortCode);

    Location findByAirportName(String airportName);
}
