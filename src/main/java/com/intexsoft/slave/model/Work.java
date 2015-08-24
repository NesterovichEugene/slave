package com.intexsoft.slave.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "WORK")
public class Work extends AbstractEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2409504662485446031L;
	
	@Column(name = "NAME")
	public String workName;
	
	
	@Column(name = "START_TIME")
	public Date workStartTime;
	
	@Column(name = "EXECUTION_TIME")
	public Date workExecutionTime;
	
	@OneToOne
	@JoinColumn(name = "TYPE")
	public WorkType workType;
	
	@ManyToOne
	@JoinColumn(name = "WORK_ORDER")
	public Order workOrder;

	
}
