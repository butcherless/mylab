package com.mylab.learn.myarchetype.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.mylab.learn.myarchetype.domain.TemplateEntity;

public class TemplateRepositoryImpl implements TemplateRepository {

	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	public void deleteInBatch(Iterable<TemplateEntity> arg0) {
		// TODO Auto-generated method stub

	}

	
	public List<TemplateEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<TemplateEntity> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void flush() {
		// TODO Auto-generated method stub

	}

	
	public <S extends TemplateEntity> List<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public TemplateEntity saveAndFlush(TemplateEntity arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Page<TemplateEntity> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public void delete(Long arg0) {
		// TODO Auto-generated method stub

	}

	
	public void delete(TemplateEntity arg0) {
		// TODO Auto-generated method stub

	}

	
	public void delete(Iterable<? extends TemplateEntity> arg0) {
		// TODO Auto-generated method stub

	}

	
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	
	public boolean exists(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public Iterable<TemplateEntity> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public TemplateEntity findOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public <S extends TemplateEntity> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public long count(Specification<TemplateEntity> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public List<TemplateEntity> findAll(Specification<TemplateEntity> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Page<TemplateEntity> findAll(Specification<TemplateEntity> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<TemplateEntity> findAll(Specification<TemplateEntity> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public TemplateEntity findOne(Specification<TemplateEntity> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public TemplateEntity findByName(String entityName) {
	    // TODO Auto-generated method stub
	    return null;
    }

}
