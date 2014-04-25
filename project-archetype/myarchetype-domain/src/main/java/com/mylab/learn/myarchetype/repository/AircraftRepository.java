package com.mylab.learn.myarchetype.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.mylab.learn.myarchetype.domain.Aircraft;
import com.mylab.learn.myarchetype.domain.Company;

/**
 * Persistence operations for {@link Aircraft} entity.
 * 
 * @author cmartin
 * 
 */
@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Long>,
        JpaSpecificationExecutor<Aircraft> {

    List<Aircraft> findByRegistration(String registration);

    List<Aircraft> findByCompany(Company company);
}
