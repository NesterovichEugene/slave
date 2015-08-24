package com.intexsoft.slave.services;

import java.util.Date;
import java.util.List;

import com.intexsoft.slave.model.FrameOrder;

public interface FrameOrderService extends EntityService<FrameOrder> {

	List<FrameOrder> findFrameOrderByFrameOrderName(String frameOrderName);

	List<FrameOrder> findFrameOrderByFrameOrderStartTime(
			Date frameOrderStartTime);

	List<FrameOrder> findFrameOrderByFrameOrderExecutionTime(
			Date frameOrderExecutionTime);

}
