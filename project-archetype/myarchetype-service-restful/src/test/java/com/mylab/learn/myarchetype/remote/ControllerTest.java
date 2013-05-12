package com.mylab.learn.myarchetype.remote;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mylab.learn.myarchetype.service.BusinessEnum;
import com.mylab.learn.myarchetype.service.TemplateRequest;
import com.mylab.learn.myarchetype.service.TemplateRequestValidationException;
import com.mylab.learn.myarchetype.service.TemplateResponse;
import com.mylab.learn.myarchetype.service.TemplateService;
import com.mylab.learn.myarchetype.service.TemplateServiceException;

public class ControllerTest {

	private TemplateServiceRestfulController restfulController;
	private TemplateService templateService;

	@Before
	public void setUp() {
		this.restfulController = new TemplateServiceRestfulController();
		this.templateService = new TemplateService() {

			public TemplateResponse templateOperation(TemplateRequest templateRequest) throws TemplateServiceException {
				Boolean result = Boolean.FALSE;

				if (!templateRequest.hasData()) {
					throw new TemplateRequestValidationException();
				}

				if (templateRequest.getDummyProperty().equals(BusinessEnum.MAIN_FLOW.toString())) {
					result = Boolean.TRUE;
				}

				return new TemplateResponse(result);
			}

		};

		this.restfulController.setTemplateService(this.templateService);
	}

	@Test
	public void testRestfulControllerMainFlow() {
		String requestId = BusinessEnum.MAIN_FLOW.toString();
		TemplateResponse response = this.restfulController.templateOperation(requestId);

		Assert.assertNotNull("response", response);
		Assert.assertTrue("main flow", response.getDummyResult());
	}

	@Test
	public void testRestfulControllerAlternateFlow() {
		String requestId = BusinessEnum.ALTERNATE_FLOW.toString();
		TemplateResponse response = this.restfulController.templateOperation(requestId);

		Assert.assertNotNull("response", response);
		Assert.assertFalse("alternate flow", response.getDummyResult());
	}

	@Test(expected = TemplateRequestValidationException.class)
	public void testRestfulControllerException() {
		String requestId = null;
		this.restfulController.templateOperation(requestId);
	}

	@Test
	public void testTemplatePutOperation() {
		TemplateRequest templateRequest = new TemplateRequest("dummyProperty");
		TemplateResponse response = this.restfulController.templatePutOperation(templateRequest);
		
		Assert.assertNotNull("response", response);
		Assert.assertFalse("alternate flow", response.getDummyResult());
	}

}
