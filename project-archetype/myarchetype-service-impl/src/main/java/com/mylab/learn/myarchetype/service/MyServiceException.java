package com.mylab.learn.myarchetype.service;

public class MyServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1541703444716102791L;

	public MyServiceException() {
	}

	public MyServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public MyServiceException(String message) {
		super(message);
	}

	public MyServiceException(Throwable cause) {
		super(cause);
	}

}
