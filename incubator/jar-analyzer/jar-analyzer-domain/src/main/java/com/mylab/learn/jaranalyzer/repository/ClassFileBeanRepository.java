package com.mylab.learn.jaranalyzer.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.mylab.learn.jaranalyzer.domain.ClassFileBean;

public interface ClassFileBeanRepository extends GraphRepository<ClassFileBean> {

}
