package com.application.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.application.bean.RestError;
import com.application.bean.WeatherReportResponse;
import com.application.errorcode.RestErrorCode;

public class WeatherServiceControllerTest extends AbstractTest {

	@Test
	public void getWeatherReportTest() throws Exception {
		String uri = "/weather/delhi";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		WeatherReportResponse weatherReportResponse = super.mapFromJson(content, WeatherReportResponse.class);

		assertTrue(weatherReportResponse.getWeatherReports().size() > 0);
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
	}

	@Test
	public void getWeatherReportRestExceptionTest() throws Exception {

		String uri = "/weather/nocity";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		RestError restError = super.mapFromJson(content, RestError.class);

		assertEquals(RestErrorCode.NO_CITY_FOUND.getErrorCode(), restError.getErrorCode());
		assertEquals(HttpStatus.CONFLICT.value(), mvcResult.getResponse().getStatus());

	}

}
