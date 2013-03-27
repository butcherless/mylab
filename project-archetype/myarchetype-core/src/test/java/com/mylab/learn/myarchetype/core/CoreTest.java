package com.mylab.learn.myarchetype.core;

import org.junit.Assert;
import org.junit.Test;

import com.mylab.learn.myarchetype.core.TemplateException;
import com.mylab.learn.myarchetype.core.ValidationException;

public class CoreTest {

	@Test
	public void testTemplateServiceException() {
		String message = "exception-message";
		Throwable cause = new RuntimeException();
		TemplateException exception = new ValidationException();

		exception = new ValidationException(message);
		Assert.assertNotNull("message", exception.getMessage());
		exception = new ValidationException(cause);
		Assert.assertNotNull("cause", exception.getCause());
		exception = new ValidationException(message, cause);
		Assert.assertNotNull("message", exception.getMessage());
		Assert.assertNotNull("cause", exception.getCause());
	}

}
