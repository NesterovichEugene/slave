package com.intexsoft.slave.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "frameOrder",
		cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	public List<Order> orders;
}
