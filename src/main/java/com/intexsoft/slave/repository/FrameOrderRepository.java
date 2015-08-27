package com.intexsoft.slave.repository;

import java.util.Date;
import java.util.List;

import com.intexsoft.slave.model.FrameOrder;


public interface FrameOrderRepository extends EntityRepository<FrameOrder>{
	
	
	List<FrameOrder> findFrameOrderByFrameOrderName(String frameOrderName);
	
	List<FrameOrder> findFrameOrderByFrameOrderStartTime(Date frameOrderStartTime);
	
	List<FrameOrder> findFrameOrderByFrameOrderExecutionTime(Date frameOrderExecutionTime);
	
}
