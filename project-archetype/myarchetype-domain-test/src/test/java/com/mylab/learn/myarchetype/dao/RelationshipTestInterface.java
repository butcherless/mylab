package com.mylab.learn.myarchetype.dao;

/**
 * 
 * @author cmartin
 * 
 */
public interface RelationshipTestInterface {

	/**
	 * 
	 */
	void testCreateAircraft();

	/**
	 * 
	 */
	void testExistsAircraft();

	/**
	 * 
	 */
	void testNotExistsAircraft();

	/**
	 * 
	 */
	void testCreateDestination();

	/**
	 * 
	 */
	void testCreateAircraftWithDestinations();

	/**
	 * 
	 */
	void testAddDestinationToAircraft();

	/**
	 * 
	 */
	void testRemoveDestinationFromAircraft();
}
