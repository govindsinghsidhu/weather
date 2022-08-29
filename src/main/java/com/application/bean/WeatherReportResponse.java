package com.application.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

public class WeatherReportResponse {
	@SerializedName("weatherReports")
	private List<WeatherReport> weatherReports = null;

	public WeatherReportResponse weatherReports(List<WeatherReport> weatherReports) {
		this.weatherReports = weatherReports;
		return this;
	}

	public WeatherReportResponse addWeatherReportsItem(WeatherReport weatherReportsItem) {
		if (this.weatherReports == null) {
			this.weatherReports = new ArrayList<WeatherReport>();
		}
		this.weatherReports.add(weatherReportsItem);
		return this;
	}

	/**
	 * Get weatherReports
	 * 
	 * @return weatherReports
	 **/

	public List<WeatherReport> getWeatherReports() {
		return weatherReports;
	}

	public void setWeatherReports(List<WeatherReport> weatherReports) {
		this.weatherReports = weatherReports;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		WeatherReportResponse weatherReportResponse = (WeatherReportResponse) o;
		return Objects.equals(this.weatherReports, weatherReportResponse.weatherReports);
	}

	@Override
	public int hashCode() {
		return Objects.hash(weatherReports);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class WeatherReportResponse {\n");

		sb.append("    weatherReports: ").append(toIndentedString(weatherReports)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

}
