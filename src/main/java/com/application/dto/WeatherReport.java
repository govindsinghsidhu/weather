package com.application.dto;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

public class WeatherReport {

	@SerializedName("city")
	private String city;

	@SerializedName("cloud")
	private String cloud;

	@SerializedName("rainAlert")
	private String rainAlert;

	@SerializedName("windAlert")
	private String windAlert;

	@SerializedName("temperatureAlert")
	private String temperatureAlert;

	@SerializedName("highTemperature")
	private double highTemperature;

	@SerializedName("lowTemperature")
	private double lowTemperature;

	@SerializedName("windSpeed")
	private double windSpeed;

	public WeatherReport city(String city) {
		this.city = city;
		return this;
	}

	/**
	 * Get city
	 * 
	 * @return city
	 **/

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public WeatherReport cloud(String cloud) {
		this.cloud = cloud;
		return this;
	}

	/**
	 * Get cloud
	 * 
	 * @return cloud
	 **/

	public String getCloud() {
		return cloud;
	}

	public void setCloud(String cloud) {
		this.cloud = cloud;
	}

	public WeatherReport rainAlert(String rainAlert) {
		this.rainAlert = rainAlert;
		return this;
	}

	/**
	 * Get rainAlert
	 * 
	 * @return rainAlert
	 **/

	public String getRainAlert() {
		return rainAlert;
	}

	public void setRainAlert(String rainAlert) {
		this.rainAlert = rainAlert;
	}

	public WeatherReport windAlert(String windAlert) {
		this.windAlert = windAlert;
		return this;
	}

	/**
	 * Get windAlert
	 * 
	 * @return windAlert
	 **/

	public String getWindAlert() {
		return windAlert;
	}

	public void setWindAlert(String windAlert) {
		this.windAlert = windAlert;
	}

	public WeatherReport temperatureAlert(String temperatureAlert) {
		this.temperatureAlert = temperatureAlert;
		return this;
	}

	/**
	 * Get temperatureAlert
	 * 
	 * @return temperatureAlert
	 **/

	public String getTemperatureAlert() {
		return temperatureAlert;
	}

	public void setTemperatureAlert(String temperatureAlert) {
		this.temperatureAlert = temperatureAlert;
	}

	public WeatherReport highTemperature(double highTemperature) {
		this.highTemperature = highTemperature;
		return this;
	}

	/**
	 * Get highTemperature
	 * 
	 * @return highTemperature
	 **/

	public double getHighTemperature() {
		return highTemperature;
	}

	public void setHighTemperature(double highTemperature) {
		this.highTemperature = highTemperature;
	}

	public WeatherReport lowTemperature(double lowTemperature) {
		this.lowTemperature = lowTemperature;
		return this;
	}

	/**
	 * Get lowTemperature
	 * 
	 * @return lowTemperature
	 **/

	public double getLowTemperature() {
		return lowTemperature;
	}

	public void setLowTemperature(double lowTemperature) {
		this.lowTemperature = lowTemperature;
	}

	public WeatherReport windSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
		return this;
	}

	/**
	 * Get windSpeed
	 * 
	 * @return windSpeed
	 **/

	public double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		WeatherReport weatherReport = (WeatherReport) o;
		return Objects.equals(this.city, weatherReport.city) && Objects.equals(this.cloud, weatherReport.cloud)
				&& Objects.equals(this.rainAlert, weatherReport.rainAlert)
				&& Objects.equals(this.windAlert, weatherReport.windAlert)
				&& Objects.equals(this.temperatureAlert, weatherReport.temperatureAlert)
				&& Objects.equals(this.highTemperature, weatherReport.highTemperature)
				&& Objects.equals(this.lowTemperature, weatherReport.lowTemperature)
				&& Objects.equals(this.windSpeed, weatherReport.windSpeed);
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, cloud, rainAlert, windAlert, temperatureAlert, highTemperature, lowTemperature,
				windSpeed);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class WeatherReport {\n");

		sb.append("    city: ").append(toIndentedString(city)).append("\n");
		sb.append("    cloud: ").append(toIndentedString(cloud)).append("\n");
		sb.append("    rainAlert: ").append(toIndentedString(rainAlert)).append("\n");
		sb.append("    windAlert: ").append(toIndentedString(windAlert)).append("\n");
		sb.append("    temperatureAlert: ").append(toIndentedString(temperatureAlert)).append("\n");
		sb.append("    highTemperature: ").append(toIndentedString(highTemperature)).append("\n");
		sb.append("    lowTemperature: ").append(toIndentedString(lowTemperature)).append("\n");
		sb.append("    windSpeed: ").append(toIndentedString(windSpeed)).append("\n");
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
