package com.application.bean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RestError {

	private String timestamp;
	private int httpStatusCode;
	private int errorCode;
	private String errorMessage;

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public RestError(int errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public RestError(int errorCode, String errorMessage, int httpStatusCode, LocalDateTime timestamp) {
		this.timestamp = timestamp.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm:ss"));
		this.httpStatusCode = httpStatusCode;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;

	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public int getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	public RestError() {
	};

}
