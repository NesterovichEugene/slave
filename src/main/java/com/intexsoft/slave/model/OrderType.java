package com.intexsoft.slave.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_TYPE")
public class OrderType extends AbstractEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1744932131590833641L;
	
	@Column(name ="NAME")
	public String orderTypeName;
	
	

}
