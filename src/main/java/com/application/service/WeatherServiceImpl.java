package com.application.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

import com.application.bean.Weather;
import com.application.bean.WeatherData;
import com.application.bean.WeatherReport;
import com.application.validator.WeatherReportValidator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("WeatherService")
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	RestTemplate restTemplate;
	
	final Logger LOGGER = LoggerFactory.getLogger(WeatherServiceImpl.class);
	

	@Override
	public List<WeatherReport> getWeatherReport(String city){
		
		WeatherData weatherData = fetchWeatherData(city);
		return buildWeatherReport(weatherData);
	}

	private List<WeatherReport> buildWeatherReport(WeatherData weatherData) {
		List<WeatherReport> weatherReportList = new ArrayList<>();
		if(weatherData.getList() != null) {
		 for(com.application.bean.List list : weatherData.getList()) {
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
		}
	}
		return weatherReportList;
		
	}
	private WeatherData fetchWeatherData(String city) {
		WeatherData weatherData = new WeatherData();
		try {
		  HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      String uri = WeatherReportValidator.getURI(city);
	      
	      String jsonResult = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class).getBody();
	     
	      ObjectMapper om = new ObjectMapper();
	      weatherData= om.readValue(jsonResult, WeatherData.class);
		
		} catch (HttpClientErrorException | JsonProcessingException e) {
			LOGGER.error(e.getMessage());
		} 
	      return weatherData;
	
	}
	
}
