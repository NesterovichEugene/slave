package com.intexsoft.slave.services;

import java.util.Date;
import java.util.List;

import com.intexsoft.slave.model.FrameOrder;
import com.intexsoft.slave.model.Order;
import com.intexsoft.slave.model.OrderType;

public interface OrderService extends EntityService<Order>
{
	List<Order> findOrderByOrderNameIgnoreCase(String orderName);

	List<Order> findOrderByOrderStartTime(Date orderStartTime);

	List<Order> findOrderByOrderExecutionTime(Date orderExecutionTime);

	List<Order> findOrderByOrderType(OrderType orderType);

	List<Order> findOrderByFrameOrder(FrameOrder frameOrder);
}
