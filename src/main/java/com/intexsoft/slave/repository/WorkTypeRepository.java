package com.intexsoft.slave.repository;

import java.util.List;

import com.intexsoft.slave.model.WorkType;


public interface WorkTypeRepository extends EntityRepository<WorkType>{
	
	List<WorkType> findWorkTypeByWorkTypeName(String workTypeName);

}
