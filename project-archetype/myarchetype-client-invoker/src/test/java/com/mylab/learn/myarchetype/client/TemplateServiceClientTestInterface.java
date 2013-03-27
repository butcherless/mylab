package com.mylab.learn.myarchetype.client;

/**
 * Contract test from business requirements
 * 
 * @author cmartin
 * 
 */
public interface TemplateServiceClientTestInterface {
	/**
	 * Defines test method for use case main flow scenario
	 */
	void testMainTemplateOperation();

	/**
	 * Defines test method for use case alternate flow scenario
	 */
	void testAlternateTemplateOperation();

	/**
	 * Defines test method for use case error scenario
	 */
	void testTemplateOperationException();

}
