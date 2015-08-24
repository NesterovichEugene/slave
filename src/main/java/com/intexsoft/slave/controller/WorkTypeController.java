package com.intexsoft.slave.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.intexsoft.slave.model.WorkType;
import com.intexsoft.slave.services.WorkTypeService;

@RestController
public class WorkTypeController
{
	
	@Autowired
	private WorkTypeService workTypeService;
	
	@RequestMapping(value = "/loadWorkTypes", method = RequestMethod.GET)
	public List<WorkType> list()
	{
		return (List<WorkType>) workTypeService.findAll();
	}
	
	
}
