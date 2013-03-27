package com.mylab.learn.myarchetype.service;

import org.springframework.remoting.RemoteInvocationFailureException;
import org.springframework.util.StringUtils;

public class TemplateServiceMockImpl implements TemplateService {

	public TemplateResponse templateOperation(TemplateRequest templateRequest) throws TemplateServiceException {
		// TODO MockValidator
		this.validateRequest(templateRequest);

		Boolean isMain = Boolean.FALSE;
		TemplateResponse response;

		if (templateRequest.getDummyProperty().equals(BusinessEnum.MAIN_FLOW.toString())) {
			isMain = Boolean.TRUE;
		} else if (templateRequest.getDummyProperty().equals(BusinessEnum.GENERAL_ERROR_FLOW.toString())) {
			throw new RemoteInvocationFailureException("main error", null);
		}

		response = new TemplateResponse(isMain);

		return response;
	}

	private void validateRequest(TemplateRequest templateRequest) {
		// TODO Auto-generated method stub
		if (templateRequest == null) {
			throw new TemplateRequestValidationException("request does not exist");
		}

		if (!StringUtils.hasText(templateRequest.getDummyProperty())) {
			throw new TemplateRequestValidationException("dummy property has empty value");
		}

	}

}
