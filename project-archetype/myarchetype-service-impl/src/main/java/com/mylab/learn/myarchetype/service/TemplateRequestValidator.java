package com.mylab.learn.myarchetype.service;

import org.springframework.stereotype.Component;

import com.mylab.learn.myarchetype.core.ValidationException;
import com.mylab.learn.myarchetype.core.Validator;

@Component
public class TemplateRequestValidator implements Validator {

    @Override
    public Boolean supports(final Class<?> clazz) {
        return clazz.equals(TemplateRequest.class);
    }

    @Override
    public void validate(final Object target) throws ValidationException {

        TemplateRequest request = (TemplateRequest) target;

        if (!request.hasData()) {
            throw new ValidationException("request has not mandatory data.");
        }

        // additional validation
    }

}
