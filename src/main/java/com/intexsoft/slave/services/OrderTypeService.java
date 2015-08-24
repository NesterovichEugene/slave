package com.intexsoft.slave.services;

import java.util.List;

import com.intexsoft.slave.model.OrderType;

public interface OrderTypeService extends EntityService<OrderType>{
	
	List<OrderType> findOrderTypeByOrderTypeName(String orderTypeName);

}
