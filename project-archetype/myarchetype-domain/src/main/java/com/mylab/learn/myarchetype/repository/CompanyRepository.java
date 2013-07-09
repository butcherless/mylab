package com.mylab.learn.myarchetype.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.mylab.learn.myarchetype.domain.Company;

/**
 * Persistence operations for {@link Company} entity.
 * 
 * @author cmartin
 * 
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>, JpaSpecificationExecutor<Company> {

    List<Company> findByName(String name);

}
