package com.mylab.learn.myarchetype.service;

public class AviationServiceException extends RuntimeException {
	private static final long serialVersionUID = 7329319630488051329L;

	public AviationServiceException() {
		super();
	}

	public AviationServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public AviationServiceException(String message) {
		super(message);
	}

	public AviationServiceException(Throwable cause) {
		super(cause);
	}

}
