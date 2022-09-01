package com.application.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.application.common.ApplicationConstants;
import com.application.dto.Weather;
import com.application.dto.WeatherData;
import com.application.dto.WeatherReport;
import com.application.validator.WeatherReportValidator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("WeatherService")
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	RestTemplate restTemplate;

	final Logger LOGGER = LoggerFactory.getLogger(WeatherServiceImpl.class);

	@Override
	public List<WeatherReport> getWeatherReport(String city) {

		WeatherData weatherData = fetchWeatherData(city);
		return buildWeatherReport(weatherData);
	}

	private List<WeatherReport> buildWeatherReport(WeatherData weatherData) {
		List<WeatherReport> weatherReportList = new ArrayList<>();
		List<com.application.dto.List> weatherDataList = weatherData.getList();

		if (WeatherReportValidator.weatherDatatcheck.test(weatherDataList)) {
			Consumer<com.application.dto.List> weatherDataConsumer = getWeatherDataConsumer(weatherData,
					weatherReportList);
			weatherDataList.forEach(weatherDataConsumer);
		}

		return weatherReportList;

	}

	private String getURI(String city) {

		return new StringBuilder().append(ApplicationConstants.BASE_URL).append(ApplicationConstants.VERSION)
				.append(ApplicationConstants.API_TYPE_PARAM).append(city).append(ApplicationConstants.APP_ID_PARAM)
				.append(ApplicationConstants.KEY).append(ApplicationConstants.COUNT_PARAM)
				.append(ApplicationConstants.DAY_COUNT).append(ApplicationConstants.UNITS_PARAM)
				.append(ApplicationConstants.UNITS).toString();
	}

	private WeatherData fetchWeatherData(String city) {
		WeatherData weatherData = new WeatherData();
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<String>(headers);

			String jsonResult = restTemplate.exchange(getURI(city), HttpMethod.GET, entity, String.class).getBody();

			ObjectMapper om = new ObjectMapper();
			weatherData = om.readValue(jsonResult, WeatherData.class);

		} catch (HttpClientErrorException | JsonProcessingException e) {
			LOGGER.error(e.getMessage());
		}
		return weatherData;

	}

	private Consumer<com.application.dto.List> getWeatherDataConsumer(WeatherData weatherData,
			List<WeatherReport> weatherReportList) {
		Consumer<com.application.dto.List> weatherDataConsumer = (list) -> {

			WeatherReport weatherReport = new WeatherReport();

			double maxTemperature = list.getMain().getTemp_max();
			double windSpeed = list.getWind().getSpeed();

			weatherReport.setCity(weatherData.getCity().getName());
			weatherReport.setHighTemperature(maxTemperature);
			weatherReport.setLowTemperature(list.getMain().getTemp_min());
			weatherReport.setWindSpeed(windSpeed);
			Weather weather = list.getWeather().get(0);
			weatherReport.setCloud(weather.getDescription());

			WeatherReportValidator.temeratureAlert.apply(maxTemperature, weatherReport);
			WeatherReportValidator.windAlert.apply(windSpeed, weatherReport);
			WeatherReportValidator.rainAlert.apply(weather.getMain(), weatherReport);

			weatherReportList.add(weatherReport);
		};

		return weatherDataConsumer;

	}

}
