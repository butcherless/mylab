package com.mylab.learn.myarchetype.core;

/**
 * Root module exception
 * 
 * @author cmartin
 * 
 */
public abstract class TemplateException extends RuntimeException {

	private static final long serialVersionUID = -4500457700590517873L;

	public TemplateException() {
	}

	public TemplateException(String message, Throwable cause) {
		super(message, cause);
	}

	public TemplateException(Throwable cause) {
		super(cause);
	}

	public TemplateException(String message) {
		super(message);
	}

}
