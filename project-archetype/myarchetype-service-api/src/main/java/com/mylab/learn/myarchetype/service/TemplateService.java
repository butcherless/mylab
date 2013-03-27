package com.mylab.learn.myarchetype.service;

/**
 * Service description from requirements
 * 
 * @author cmartin
 * 
 */
public interface TemplateService {
	/**
	 * Service operation description from requirements
	 * 
	 * @param templateRequest input data for the operation
	 * @return ouput data for the operation
	 * @throws TemplateServiceException operation errors
	 */
	TemplateResponse templateOperation(TemplateRequest templateRequest) throws TemplateServiceException;
}
