package com.intexsoft.slave.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;


import com.intexsoft.slave.model.Order;
import com.intexsoft.slave.model.Work;
import com.intexsoft.slave.model.WorkType;


public interface WorkRepository extends EntityRepository<Work>{
	
	@Query("SELECT w from Work w WHERE w.workName LIKE ?1")
	List<Work> findWorkByName(String name);
	
	@Query("SELECT w from Work w WHERE w.workOrder = ?1")
	List<Work> findWorkByOrder(Order order);
	
	List<Work> findWorkByWorkStartTime(Date workStartTime);
	
	List<Work> findWorkByWorkExecutionTime(Date workExecutionTime);
	
	List<Work> findWorkByWorkType(WorkType workType);
	
	
	
	

}
