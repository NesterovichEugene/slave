package com.intexsoft.slave.services.impl;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intexsoft.slave.model.Order;
import com.intexsoft.slave.model.Work;
import com.intexsoft.slave.model.WorkType;
import com.intexsoft.slave.repository.EntityRepository;
import com.intexsoft.slave.repository.WorkRepository;
import com.intexsoft.slave.services.WorkService;

@Service
@Transactional
public class WorkServiceImpl extends EntityServiceImpl<Work> implements WorkService{
	
	private static final Logger LOGGER = getLogger(WorkServiceImpl.class);
	
	@Autowired
	private WorkRepository workRepository;

	@Override
	public List<Work> findWorkByName(String name) {
		return workRepository.findWorkByName(name);
	}

	@Override
	public List<Work> findWorkByOrder(Order order) {
		return workRepository.findWorkByOrder(order);
	}

	@Override
	public List<Work> findWorkByWorkStartTime(Date workStartTime) {
		
		return workRepository.findWorkByWorkStartTime(workStartTime);
	}

	@Override
	public List<Work> findWorkByWorkExecutionTime(Date workExecutionTime) {
	
		return workRepository.findWorkByWorkExecutionTime(workExecutionTime);
	}

	@Override
	public List<Work> findWorkByWorkType(WorkType workType) {
		return workRepository.findWorkByWorkType(workType);
	}

	@Override
	public EntityRepository<Work> getRepository()
	{
		return workRepository;
	}
	
	

}
