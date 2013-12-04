package com.mylab.learn.myarchetype.service;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class TemplateServiceTestAdapter implements TemplateServiceTestInterface {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	protected TemplateService templateService;

	@Override
	@Test
	public void testMainTemplateOperation() {
		// preconditions, prepare request
		String dummyProperty = BusinessEnum.MAIN_FLOW.toString();
		TemplateRequest templateRequest = new TemplateRequest(dummyProperty);

		// perform operation
		TemplateResponse templateResponse = this.templateService.templateOperation(templateRequest);

		// postconditions, verify response
		Assert.assertNotNull(templateResponse);
		Assert.assertTrue("main flow", templateResponse.getDummyResult());

		this.logger.debug("adapter operation");
	}

	@Override
	@Test
	public void testAlternateTemplateOperation() {
		String dummyProperty = BusinessEnum.ALTERNATE_FLOW.toString();
		TemplateRequest templateRequest = new TemplateRequest(dummyProperty);
		TemplateResponse templateResponse = this.templateService.templateOperation(templateRequest);

		Assert.assertNotNull(templateResponse);
		Assert.assertFalse("alternate flow", templateResponse.getDummyResult());

		this.logger.debug("adapter operation");
	}

	@Override
	@Test(expected = MyServiceException.class)
	public void testGeneralErrorTemplateOperation() {
		String dummyProperty = BusinessEnum.GENERAL_ERROR_FLOW.toString();
		TemplateRequest templateRequest = new TemplateRequest(dummyProperty);
		TemplateResponse templateResponse = this.templateService.templateOperation(templateRequest);

		Assert.assertNotNull(templateResponse);

		this.logger.debug("adapter operation");
	}

	@Override
	@Test(expected = TemplateRequestValidationException.class)
	public void testNullTemplateRequest() {
		TemplateRequest templateRequest = null;
		this.logger.debug("adapter operation");
		this.templateService.templateOperation(templateRequest);
	}

	@Override
	@Test(expected = TemplateRequestValidationException.class)
	public void testUnsopportedTemplateRequest() {
		TemplateRequest templateRequest = new NotSupportedRequest("dummyProperty");
		this.logger.debug("adapter operation");
		this.templateService.templateOperation(templateRequest);
	}

	@Override
	@Test(expected = TemplateRequestValidationException.class)
	public void testEmptyTemplateRequest() {
		TemplateRequest templateRequest = new TemplateRequest("");
		this.logger.debug("adapter operation");
		this.templateService.templateOperation(templateRequest);
	}

	@Override
	@Test
	public void testExceptionAssignableForm() {
		Class<TemplateServiceException> clazz = TemplateServiceException.class;

		Assert.assertTrue(clazz.isAssignableFrom(TemplateRequestValidationException.class));

		Assert.assertFalse(clazz.isAssignableFrom(MyServiceException.class));
	}

	@Override
	@Test
	public void testMyServiceException() {
		String message = "exception-message";
		Throwable cause = new RuntimeException();
		MyServiceException exception = new MyServiceException();

		exception = new MyServiceException(message);
		Assert.assertNotNull("message", exception.getMessage());
		exception = new MyServiceException(cause);
		Assert.assertNotNull("cause", exception.getCause());
		exception = new MyServiceException(message, cause);
		Assert.assertNotNull("message", exception.getMessage());
		Assert.assertNotNull("cause", exception.getCause());
	}

	// /////// H E L P E R S

	private class NotSupportedRequest extends TemplateRequest {
		private static final long serialVersionUID = 1L;

		public NotSupportedRequest(String dummyProperty) {
			super(dummyProperty);
		}

	}

}
