package com.application.errorcode;

import com.application.common.ApplicationDataRepository;

public enum RestErrorCode {
	
	NO_CITY_FOUND(1000, ApplicationDataRepository.restErrorCodeProperties.getProperty("1000")),
	CONTENT_TYPE_NOT_SUPPORTED(1008, ApplicationDataRepository.restErrorCodeProperties.getProperty("1008")),
	METHOD_NOT_SUPPORTED(1007, ApplicationDataRepository.restErrorCodeProperties.getProperty("1007")),
	
	ACCESS_DENIED(4003, ApplicationDataRepository.restErrorCodeProperties.getProperty("4003")),
	BAD_REQUEST(4000, ApplicationDataRepository.restErrorCodeProperties.getProperty("4000")),
	INTERNAL_SERVER_ERROR(5000, ApplicationDataRepository.restErrorCodeProperties.getProperty("5000"));
	
	
	
	private int errorCode;
	private String errorMessage;

	RestErrorCode(int errorCode, String errorMessage) {
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
