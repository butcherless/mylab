package com.mylab.learn.myarchetype.service;

public interface AviationService {

    /**
     * Creates a new Destination.
     * 
     * @param createDestinationRequest
     * @return
     * @throws AviationServiceException
     */
    CreateDestinationResponse createDestination(CreateDestinationRequest createDestinationRequest) throws AviationServiceException;

    /**
     * Creates a new Company.
     * 
     * @param createCompanyRequest
     * @return
     * @throws AviationServiceException if the company exists
     */
    CreateCompanyResponse createCompany(CreateCompanyRequest createCompanyRequest) throws AviationServiceException;

    /**
     * Creates a new Aircraft and associates it to an existing Company.
     * 
     * @param createAircraftRequest
     * @return
     * @throws AviationServiceException
     */
    CreateAircraftResponse createAircraft(CreateAircraftRequest createAircraftRequest) throws AviationServiceException;
}
