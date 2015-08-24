package com.intexsoft.slave.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.intexsoft.slave.model.OrderType;


public interface OrderTypeRepository extends EntityRepository<OrderType>{
	
	List<OrderType> findOrderTypeByOrderTypeName(String orderTypeName);

}
