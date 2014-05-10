package com.mylab.learn.myairline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.mylab.learn.myairline.domain.Aircraft;
import com.mylab.learn.myairline.domain.Airline;

/**
 * Persistence operations for {@link Airline} entity.
 * 
 * @author cmartin
 * 
 */
@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Long>,
        QueryDslPredicateExecutor<Aircraft> {

    Aircraft findByName(String name);
}
