package com.mylab.learn.myarchetype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.mylab.learn.myarchetype.domain.Destination;

/**
 * Persistence operations for {@link Destination} entity.
 * 
 * @author cmartin
 * 
 */
@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long>,
        JpaSpecificationExecutor<Destination> {

    Destination findByShortCode(String shortCode);
}
