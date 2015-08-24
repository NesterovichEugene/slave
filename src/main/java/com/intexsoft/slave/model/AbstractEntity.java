package com.intexsoft.slave.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Id;


@MappedSuperclass
public abstract class AbstractEntity extends VersionEntity implements BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3769694148579326997L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	public Long identity;

}
