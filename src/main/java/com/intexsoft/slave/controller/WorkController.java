package com.intexsoft.slave.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intexsoft.slave.model.FrameOrder;
import com.intexsoft.slave.model.Order;
import com.intexsoft.slave.model.OrderType;
import com.intexsoft.slave.model.Work;
import com.intexsoft.slave.model.WorkType;
import com.intexsoft.slave.services.OrderService;
import com.intexsoft.slave.services.WorkService;

@RestController
@RequestMapping("/work")
public class WorkController
{
	@Autowired
	private WorkService workService;
	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/addWorkToOrder", method = RequestMethod.POST)
	public Order addToOrder(@PathVariable String orderId, @RequestBody Work work)
	{
		Order order = orderService.findOne(Long.getLong(orderId));
		work.workOrder = order;
		workService.create(work);
		return orderService.create(order);
	}

	

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Work get(@PathVariable("id") long id)
	{
		return workService.findOne(id);
	}

	@RequestMapping(value = "/editWork/{id}", method = RequestMethod.PUT)
	public Work update(@PathVariable("id") long id, @RequestBody @Valid Work work)
	{
		return workService.create(work);
	}

	@RequestMapping(value = "/deleteWork/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") long id)
	{
		workService.delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}

	@RequestMapping(value = "/modifyWorkType", method = RequestMethod.POST)
	public Work modifyWorkType(@PathVariable String workId, @RequestBody WorkType workType)
	{
		Work work = workService.findOne(Long.getLong(workId));
		work.workType = workType;
		return workService.create(work);
	}
	// add, delete, update, read
}
