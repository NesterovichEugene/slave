package com.intexsoft.slave.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.intexsoft.slave.model.Order;
import com.intexsoft.slave.model.Work;
import com.intexsoft.slave.model.WorkType;

public interface WorkService extends EntityService<Work>{
	
	List<Work> findWorkByName(String name);
	
	List<Work> findWorkByOrder(Order order);
	
	List<Work> findWorkByWorkStartTime(Date workStartTime);
	
	List<Work> findWorkByWorkExecutionTime(Date workExecutionTime);
	
	List<Work> findWorkByWorkType(WorkType workType);
	

}
