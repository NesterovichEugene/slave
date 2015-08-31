package com.intexsoft.slave.services.impl;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intexsoft.slave.model.OrderType;
import com.intexsoft.slave.repository.EntityRepository;
import com.intexsoft.slave.repository.OrderTypeRepository;
import com.intexsoft.slave.services.OrderTypeService;

@Service
@Transactional
public class OrderTypeServiceImpl extends EntityServiceImpl<OrderType>
		implements OrderTypeService {
	
	private static final Logger LOGGER = getLogger(OrderTypeServiceImpl.class);

	@Autowired
	private OrderTypeRepository orderTypeRepository;

	@Override
	public List<OrderType> findOrderTypeByOrderTypeName(String orderTypeName) {

		return orderTypeRepository.findOrderTypeByOrderTypeName(orderTypeName);
	}

	@Override
	public EntityRepository<OrderType> getRepository()
	{
		return orderTypeRepository;
	}

}
