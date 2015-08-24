package com.intexsoft.slave.repository;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.intexsoft.slave.model.FrameOrder;
import com.intexsoft.slave.model.Order;
import com.intexsoft.slave.model.OrderType;


public interface OrderRepository extends EntityRepository<Order>{
	
	List<Order> findOrderByOrderNameIgnoreCase(String orderName);
	
	List<Order> findOrderByOrderStartTime(Date orderStartTime);
	
	List<Order> findOrderByOrderExecutionTime(Date orderExecutionTime);
	
	List<Order> findOrderByOrderType(OrderType orderType);
	
	List<Order> findOrderByFrameOrder(FrameOrder frameOrder);
	
	
	
	
	

}
