package com.mylab.learn.myarchetype.dao;

/**
 * Contract test from business requirements
 * 
 * @author cmartin
 * 
 */
public interface TemplateRepositoryTestInterface {
	/**
	 * test create entity operation
	 */
	void testCreateTemplate();

	/**
	 * test find entity operation
	 */
	void testFindByNameTemplate();

	/**
	 * test update entity operation
	 */
	void testUpdateTemplate();

	/**
	 * test delete entity operation
	 */
	void testDeleteTemplate();
	
	/**
	 * test embeddable collection
	 */
	void testSimpleText();
}
