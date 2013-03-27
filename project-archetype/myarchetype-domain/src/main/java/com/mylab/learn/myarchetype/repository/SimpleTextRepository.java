package com.mylab.learn.myarchetype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.mylab.learn.myarchetype.domain.SimpleText;

/**
 * Persistence operations for {@link SimpleText} entity.
 * 
 * @author cmartin
 * 
 */
@Repository
public interface SimpleTextRepository extends JpaRepository<SimpleText, Long>, JpaSpecificationExecutor<SimpleText> {

	SimpleText findByText(String text);
}
