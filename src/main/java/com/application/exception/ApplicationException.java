package com.application.exception;

public class ApplicationException extends Exception {

	private static final long serialVersionUID = 1L;
	private String fieldName;
	private String errorMessage;
	private int errorCode;

	/**
	 * Constructor
	 * 
	 * @param errorMessage the error message
	 */
	public ApplicationException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * Constructor
	 * 
	 * @param errorMessage the error message
	 * @param errorCode    the error code
	 */
	public ApplicationException(String errorMessage, int errorCode) {
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}

	/**
	 * Constructor
	 * 
	 * @param fieldName    the field name
	 * @param errorMessage the error message
	 * @param errorCode    the error code
	 */
	public ApplicationException(String fieldName, String errorMessage, int errorCode) {
		this.fieldName = fieldName;
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}

	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
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