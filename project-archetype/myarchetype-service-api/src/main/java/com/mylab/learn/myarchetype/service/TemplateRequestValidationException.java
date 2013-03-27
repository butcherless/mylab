package com.mylab.learn.myarchetype.service;

/**
 * TemplateRequest validation error
 * 
 * @author cmartin
 * 
 */
public class TemplateRequestValidationException extends TemplateServiceException {
	private static final long serialVersionUID = -8840242536712449829L;

	public TemplateRequestValidationException() {
		super();
	}

	public TemplateRequestValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	public TemplateRequestValidationException(String message) {
		super(message);
	}

	public TemplateRequestValidationException(Throwable cause) {
		super(cause);
	}

}
