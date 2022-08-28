package com.application.common;

import java.io.IOException;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ApplicationDataRepository {
	public static Properties restErrorCodeProperties = new Properties();
	public static Properties serviceErrorCodeProperties = new Properties();
	public static Properties weatherAPIProperties = new Properties();
	
	protected final Log logger = LogFactory.getLog(ApplicationDataRepository.class);
	public void init() {
		try {

			restErrorCodeProperties.load(ApplicationDataRepository.class.getClassLoader().getResourceAsStream("RestErrorCode.properties"));
			serviceErrorCodeProperties.load(ApplicationDataRepository.class.getClassLoader().getResourceAsStream("ServiceErrorCode.properties"));
			weatherAPIProperties.load(ApplicationDataRepository.class.getClassLoader().getResourceAsStream("WeatherAPI.properties"));

		} catch (IOException ex) {
			logger.error(ex);
		} 
	}

}
