package com.intexsoft.slave.services.impl;

import java.util.List;

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
