package com.application.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.application.bean.WeatherReport;
import com.application.bean.WeatherReportResponse;
import com.application.common.ApplicationConstants;
import com.application.converter.ApplicationResponseConverter;
import com.application.errorcode.RestErrorCode;
import com.application.exception.RestException;
import com.application.service.WeatherService;
import com.application.validator.WeatherReportValidator;

@RestController
public class WeatherController {

	@Autowired
	WeatherService weatherService;

	final Logger LOGGER = LoggerFactory.getLogger(WeatherController.class);

	@GetMapping("/weather/{city}")
	public ResponseEntity<WeatherReportResponse> getCityWeather(@PathVariable String city) throws RestException {

		List<WeatherReport> weatherReportList = weatherService.getWeatherReport(city);

		if (WeatherReportValidator.weatherReportcheck.test(weatherReportList)) {
			LOGGER.error(ApplicationConstants.ERROR_CODE + RestErrorCode.NO_CITY_FOUND.getErrorCode()
					+ ApplicationConstants.ERROR_MESSAGE + RestErrorCode.NO_CITY_FOUND.getErrorMessage()
					+ ApplicationConstants.CITY + city);
			throw new RestException(RestErrorCode.NO_CITY_FOUND.getErrorMessage(),
					RestErrorCode.NO_CITY_FOUND.getErrorCode());
		}
		WeatherReportResponse weatherReportResponse = ApplicationResponseConverter
				.weatherReportResponse(weatherReportList);
		return ResponseEntity.ok()
				.cacheControl(CacheControl.maxAge(ApplicationConstants.CACHE_TIME, TimeUnit.MINUTES).mustRevalidate())
				.body(weatherReportResponse);

	}

}