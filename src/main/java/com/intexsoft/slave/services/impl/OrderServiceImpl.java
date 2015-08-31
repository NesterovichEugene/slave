package com.intexsoft.slave.services.impl;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.Date;
import java.util.List;

import com.intexsoft.slave.model.FrameOrder;
import com.intexsoft.slave.model.Order;
import com.intexsoft.slave.model.OrderType;
import com.intexsoft.slave.model.Work;
import com.intexsoft.slave.repository.EntityRepository;
import com.intexsoft.slave.repository.OrderRepository;
import com.intexsoft.slave.repository.WorkRepository;
import com.intexsoft.slave.services.OrderService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl extends EntityServiceImpl<Order> implements
		OrderService {

	private static final Logger LOGGER = getLogger(OrderServiceImpl.class);
	
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private WorkRepository workRepository;

	@Override
	public List<Order> findOrderByOrderNameIgnoreCase(String orderName) {
		return orderRepository.findOrderByOrderNameIgnoreCase(orderName);
	}

	@Override
	public List<Order> findOrderByOrderStartTime(Date orderStartTime) {
		return orderRepository.findOrderByOrderStartTime(orderStartTime);
	}

	@Override
	public List<Order> findOrderByOrderExecutionTime(Date orderExecutionTime) {
		return orderRepository
				.findOrderByOrderExecutionTime(orderExecutionTime);
	}

	@Override
	public List<Order> findOrderByOrderType(OrderType orderType) {
		return orderRepository.findOrderByOrderType(orderType);
	}

	@Override
	public List<Order> findOrderByFrameOrder(FrameOrder frameOrder) {

		return orderRepository.findOrderByFrameOrder(frameOrder);
	}

	@Override
	public EntityRepository<Order> getRepository() {
		return orderRepository;
	}

	@Override
	public void delete(Long id) {
		Order order = orderRepository.findOne(id);
		for (Work work : workRepository.findWorkByOrder(order)) {
			workRepository.delete(work);
		}
		super.delete(id);
		

	}

}
