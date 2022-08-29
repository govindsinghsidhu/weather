package com.application.common;

public interface ApplicationConstants {
	public final String VERSION = ApplicationDataRepository.weatherAPIProperties.getProperty("version");
	public final String BASE_URL = ApplicationDataRepository.weatherAPIProperties.getProperty("baseurl");
	public final String KEY = ApplicationDataRepository.weatherAPIProperties.getProperty("key");
	public final String DAY_COUNT = ApplicationDataRepository.weatherAPIProperties.getProperty("dayCount");
	public final String UNITS = ApplicationDataRepository.weatherAPIProperties.getProperty("units");
	public final String ACCESS_DENIED = "Access Denied";
	public final String NOT_CONTENT = "city not found";
	public final String CARRY_UMBRELLA = "Carry umbrella";
	public final String TOO_WINDY = "It's too windy, watch out!";
	public final String USE_SUNSCREEN = "Use sunscreen lotion";
	public final String RAIN = "Rain";
	public final String API_TYPE_PARAM = "/forecast?q=";
	public final String APP_ID_PARAM = "&appid=";
	public final String COUNT_PARAM = "&cnt=";
	public final String UNITS_PARAM = "&units=";
	public final String CITY = " city : ";
	public final String ERROR_CODE = "Error Code ";
	public final String ERROR_MESSAGE = " Error Message ";
	public final double TEMP_ALERT_LIMIT = Double
			.parseDouble(ApplicationDataRepository.weatherAPIProperties.getProperty("tempAlertLimit"));
	public final double WIND_ALERT_LIMIT = Double
			.parseDouble(ApplicationDataRepository.weatherAPIProperties.getProperty("windAlertLimit"));
	public final int CACHE_TIME = Integer
			.parseInt(ApplicationDataRepository.weatherAPIProperties.getProperty("cacheTime"));

}
