package com.intexsoft.slave.services.impl;

import com.intexsoft.slave.model.AbstractEntity;
import com.intexsoft.slave.repository.EntityRepository;
import com.intexsoft.slave.services.EntityService;

public abstract class EntityServiceImpl<T extends AbstractEntity> implements EntityService<T>
{
	public abstract EntityRepository<T> getRepository();

	public T create(T entity)
	{
		return (T) getRepository().save(entity);
	}

	public Iterable<T> findAll()
	{
		return getRepository().findAll();
	}

	public Iterable<T> findAll(Iterable<Long> identities)
	{
		return getRepository().findAll(identities);
	}

	public T findOne(Long identity)
	{
		return (T) getRepository().findOne(identity);
	}

	public void delete(Long id)
	{
		getRepository().delete(id);
	}
	
	public T update (T entity){
		return getRepository().save(entity);
	}
}
