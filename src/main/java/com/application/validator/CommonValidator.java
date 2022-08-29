package com.application.validator;

import java.util.List;
import java.util.function.Predicate;

import com.application.bean.WeatherReport;
import com.application.common.ApplicationConstants;

public interface CommonValidator {

	public Predicate<List<WeatherReport>> checkWeatherReportList = list -> (list == null || list.size() == 0);
	public Predicate<Double> temperatureCheck = temperature -> temperature > ApplicationConstants.TEMP_ALERT_LIMIT;
	public Predicate<Double> windCheck = windSpeed -> windSpeed > ApplicationConstants.WIND_ALERT_LIMIT;
	public Predicate<String> rainCheck = rainStatus -> rainStatus.contains(ApplicationConstants.RAIN);
	
	public static String getURI(String city) {

		return new StringBuilder()
	    .append(ApplicationConstants.BASE_URL)
	    .append(ApplicationConstants.VERSION)
	    .append(ApplicationConstants.API_TYPE_PARAM)
	    .append(city)
	    .append(ApplicationConstants.APP_ID_PARAM)
	    .append(ApplicationConstants.KEY)
	    .append(ApplicationConstants.COUNT_PARAM)
	    .append(ApplicationConstants.DAY_COUNT)
	    .append(ApplicationConstants.UNITS_PARAM)
	    .append(ApplicationConstants.UNITS)
	    .toString();
	}
}
