package com.mylab.learn.myarchetype.client;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mylab.learn.myarchetype.service.TemplateRequest;
import com.mylab.learn.myarchetype.service.TemplateResponse;
import com.mylab.learn.myarchetype.service.TemplateService;
import com.mylab.learn.myarchetype.service.TemplateServiceException;

/**
 * Remote client for {@link TemplateService}
 * 
 * @author carlos.martin
 * 
 */
@Component
public class TemplateServiceClient {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "templateServiceProxy")
    private TemplateService templateService;

    /**
     * Remote call to {@link TemplateService} operation
     * 
     * @param dummyProperty data for {@link TemplateRequest}
     * @return true if is the use case main flow scenario
     * @throws TemplateServiceException if an error occurs
     */
    public Boolean callTemplateOperation(final String dummyProperty)
            throws TemplateServiceException {
        Boolean result = Boolean.FALSE;
        TemplateRequest templateRequest = new TemplateRequest(dummyProperty);

        TemplateResponse templateResponse = this.templateService.templateOperation(templateRequest);
        this.logger.debug("response {}.", templateResponse);

        if (templateResponse.getDummyResult()) {
            result = Boolean.TRUE;
        }

        this.logger.debug("result {}.", result);

        return result;
    }

    public void setTemplateService(final TemplateService templateService) {
        this.templateService = templateService;
    }
}
