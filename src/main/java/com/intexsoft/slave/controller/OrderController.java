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
import com.intexsoft.slave.services.FrameOrderService;
import com.intexsoft.slave.services.OrderService;
import com.intexsoft.slave.services.WorkService;

@RestController
@RequestMapping("/orders")
public class OrderController
{
	@Autowired
	private OrderService orderService;
	@Autowired
	private WorkService workService;
	@Autowired
	private FrameOrderService frameOrderService;

	@RequestMapping(value ="/addOrderToFrameOrder",method = RequestMethod.POST)
	public Order addToFrameOrder(@PathVariable String frameOrderId, @RequestBody Order order)
	{
		FrameOrder frameOrder = frameOrderService.findOne(Long.getLong(frameOrderId));
		order.frameOrder = frameOrder;
		return orderService.create(order);
	}

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

	@RequestMapping(value = "/editOrder/{id}", method = RequestMethod.PUT)
	public Order update(@PathVariable("id") long id, @RequestBody @Valid Order order)
	{
		return orderService.create(order);
	}

	@RequestMapping(value = "/deleteOrder/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") long id)
	{
		orderService.delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/modifyOrderType",method = RequestMethod.POST)
	public Order modifyOrderType(@PathVariable String orderId, @RequestBody OrderType orderType) {
		Order order = orderService.findOne(Long.getLong(orderId));
		order.orderType = orderType;
		return orderService.create(order);

	}
	
	@RequestMapping(value = "/{id}/loadWorks", method = RequestMethod.GET)
	public List<Work> listOrderWorks(@PathVariable("id") long id)
	{
		Order order = orderService.findOne(id);
		return (List<Work>) workService.findWorkByOrder(order);
	}
}
