package com.application.exception;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.application.common.ApplicationConstants;
import com.application.dto.RestError;
import com.application.errorcode.RestErrorCode;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	final Logger LOGGER = LoggerFactory.getLogger(ApplicationExceptionHandler.class);

	@ExceptionHandler(RestException.class)
	public ResponseEntity<RestError> handleRestException(RestException e) {
		LOGGER.error(ApplicationConstants.ERROR_CODE + e.getErrorCode() + ApplicationConstants.ERROR_MESSAGE
				+ e.getErrorMessage());
		RestError restError = new RestError(e.getErrorCode(), e.getErrorMessage(), HttpStatus.CONFLICT.value(),
				LocalDateTime.now());
		return new ResponseEntity<RestError>(restError, HttpStatus.CONFLICT);
	}

	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		LOGGER.error(ApplicationConstants.ERROR_CODE + RestErrorCode.BAD_REQUEST.getErrorCode()
				+ ApplicationConstants.ERROR_MESSAGE + RestErrorCode.BAD_REQUEST.getErrorMessage());
		RestError restError = new RestError(RestErrorCode.BAD_REQUEST.getErrorCode(),
				RestErrorCode.BAD_REQUEST.getErrorMessage(), HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
		return handleExceptionInternal(e, restError, headers, HttpStatus.BAD_REQUEST, request);
	}

	@Override
	public ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		LOGGER.error(ApplicationConstants.ERROR_CODE + RestErrorCode.METHOD_NOT_SUPPORTED.getErrorCode()
				+ ApplicationConstants.ERROR_MESSAGE + RestErrorCode.METHOD_NOT_SUPPORTED.getErrorMessage());
		RestError restError = new RestError(RestErrorCode.METHOD_NOT_SUPPORTED.getErrorCode(),
				RestErrorCode.METHOD_NOT_SUPPORTED.getErrorMessage(), HttpStatus.METHOD_NOT_ALLOWED.value(),
				LocalDateTime.now());
		return handleExceptionInternal(e, restError, headers, HttpStatus.METHOD_NOT_ALLOWED, request);
	}

	@Override
	public ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException e,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		LOGGER.error(ApplicationConstants.ERROR_CODE + RestErrorCode.CONTENT_TYPE_NOT_SUPPORTED.getErrorCode()
				+ ApplicationConstants.ERROR_MESSAGE + RestErrorCode.CONTENT_TYPE_NOT_SUPPORTED.getErrorMessage());
		RestError restError = new RestError(RestErrorCode.CONTENT_TYPE_NOT_SUPPORTED.getErrorCode(),
				RestErrorCode.CONTENT_TYPE_NOT_SUPPORTED.getErrorMessage(), HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(),
				LocalDateTime.now());
		return handleExceptionInternal(e, restError, headers, HttpStatus.UNSUPPORTED_MEDIA_TYPE, request);
	}

	@Override
	public ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException e,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		LOGGER.error(ApplicationConstants.ERROR_CODE + RestErrorCode.CONTENT_TYPE_NOT_SUPPORTED.getErrorCode()
				+ ApplicationConstants.ERROR_MESSAGE + RestErrorCode.CONTENT_TYPE_NOT_SUPPORTED.getErrorMessage());
		RestError restError = new RestError(RestErrorCode.CONTENT_TYPE_NOT_SUPPORTED.getErrorCode(),
				RestErrorCode.CONTENT_TYPE_NOT_SUPPORTED.getErrorMessage(), HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(),
				LocalDateTime.now());
		return handleExceptionInternal(e, restError, headers, HttpStatus.NOT_ACCEPTABLE, request);
	}

	@Override
	public ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException e, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		LOGGER.error(ApplicationConstants.ERROR_CODE + RestErrorCode.METHOD_NOT_SUPPORTED.getErrorCode()
				+ ApplicationConstants.ERROR_MESSAGE + RestErrorCode.METHOD_NOT_SUPPORTED.getErrorMessage());
		RestError restError = new RestError(RestErrorCode.METHOD_NOT_SUPPORTED.getErrorCode(),
				RestErrorCode.METHOD_NOT_SUPPORTED.getErrorMessage(), HttpStatus.NOT_FOUND.value(),
				LocalDateTime.now());
		return handleExceptionInternal(e, restError, headers, HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<RestError> handleRuntimeException(RuntimeException e) {
		RestError restError = new RestError(RestErrorCode.INTERNAL_SERVER_ERROR.getErrorCode(),
				RestErrorCode.INTERNAL_SERVER_ERROR.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				LocalDateTime.now());

		if (e.getMessage().contains(ApplicationConstants.NOT_CONTENT))
			restError = new RestError(RestErrorCode.NO_CITY_FOUND.getErrorCode(),
					RestErrorCode.NO_CITY_FOUND.getErrorMessage(), HttpStatus.CONFLICT.value(), LocalDateTime.now());
		if (e.getMessage().equals(ApplicationConstants.ACCESS_DENIED))
			restError = new RestError(RestErrorCode.ACCESS_DENIED.getErrorCode(),
					RestErrorCode.ACCESS_DENIED.getErrorMessage(), HttpStatus.FORBIDDEN.value(), LocalDateTime.now());

		LOGGER.error(ApplicationConstants.ERROR_MESSAGE + e.getMessage());
		return new ResponseEntity<RestError>(restError, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<RestError> handleAll(Exception e) {
		LOGGER.error(ApplicationConstants.ERROR_CODE + RestErrorCode.INTERNAL_SERVER_ERROR.getErrorCode()
				+ ApplicationConstants.ERROR_MESSAGE + RestErrorCode.INTERNAL_SERVER_ERROR.getErrorMessage());
		RestError restError = new RestError(RestErrorCode.INTERNAL_SERVER_ERROR.getErrorCode(),
				RestErrorCode.INTERNAL_SERVER_ERROR.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				LocalDateTime.now());
		return new ResponseEntity<RestError>(restError, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
