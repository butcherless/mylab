package com.mylab.learn.myarchetype.service;

/**
 * @author cmartin
 * 
 */
public interface AviationService {

	/**
	 * Creates a new Destination.
	 * 
	 * @param createDestinationRequest
	 * @return
	 * @throws AviationServiceException
	 */
	CreateDestinationResponse createDestination(CreateDestinationRequest createDestinationRequest)
	        throws AviationServiceException;

	/**
	 * Creates a new Company.
	 * 
	 * @param createCompanyRequest
	 * @return
	 * @throws AviationServiceException if the company exists
	 */
	CreateCompanyResponse createCompany(CreateCompanyRequest createCompanyRequest)
	        throws AviationServiceException;

	/**
	 * <p>
	 * Creates a new Aircraft and associates it to an existing Company.
	 * </p>
	 * Sequence:
	 * <ul>
	 * <li>search company by name.
	 * <li>create aircraft.
	 * <li>add aircraft to company.
	 * </ul>
	 * 
	 * @param createAircraftRequest
	 * @return
	 * @throws AviationServiceException
	 */
	CreateAircraftResponse createAircraft(CreateAircraftRequest createAircraftRequest)
	        throws AviationServiceException;

	/**
	 * @param searchAircraftByCompanyRequest
	 * @return
	 * @throws AviationServiceException
	 */
	SearchAircraftByCompanyResponse searchAircraftByCompany(
	        SearchAircraftByCompanyRequest searchAircraftByCompanyRequest)
	        throws AviationServiceException;
}
