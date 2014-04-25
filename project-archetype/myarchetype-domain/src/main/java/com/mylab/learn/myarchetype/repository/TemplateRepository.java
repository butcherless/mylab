package com.mylab.learn.myarchetype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.mylab.learn.myarchetype.domain.TemplateEntity;

/**
 * Persistence operations for {@link TemplateEntity} entity.
 * 
 * @author cmartin
 * 
 */
@Repository
public interface TemplateRepository extends JpaRepository<TemplateEntity, Long>,
        JpaSpecificationExecutor<TemplateEntity> {

    TemplateEntity findByName(String entityName);
}
