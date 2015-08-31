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
import com.intexsoft.slave.model.Work;
import com.intexsoft.slave.model.WorkType;
import com.intexsoft.slave.services.OrderService;
import com.intexsoft.slave.services.WorkService;

@RestController
@RequestMapping("/work")
public class WorkController
{
	
	private static final Logger LOGGER = getLogger(WorkController.class);
	@Autowired
	private WorkService workService;
	@Autowired
	private OrderService orderService;

	

	@RequestMapping(value = "/loadWorksByOrder", method = RequestMethod.GET)
	public List<Work> listOrderWorks(@RequestBody @Valid Order order)
	{
		return (List<Work>) workService.findWorkByOrder(order);
	}
	

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Work get(@PathVariable("id") long id)
	{
		return workService.findOne(id);
	}

	@RequestMapping(value = "/editWork", method = RequestMethod.PUT)
	public Work update(@RequestBody @Valid Work work)
	{
		return workService.update(work);
	}

	@RequestMapping(value = "/deleteWork", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@RequestBody @Valid Work work)
	{
		workService.delete(work.identity);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}

	@RequestMapping(value = "/modifyWorkType", method = RequestMethod.POST)
	public Work modifyWorkType(@RequestBody @Valid Work work, @RequestBody WorkType workType)
	{
		work.workType = workType;
		return workService.update(work);
	}
	
}
