package com.mylab.learn.myarchetype.test;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import com.mylab.learn.myarchetype.domain.Aircraft;
import com.mylab.learn.myarchetype.domain.Company;
import com.mylab.learn.myarchetype.repository.AircraftRepository;

@Repository
public class AircraftMockRepository implements AircraftRepository {

    @Override
    public void deleteAllInBatch() {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteInBatch(Iterable<Aircraft> arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Aircraft> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Aircraft> findAll(Sort arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Aircraft> findAll(Iterable<Long> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void flush() {
        // TODO Auto-generated method stub

    }

    @Override
    public Aircraft getOne(Long arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Aircraft> List<S> save(Iterable<S> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Aircraft saveAndFlush(Aircraft arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<Aircraft> findAll(Pageable arg0) {
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
    public void delete(Aircraft arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Iterable<? extends Aircraft> arg0) {
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
    public Aircraft findOne(Long arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Aircraft> S save(S arg0) {
        arg0.setId(1L);
        return arg0;
    }

    @Override
    public long count(Specification<Aircraft> arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Aircraft> findAll(Specification<Aircraft> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<Aircraft> findAll(Specification<Aircraft> arg0, Pageable arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Aircraft> findAll(Specification<Aircraft> arg0, Sort arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Aircraft findOne(Specification<Aircraft> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Aircraft> findByRegistration(String registration) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Aircraft> findByCompany(Company company) {
        // TODO Auto-generated method stub
        return null;
    }

}
