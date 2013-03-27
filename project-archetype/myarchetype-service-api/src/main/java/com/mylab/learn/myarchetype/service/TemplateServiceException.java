package com.mylab.learn.myarchetype.service;

import com.mylab.learn.myarchetype.core.TemplateException;

/**
 * Base exception for {@link TemplateService} layer
 * 
 * @author cmartin
 * 
 */
public class TemplateServiceException extends TemplateException {
	private static final long serialVersionUID = -8593115785428344053L;

	public TemplateServiceException() {
	}

	public TemplateServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public TemplateServiceException(String message) {
		super(message);
	}

	public TemplateServiceException(Throwable cause) {
		super(cause);
	}

}
