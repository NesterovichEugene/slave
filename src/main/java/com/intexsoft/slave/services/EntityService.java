package com.intexsoft.slave.services;

import com.intexsoft.slave.model.AbstractEntity;

public interface EntityService<T extends AbstractEntity> {
	
	
	public T create(T entity);

	
	public Iterable<T> findAll();
	 
	public Iterable<T> findAll(Iterable<Long> identities);
	
	
	public T update(T entity);
	
	
	public T findOne(Long identity);
	
	
	public void delete(Long id);
	
	

}
