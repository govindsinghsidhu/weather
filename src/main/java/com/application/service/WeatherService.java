package com.application.service;

import java.util.List;

import com.application.bean.WeatherReport;

public interface WeatherService {

	 List<WeatherReport> getWeatherReport(String city);
}
