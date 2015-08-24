package com.intexsoft.slave.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORDER")
public class Order extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1301056922282435968L;
	
	@Column(name="NAME")
	public String orderName;
	
	@Column(name="START_TIME")
	public Date orderStartTime;
	
	@Column(name="EXECUTION_TIME")
	public Date orderExecutionTime;
	
	@Column(name = "COMMENT")
	public String orderComment;
	
	@OneToOne
	@JoinColumn(name = "TYPE")
	public OrderType orderType;
	
	@ManyToOne
	@JoinColumn(name = "FRAME")
	public FrameOrder frameOrder;
	
	

}
