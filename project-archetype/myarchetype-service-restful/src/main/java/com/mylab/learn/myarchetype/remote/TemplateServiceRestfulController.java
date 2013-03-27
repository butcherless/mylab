package com.mylab.learn.myarchetype.remote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mylab.learn.myarchetype.service.TemplateRequest;
import com.mylab.learn.myarchetype.service.TemplateResponse;
import com.mylab.learn.myarchetype.service.TemplateService;

@Controller
@RequestMapping(value = "/templateService")
public class TemplateServiceRestfulController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TemplateService templateService;

	@RequestMapping(value = "/templateOperation/{requestId}", method = RequestMethod.GET)
	@ResponseBody
	public TemplateResponse templateOperation(@PathVariable String requestId) {
		// TODO solo para pruebas
		// String dummyProperty = null;
		String dummyProperty = requestId;

		TemplateRequest templateRequest = new TemplateRequest(dummyProperty);
		// TODO
		TemplateResponse templateResponse = this.templateService.templateOperation(templateRequest);

		this.logger.debug("request id={}", requestId);

		return templateResponse;
	}

	@RequestMapping(value = "/templatePutOperation", method = RequestMethod.POST)
	@ResponseBody
	public TemplateResponse templatePutOperation(@RequestBody TemplateRequest templateRequest) {

		this.logger.debug("request {}", templateRequest);

		TemplateResponse templateResponse = this.templateService.templateOperation(templateRequest);

		this.logger.debug("response {}", templateResponse);

		return templateResponse;
	}

	public void setTemplateService(TemplateService templateService) {
		this.templateService = templateService;
	}
}

/*
 * client url:
 * http://localhost:8080/myarchetype-restful/restful/templateService
 * /templateOperation/7
 * http://localhost:8080/myarchetype-restful/restful
 * /templateService/templateOperation/MAIN_FLOW
 */