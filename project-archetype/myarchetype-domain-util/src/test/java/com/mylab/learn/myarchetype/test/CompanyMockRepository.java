package com.mylab.learn.myarchetype.test;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import com.mylab.learn.myarchetype.domain.Company;
import com.mylab.learn.myarchetype.repository.CompanyRepository;

@Repository
public class CompanyMockRepository implements CompanyRepository {

    @Override
    public void deleteAllInBatch() {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteInBatch(Iterable<Company> arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Company> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Company> findAll(Sort arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Company> findAll(Iterable<Long> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void flush() {
        // TODO Auto-generated method stub

    }

    @Override
    public Company getOne(Long arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Company> List<S> save(Iterable<S> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Company saveAndFlush(Company arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<Company> findAll(Pageable arg0) {
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
    public void delete(Company arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Iterable<? extends Company> arg0) {
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
    public Company findOne(Long arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Company> S save(S arg0) {
        arg0.setId(1L);
        return arg0;
    }

    @Override
    public long count(Specification<Company> arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Company> findAll(Specification<Company> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<Company> findAll(Specification<Company> arg0, Pageable arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Company> findAll(Specification<Company> arg0, Sort arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Company findOne(Specification<Company> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Company findByName(String name) {
        // TODO Auto-generated method stub
        Company company = new Company();
        if (name.equals("companyName")) {
            company.setId(1L);
        }
        return company;
    }

}
