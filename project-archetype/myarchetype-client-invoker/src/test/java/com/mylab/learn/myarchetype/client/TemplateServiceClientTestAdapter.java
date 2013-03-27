package com.mylab.learn.myarchetype.client;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.remoting.RemoteInvocationFailureException;

import com.mylab.learn.myarchetype.service.BusinessEnum;
import com.mylab.learn.myarchetype.service.TemplateRequestValidationException;

public class TemplateServiceClientTestAdapter implements TemplateServiceClientTestInterface {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	protected TemplateServiceClient templateServiceClient;

	@Test
	public void testMainTemplateOperation() {
		String dummyProperty = BusinessEnum.MAIN_FLOW.toString();
		Boolean result = this.templateServiceClient.callTemplateOperation(dummyProperty);

		Assert.assertTrue("main flow", result);
	}

	@Test
	public void testAlternateTemplateOperation() {
		String dummyProperty = BusinessEnum.ALTERNATE_FLOW.toString();
		Boolean result = this.templateServiceClient.callTemplateOperation(dummyProperty);

		Assert.assertFalse("alternate flow", result);
	}

	@Test(expected = TemplateRequestValidationException.class)
	public void testTemplateOperationException() {
		String dummyProperty = "";

		this.templateServiceClient.callTemplateOperation(dummyProperty);
	}

	@Test(expected = RemoteInvocationFailureException.class)
	public void testUnexpectedException() {
		String dummyProperty = BusinessEnum.GENERAL_ERROR_FLOW.toString();
		
		this.templateServiceClient.callTemplateOperation(dummyProperty);
	}
	
	
}
