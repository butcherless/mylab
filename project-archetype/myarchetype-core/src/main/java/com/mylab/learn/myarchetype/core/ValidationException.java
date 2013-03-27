package com.mylab.learn.myarchetype.core;

/**
 * Base exception for validator operations
 * 
 * @author cmartin
 * 
 */
public class ValidationException extends TemplateException {

	private static final long serialVersionUID = -3267044498368003083L;

	public ValidationException() {
	}

	public ValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidationException(Throwable cause) {
		super(cause);
	}

	public ValidationException(String message) {
		super(message);
	}

}
