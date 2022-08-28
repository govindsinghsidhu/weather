package com.application.errorcode;

import com.application.common.ApplicationDataRepository;

public enum ServiceErrorCode {
	NO_CITY_FOUND(100100, ApplicationDataRepository.serviceErrorCodeProperties.getProperty("100100")),
	ACCESS_DENIED(400300, ApplicationDataRepository.serviceErrorCodeProperties.getProperty("400300")),
	INTERNAL_SERVER_ERROR(500000, ApplicationDataRepository.serviceErrorCodeProperties.getProperty("400500"));
    
	
	
	private int errorCode;
	private String errorMessage;

	ServiceErrorCode(int errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
