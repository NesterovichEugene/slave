package com.intexsoft.slave.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intexsoft.slave.model.AbstractEntity;
import com.intexsoft.slave.repository.EntityRepository;
import com.intexsoft.slave.services.EntityService;


public abstract class EntityServiceImpl<T extends AbstractEntity> implements
		EntityService<T> {
	
	public abstract EntityRepository<T> getRepository();

	@SuppressWarnings("unchecked")
	public T create(T entity) {
		return (T) getRepository().save(entity);
		
	}

	public Iterable<T> findAll(){
		return getRepository().findAll();
	}

	public Iterable<T> findAll(Iterable<Long> identities){
		return getRepository().findAll(identities);
	}

	

	public T findOne(Long identity){
		return (T) getRepository().findOne(identity);
	}

	public void delete(Long id){
		getRepository().delete(id);
	}

	
}
