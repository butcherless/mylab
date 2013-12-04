package com.mylab.learn.myarchetype.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mylab.learn.myarchetype.service.TemplateRequest;
import com.mylab.learn.myarchetype.service.TemplateResponse;
import com.mylab.learn.myarchetype.service.TemplateServiceException;

@Component
public class TemplateServiceRestfulClient {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${service.url}")
	private String serviceUrl;

	@Autowired
	private RestTemplate restTemplate;

	public Boolean callTemplateOperation(final String dummyProperty) throws TemplateServiceException {
		Boolean result;

		// TODO externalizar URI's
		TemplateResponse templateResponse = restTemplate.getForObject(this.serviceUrl + "/templateOperation/{requestId}",
		        TemplateResponse.class, "MAIN_FLOW");
		result = templateResponse.getDummyResult();

		this.logger.debug("response {}", templateResponse);

		return result;
	}

	public Boolean callTemplatePostOperation(final String dummyProperty) throws TemplateServiceException {
		Boolean result;

		// TODO externalizar URI's
		TemplateRequest request = new TemplateRequest(dummyProperty);
		this.logger.debug("request {}", request);

		TemplateResponse templateResponse = restTemplate.postForObject(this.serviceUrl + "/templatePutOperation", request,
		        TemplateResponse.class);

		this.logger.debug("response {}", templateResponse);

		result = templateResponse.getDummyResult();

		return result;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

}
