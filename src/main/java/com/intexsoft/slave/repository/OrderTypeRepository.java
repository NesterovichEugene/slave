package com.intexsoft.slave.repository;

import java.util.List;

import com.intexsoft.slave.model.OrderType;


public interface OrderTypeRepository extends EntityRepository<OrderType>{
	
	List<OrderType> findOrderTypeByOrderTypeName(String orderTypeName);

}
