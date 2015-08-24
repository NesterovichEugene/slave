package com.intexsoft.slave.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "WORK_TYPE")
public class WorkType extends AbstractEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6904519157474761861L;
	
	@Column(name ="NAME")
	public String workTypeName;

}
