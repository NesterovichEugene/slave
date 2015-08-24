package com.intexsoft.slave.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intexsoft.slave.model.FrameOrder;
import com.intexsoft.slave.repository.EntityRepository;
import com.intexsoft.slave.repository.FrameOrderRepository;
import com.intexsoft.slave.services.FrameOrderService;

@Service
@Transactional
public class FrameOrderServiceImpl extends EntityServiceImpl<FrameOrder> implements FrameOrderService{
	
	@Autowired
	private FrameOrderRepository frameOrderRepository;
	

	@Override
	public List<FrameOrder> findFrameOrderByFrameOrderName(String frameOrderName) {
		return frameOrderRepository.findFrameOrderByFrameOrderName(frameOrderName);
	}

	@Override
	public List<FrameOrder> findFrameOrderByFrameOrderStartTime(
			Date frameOrderStartTime) {
		return frameOrderRepository.findFrameOrderByFrameOrderStartTime(frameOrderStartTime);
	}

	@Override
	public List<FrameOrder> findFrameOrderByFrameOrderExecutionTime(
			Date frameOrderExecutionTime) {
		return frameOrderRepository.findFrameOrderByFrameOrderExecutionTime(frameOrderExecutionTime);
	}

	@Override
	public EntityRepository<FrameOrder> getRepository()
	{
		return frameOrderRepository;
	}

}
