package com.application.exception;

public class ServiceException extends ApplicationException {

	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private int errorCode;

	/**
	 * Constructor
	 * 
	 * @param errorMessage the error message
	 */
	public ServiceException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	/**
	 * Constructor
	 * 
	 * @param errorMessage the error message
	 * @param errorCode    the error code
	 */
	public ServiceException(String errorMessage, int errorCode) {
		super(errorMessage, errorCode);
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}
}
