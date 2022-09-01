package com.application.validator;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import com.application.bean.WeatherReport;
import com.application.common.ApplicationConstants;

public interface WeatherReportValidator {

	public Predicate<List<WeatherReport>> weatherReportcheck = weatherReportList -> (weatherReportList == null
			|| weatherReportList.size() == 0);
	public Predicate<List<com.application.bean.List>> weatherDatatcheck = weatherDatatList -> (weatherDatatList != null
			&& weatherDatatList.size() > 0);

	public Predicate<Double> temperatureCheck = temperature -> temperature > ApplicationConstants.TEMP_ALERT_LIMIT;
	public Predicate<Double> windCheck = windSpeed -> windSpeed > ApplicationConstants.WIND_ALERT_LIMIT;
	public Predicate<String> rainCheck = rainStatus -> rainStatus.contains(ApplicationConstants.RAIN);

	public BiFunction<Double, WeatherReport, WeatherReport> temeratureAlert = (temprature, weatherReport) -> {
		if (WeatherReportValidator.temperatureCheck.test(temprature))
			weatherReport.setTemperatureAlert(ApplicationConstants.USE_SUNSCREEN);
		return weatherReport;
	};
	public BiFunction<Double, WeatherReport, WeatherReport> windAlert = (windSpeed, weatherReport) -> {
		if (WeatherReportValidator.windCheck.test(windSpeed))
			weatherReport.setWindAlert(ApplicationConstants.TOO_WINDY);
		return weatherReport;
	};
	public BiFunction<String, WeatherReport, WeatherReport> rainAlert = (rainStatus, weatherReport) -> {
		if (WeatherReportValidator.rainCheck.test(rainStatus))
			weatherReport.setRainAlert(ApplicationConstants.CARRY_UMBRELLA);
		return weatherReport;
	};

	public static String getURI(String city) {

		return new StringBuilder().append(ApplicationConstants.BASE_URL).append(ApplicationConstants.VERSION)
				.append(ApplicationConstants.API_TYPE_PARAM).append(city).append(ApplicationConstants.APP_ID_PARAM)
				.append(ApplicationConstants.KEY).append(ApplicationConstants.COUNT_PARAM)
				.append(ApplicationConstants.DAY_COUNT).append(ApplicationConstants.UNITS_PARAM)
				.append(ApplicationConstants.UNITS).toString();
	}
}
