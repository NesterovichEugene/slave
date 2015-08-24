package com.intexsoft.slave.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FRAME_ORDER")
public class FrameOrder extends AbstractEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8842672244742356102L;
	
	@Column(name = "NAME")
	public String frameOrderName;
	
	@Column(name = "START_TIME")
	public Date frameOrderStartTime;
	
	@Column(name = "EXECUTION_TIME")
	public Date frameOrderExecutionTime;
	
	@Column(name ="COMMENT")
	public String frameOrderComment;

}
