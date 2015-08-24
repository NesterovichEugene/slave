package com.intexsoft.slave.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;


@MappedSuperclass
public abstract class VersionEntity {
	
	/**
	 * Version of entity
	 */
	@Version
	@Column(name = "VERSION", nullable = false)
	public long version;

}
