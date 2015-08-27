package com.intexsoft.slave.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intexsoft.slave.model.OrderType;
import com.intexsoft.slave.services.OrderService;
import com.intexsoft.slave.services.OrderTypeService;

@RestController
@RequestMapping("/order_types")
public class OrderTypeController
{
	
	@Autowired
	private OrderTypeService orderTypeService;
	
	@Autowired 
	private OrderService orderService;
	
	@RequestMapping(value = "/loadOrderTypes", method = RequestMethod.GET)
	public List<OrderType> list()
	{
		return (List<OrderType>) orderTypeService.findAll();
	}
	
	//list, select
}
