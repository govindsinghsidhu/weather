package com.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain {

	@JsonProperty("3h")
	private String threeH;

	public String getThreeH() {
		return threeH;
	}

	public void setThreeH(String threeH) {
		this.threeH = threeH;
	}

}
