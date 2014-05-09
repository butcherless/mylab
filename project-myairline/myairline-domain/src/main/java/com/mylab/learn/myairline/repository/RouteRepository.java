package com.mylab.learn.myairline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.mylab.learn.myairline.domain.Airline;
import com.mylab.learn.myairline.domain.Route;

/**
 * Persistence operations for {@link Airline} entity.
 * 
 * @author cmartin
 * 
 */
@Repository
public interface RouteRepository extends JpaRepository<Route, Long>,
        QueryDslPredicateExecutor<Route> {

    Route findByName(String name);

}
