package com.mylab.learn.myarchetype.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mylab.learn.myarchetype.core.ValidationException;
import com.mylab.learn.myarchetype.core.Validator;
import com.mylab.learn.myarchetype.domain.DomainFactory;
import com.mylab.learn.myarchetype.domain.TemplateEntity;
import com.mylab.learn.myarchetype.repository.TemplateRepository;

@Service
public class TemplateServiceImpl implements TemplateService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(type = TemplateRequestValidator.class)
    private Validator requestValidator;

    @Autowired
    private TemplateRepository templateRepository;

    @Transactional
    @Override
    public TemplateResponse templateOperation(final TemplateRequest templateRequest)
            throws TemplateServiceException {
        Boolean isMain = Boolean.FALSE;
        TemplateResponse templateResponse;

        this.validateRequest(templateRequest);

        TemplateEntity template = DomainFactory.newTemplateEntity(templateRequest
                .getDummyProperty());
        this.templateRepository.save(template);

        if (templateRequest.getDummyProperty().equals(BusinessEnum.MAIN_FLOW.toString())) {
            isMain = Boolean.TRUE;
        } else if (templateRequest.getDummyProperty().equals(
                BusinessEnum.GENERAL_ERROR_FLOW.toString())) {
            /*
             * simulation of general exception, not declared in the service api
             */
            throw new MyServiceException();
        }

        templateResponse = new TemplateResponse(isMain);

        return templateResponse;
    }

    public void setTemplateRepository(TemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    public void setRequestValidator(Validator requestValidator) {
        this.requestValidator = requestValidator;
    }

    // ////// H E L P E R S ////////

    private void validateRequest(final TemplateRequest templateRequest) {
        this.logger.debug("request validation for {}.", templateRequest);

        if (templateRequest == null) {
            throw new TemplateRequestValidationException("Empty request.");
        }

        if (!this.requestValidator.supports(templateRequest.getClass())) {
            throw new TemplateRequestValidationException("class not supported: "
                    + templateRequest.getClass());
        }

        // rethrows internal exceptions to service (contract) exceptions
        try {
            this.requestValidator.validate(templateRequest);
        } catch (ValidationException e) {
            throw new TemplateRequestValidationException(e.getMessage());
        }

        this.logger.debug("request validated.");
    }

}
