package com.application.converter;

import java.util.List;
import java.util.function.Consumer;

import com.application.dto.WeatherReport;
import com.application.dto.WeatherReportResponse;

public interface ApplicationResponseConverter {
	public static WeatherReportResponse weatherReportResponse(List<WeatherReport> weatherReportList) {
		WeatherReportResponse weatherReportResponse = new WeatherReportResponse();
		Consumer<WeatherReport> addReportConsumer = weatherReport -> weatherReportResponse
				.addWeatherReportsItem(weatherReport);
		weatherReportList.forEach(addReportConsumer);

		return weatherReportResponse;
	}

}
