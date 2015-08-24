package com.intexsoft.slave.run;

import java.io.File;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.apache.commons.lang3.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides a quick way to start up embedded Tomcat server for testing purposes.
 */
public class Bootstrap
{
	private static final String CATALINA_HOME_PROPERTY_NAME = "catalina.home";
	private static final Logger LOGGER = LoggerFactory.getLogger(Bootstrap.class);
	private static final String CATALINA_HOME_DIR_NAME = ".";
	private static final String WEBAPP_DIR_LOCATION = "src/main/webapp";
	private static final String BASE_DIR = "dev";
	private static final String CONTEXT_PATH = "/";
	private static final int PORT = 8080;

	public static void main(String[] args) throws Exception
	{
		System.setProperty(CATALINA_HOME_PROPERTY_NAME, new File(CATALINA_HOME_DIR_NAME).getAbsolutePath());
		File webappDir = new File(WEBAPP_DIR_LOCATION);
		LOGGER.debug("Configuring web app with basedir: {}", webappDir.getAbsolutePath());
		Tomcat tomcat = new Tomcat();
		tomcat.setBaseDir(BASE_DIR);
		tomcat.setPort(PORT);
		Connector connector = tomcat.getConnector();
		connector.setURIEncoding(CharEncoding.UTF_8);
		tomcat.addWebapp(CONTEXT_PATH, webappDir.getAbsolutePath());
		tomcat.start();
		tomcat.getServer().await();
	}
}
