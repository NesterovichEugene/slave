package com.intexsoft.slave.controller;

import java.util.Collection;
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
import com.intexsoft.slave.model.Work;
import com.intexsoft.slave.services.FrameOrderService;
import com.intexsoft.slave.services.OrderService;

@RestController
@RequestMapping("/frame_order")
public class FrameOrderController {
	@Autowired
	private FrameOrderService frameOrderService;

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/{id}/loadOrders", method = RequestMethod.GET)
	public List<Order> listOrdersByFrameOrderId(@PathVariable("id") long id) {
		FrameOrder frameOrder = frameOrderService.findOne(id);

		return (List<Order>) orderService.findOrderByFrameOrder(frameOrder);
	}

	@RequestMapping(value = "/createFrameOrder", method = RequestMethod.POST)
	public FrameOrder create(@RequestBody @Valid FrameOrder frameOrder) {
		return frameOrderService.create(frameOrder);
	}

	@RequestMapping(value = "/loadFrameOrders", method = RequestMethod.GET)
	public List<FrameOrder> listFrameOrders() {
		return (List<FrameOrder>) frameOrderService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public FrameOrder get(@PathVariable("id") long id) {
		return frameOrderService.findOne(id);
	}

	@RequestMapping(value = "/editFrameOrder/{id}", method = RequestMethod.PUT)
	public FrameOrder update(@PathVariable("id") long id,
			@RequestBody @Valid FrameOrder frameOrder) {
		return frameOrderService.create(frameOrder);
	}

	@RequestMapping(value = "/deleteFrameOrder/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") long id) {
		frameOrderService.delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
}
