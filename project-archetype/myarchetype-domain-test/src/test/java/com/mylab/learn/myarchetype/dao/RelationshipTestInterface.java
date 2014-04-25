package com.mylab.learn.myarchetype.dao;

/**
 * 
 * @author cmartin
 * 
 */
public interface RelationshipTestInterface {

    /**
     * stores a new Aircraft entity
     */
    void testCreateAircraft();

    /**
     * checks that an aircraft exists in the repository
     */
    void testExistsAircraft();

    /**
     * checks that an aircraft does not exist in the repository
     */
    void testNotExistsAircraft();

    /**
     * stores a new Destination entity
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

    /**
     * stores a new Circraft entity
     */
    void testCreateCompany();

    /**
     * 
     */
    void testAddAircraftToCompany();

    /**
     * 
     */
    void testFindAircraftByCompany();
}
