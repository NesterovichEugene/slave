package com.intexsoft.slave.services;

import java.util.List;

import com.intexsoft.slave.model.WorkType;

public interface WorkTypeService extends EntityService<WorkType>{
	
	
	List<WorkType> findWorkTypeByWorkTypeName(String workTypeName);

}
