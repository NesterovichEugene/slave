package com.intexsoft.slave.services.impl;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intexsoft.slave.model.FrameOrder;
import com.intexsoft.slave.model.Order;
import com.intexsoft.slave.repository.EntityRepository;
import com.intexsoft.slave.repository.FrameOrderRepository;
import com.intexsoft.slave.services.FrameOrderService;

@Service
@Transactional
public class FrameOrderServiceImpl extends EntityServiceImpl<FrameOrder> implements FrameOrderService{
	
	private static final Logger LOGGER = getLogger(FrameOrderServiceImpl.class);
	
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

	@Override
	public void addOrderToFrameOrder(FrameOrder frameOrder, Order order) {
		frameOrder.orders.add(order);
		update(frameOrder);
		
	}

}
