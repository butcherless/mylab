package com.mylab.learn.myarchetype.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.mylab.learn.myarchetype.domain.TemplateEntity;

public class TemplateRepositoryImpl implements TemplateRepository {

    @Override
    public void deleteAllInBatch() {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteInBatch(Iterable<TemplateEntity> arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<TemplateEntity> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<TemplateEntity> findAll(Sort arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<TemplateEntity> findAll(Iterable<Long> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void flush() {
        // TODO Auto-generated method stub

    }

    @Override
    public TemplateEntity getOne(Long arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends TemplateEntity> List<S> save(Iterable<S> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TemplateEntity saveAndFlush(TemplateEntity arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<TemplateEntity> findAll(Pageable arg0) {
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
    public void delete(TemplateEntity arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Iterable<? extends TemplateEntity> arg0) {
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
    public TemplateEntity findOne(Long arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends TemplateEntity> S save(S arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long count(Specification<TemplateEntity> arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<TemplateEntity> findAll(Specification<TemplateEntity> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<TemplateEntity> findAll(Specification<TemplateEntity> arg0, Pageable arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<TemplateEntity> findAll(Specification<TemplateEntity> arg0, Sort arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TemplateEntity findOne(Specification<TemplateEntity> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TemplateEntity findByName(String entityName) {
        // TODO Auto-generated method stub
        return null;
    }

}
