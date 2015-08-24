package com.intexsoft.slave.path;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

/**
 * Uses for sets null to lazy property
 */
public class TradeObjectMapper extends ObjectMapper
{
	private static final long serialVersionUID = 4302576592465169888L;

	/**
	 * Constructor-register
	 */
	public TradeObjectMapper()
	{
		// Hibernate feature
		Hibernate4Module hibernate4Module = new Hibernate4Module();
		hibernate4Module.configure(Hibernate4Module.Feature.USE_TRANSIENT_ANNOTATION, false);
		registerModule(hibernate4Module);
		// Serialization feature
		configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		// Deserialization Feature
		configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
}
