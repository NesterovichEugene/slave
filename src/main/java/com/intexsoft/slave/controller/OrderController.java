package com.intexsoft.slave.controller;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intexsoft.slave.model.Order;
import com.intexsoft.slave.model.OrderType;
import com.intexsoft.slave.model.Work;
import com.intexsoft.slave.services.FrameOrderService;
import com.intexsoft.slave.services.OrderService;
import com.intexsoft.slave.services.WorkService;

@RestController
@RequestMapping("/orders")
public class OrderController
{
	
	private static final Logger LOGGER = getLogger(OrderController.class);
	
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private WorkService workService;
	@Autowired
	private FrameOrderService frameOrderService;

	

	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public Order create(@RequestBody @Valid Order order)
	{
		return orderService.create(order);
	}

	@RequestMapping(value = "/loadOrders", method = RequestMethod.GET)
	public List<Order> list()
	{
		return (List<Order>) orderService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Order get(@PathVariable("id") long id)
	{
		return orderService.findOne(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Order update(@RequestBody Order order)
	{
		return orderService.create(order);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") long id)
	{
		orderService.delete(id);
		
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}

	@RequestMapping(value = "/modifyOrderType", method = RequestMethod.POST)
	public Order modifyOrderType(@RequestBody @Valid Order order, @RequestBody OrderType orderType)
	{
		order.orderType = orderType;
		return orderService.update(order);
	}

	@RequestMapping(value = "/addWorkToOrder", method = RequestMethod.POST)
	public Order addToOrder(@RequestBody @Valid Order order, @RequestBody Work work)
	{
		work.workOrder = order;
		workService.create(work);
		return orderService.create(order);
	}
}
