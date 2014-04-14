package com.mylab.learn.myarchetype.service;

import org.junit.Assert;
import org.junit.Test;

import com.mylab.learn.myarchetype.core.TemplateException;

public class ServiceTest {

	protected String message = "exception-message";
	protected Throwable cause = new RuntimeException();

	@Test
	public void testTemplateRequest() {
		String dummyProperty = null;
		TemplateRequest dto = new TemplateRequest(dummyProperty);

		Assert.assertNotNull("toString", dto.toString());
		Assert.assertNotNull("hasData", dto.hasData());
		Assert.assertFalse("hasData false", dto.hasData());

		dummyProperty = "";
		dto = new TemplateRequest(dummyProperty);
		Assert.assertFalse("hasData false", dto.hasData());

		dummyProperty = "dummyProperty";
		dto = new TemplateRequest(dummyProperty);

		Assert.assertEquals("dummyProperty", dummyProperty, dto.getDummyProperty());
		Assert.assertTrue("hasData true", dto.hasData());
		Assert.assertNotNull("toString", dto.toString());
	}

	@Test
	public void testTemplateResponse() {
		Boolean hasData = Boolean.TRUE;
		TemplateResponse dto = new TemplateResponse(hasData);

		Assert.assertNotNull("toString", dto.toString());
		Assert.assertNotNull("dummyProperty", dto.getDummyResult());

		hasData = Boolean.FALSE;
		dto = new TemplateResponse(hasData);

		Assert.assertEquals("true", hasData, dto.getDummyResult());
		Assert.assertNotNull("toString", dto.toString());

		dto = new TemplateResponse();
		Assert.assertEquals("true", hasData, dto.getDummyResult());
		Assert.assertNotNull("toString", dto.toString());
	}

	@Test
	public void testTemplateServiceException() {
		TemplateException exception = new TemplateServiceException();

		exception = new TemplateServiceException(message);
		Assert.assertNotNull("message", exception.getMessage());
		exception = new TemplateServiceException(cause);
		Assert.assertNotNull("cause", exception.getCause());
		exception = new TemplateServiceException(message, cause);
		Assert.assertNotNull("message", exception.getMessage());
		Assert.assertNotNull("cause", exception.getCause());
	}

	@Test
	public void testTemplateRequestValidationException() {
		TemplateException exception = new TemplateRequestValidationException();

		exception = new TemplateRequestValidationException(message);
		Assert.assertNotNull("message", exception.getMessage());
		exception = new TemplateRequestValidationException(cause);
		Assert.assertNotNull("cause", exception.getCause());
		exception = new TemplateRequestValidationException(message, cause);
		Assert.assertNotNull("message", exception.getMessage());
		Assert.assertNotNull("cause", exception.getCause());
	}

	@Test
	public void testAviationServiceException() {
		AviationServiceException exception = new AviationServiceException();

		exception = new AviationServiceException(message);
		Assert.assertNotNull("message", exception.getMessage());
		exception = new AviationServiceException(cause);
		Assert.assertNotNull("cause", exception.getCause());
		exception = new AviationServiceException(message, cause);
		Assert.assertNotNull("message", exception.getMessage());
		Assert.assertNotNull("cause", exception.getCause());
	}

	@Test
	public void testBusinessEnum() {
		Assert.assertTrue("enum has no values", BusinessEnum.values().length > 0);
	}

}
