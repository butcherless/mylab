package com.mylab.learn.jaranalyzer.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.mylab.learn.jaranalyzer.domain.JarFileBean;

public interface JarFileBeanRepository extends GraphRepository<JarFileBean> {

    JarFileBean findBySha1Hex(String sha1Hex);

}
