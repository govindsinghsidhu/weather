package com.application.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.http.HttpHeaders;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.application.dto.RestError;
import com.application.dto.WeatherReportResponse;
import com.application.errorcode.RestErrorCode;

public class WeatherServiceControllerTest extends AbstractTest {

	@Test
	public void getWeatherReportTest() throws Exception {
		String uri = "/weather/delhi";
		String encoding = Base64.getEncoder().encodeToString(("user:password").getBytes());

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).header(HttpHeaders.AUTHORIZATION, "Basic " + encoding).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		WeatherReportResponse weatherReportResponse = super.mapFromJson(content, WeatherReportResponse.class);

		assertTrue(weatherReportResponse.getWeatherReports().size() > 0);
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
	}

	@Test
	public void getWeatherReportRestExceptionTest() throws Exception {

		String uri = "/weather/nocity";
		String encoding = Base64.getEncoder().encodeToString(("user:password").getBytes());

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).header(HttpHeaders.AUTHORIZATION, "Basic " + encoding).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		RestError restError = super.mapFromJson(content, RestError.class);

		assertEquals(RestErrorCode.NO_CITY_FOUND.getErrorCode(), restError.getErrorCode());
		assertEquals(HttpStatus.CONFLICT.value(), mvcResult.getResponse().getStatus());

	}

}
