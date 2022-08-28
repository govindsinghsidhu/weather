package com.application.converter;

import java.util.List;

import com.application.bean.WeatherReport;
import com.application.bean.WeatherReportResponse;

public interface ApplicationResponseConverter {
	public static WeatherReportResponse weatherReportResponse(List<WeatherReport> weatherReportList) {
		WeatherReportResponse weatherReportResponse = new  WeatherReportResponse();
		weatherReportList.forEach(weatherReport -> weatherReportResponse.addWeatherReportsItem(weatherReport));
		
		return weatherReportResponse;
	}

}
