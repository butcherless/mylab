package com.mylab.learn.myarchetype.test;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import com.mylab.learn.myarchetype.domain.Destination;
import com.mylab.learn.myarchetype.repository.DestinationRepository;

@Repository
public class DestinationMockRepository implements DestinationRepository {

    @Override
    public void deleteAllInBatch() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteInBatch(Iterable<Destination> arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Destination> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Destination> findAll(Sort arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Destination> findAll(Iterable<Long> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void flush() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Destination getOne(Long arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Destination> List<S> save(Iterable<S> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Destination saveAndFlush(Destination arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<Destination> findAll(Pageable arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void delete(Long arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Destination arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Iterable<? extends Destination> arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean exists(Long arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Destination findOne(Long arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Destination> S save(S arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long count(Specification<Destination> arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Destination> findAll(Specification<Destination> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<Destination> findAll(Specification<Destination> arg0, Pageable arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Destination> findAll(Specification<Destination> arg0, Sort arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Destination findOne(Specification<Destination> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Destination findByShortCode(String shortCode) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
