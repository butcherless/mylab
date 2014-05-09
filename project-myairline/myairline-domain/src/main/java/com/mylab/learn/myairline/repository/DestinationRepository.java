package com.mylab.learn.myairline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.mylab.learn.myairline.domain.Airline;
import com.mylab.learn.myairline.domain.Destination;

/**
 * Persistence operations for {@link Airline} entity.
 * 
 * @author cmartin
 * 
 */
@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long>,
        QueryDslPredicateExecutor<Destination> {

    Destination findByShortCode(String shortCode);

    Destination findByAirportName(String airportName);
}
