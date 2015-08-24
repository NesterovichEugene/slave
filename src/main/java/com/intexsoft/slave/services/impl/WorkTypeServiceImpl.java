package com.intexsoft.slave.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intexsoft.slave.model.WorkType;
import com.intexsoft.slave.repository.EntityRepository;
import com.intexsoft.slave.repository.WorkTypeRepository;
import com.intexsoft.slave.services.WorkTypeService;

@Service
@Transactional
public class WorkTypeServiceImpl extends EntityServiceImpl<WorkType> implements WorkTypeService{
	
	@Autowired
	private WorkTypeRepository workTypeRepository;

	@Override
	public List<WorkType> findWorkTypeByWorkTypeName(String workTypeName) {
		return workTypeRepository.findWorkTypeByWorkTypeName(workTypeName);
	}

	@Override
	public EntityRepository<WorkType> getRepository()
	{
		return workTypeRepository;
	}

}
