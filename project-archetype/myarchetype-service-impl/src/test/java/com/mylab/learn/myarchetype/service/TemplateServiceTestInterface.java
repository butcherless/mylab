package com.mylab.learn.myarchetype.service;

/**
 * Contract test from business requirements
 * 
 * @author cmartin
 * 
 */
public interface TemplateServiceTestInterface {
	/**
	 * Defines test method for use case main flow
	 */
	void testMainTemplateOperation();

	/**
	 * Defines test method for use case alternate flow
	 */
	void testAlternateTemplateOperation();

	/**
	 * Defines test method for empty template request
	 */
	void testNullTemplateRequest();

	/**
	 * Defines test method for unsopported request
	 */
	void testUnsopportedTemplateRequest();

	/**
	 * Defines test method for empty request
	 */
	void testEmptyTemplateRequest();
}
