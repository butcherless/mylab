package com.mylab.learn.myarchetype.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mylab.learn.myarchetype.domain.Aircraft;
import com.mylab.learn.myarchetype.domain.Company;
import com.mylab.learn.myarchetype.domain.Destination;
import com.mylab.learn.myarchetype.domain.DomainFactory;
import com.mylab.learn.myarchetype.domain.DomainUtils;
import com.mylab.learn.myarchetype.repository.AircraftRepository;
import com.mylab.learn.myarchetype.repository.CompanyRepository;
import com.mylab.learn.myarchetype.repository.DestinationRepository;

@Service
public class AviationServiceImpl implements AviationService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AircraftRepository aircraftRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private DestinationRepository destinationRepository;

    @Override
    @Transactional
    public CreateDestinationResponse createDestination(CreateDestinationRequest createDestinationRequest)
            throws AviationServiceException {
        CreateDestinationResponse response = null;
        // TODO Auto-generated method stub
        this.logger.debug("begin operation {}", createDestinationRequest);

        // TODO validate request

        Destination destination = DomainFactory.newDestination(createDestinationRequest.getAirportName(),
                createDestinationRequest.getShortCode());
        this.destinationRepository.save(destination);

        // TODO response contents
        response = new CreateDestinationResponse();

        this.logger.debug("end operation {}", response);
        return response;
    }

    @Transactional
    @Override
    public CreateCompanyResponse createCompany(final CreateCompanyRequest createCompanyRequest) throws AviationServiceException {
        CreateCompanyResponse response = null;
        // TODO Auto-generated method stub
        this.logger.debug("begin operation {}", createCompanyRequest);

        // TODO validate request
        // company does not exist
        if (!DomainUtils.isEntity(this.companyRepository.findByName(createCompanyRequest.getName()))) {
            Company company = DomainFactory.newCompany(createCompanyRequest.getName());
            this.companyRepository.save(company);
        } else { // company already exists
            throw new AviationServiceException("Company already exists: " + createCompanyRequest.getName());
        }

        // TODO response contents
        response = new CreateCompanyResponse();

        this.logger.debug("end operation {}", response);
        return response;
    }

    @Transactional
    @Override
    public CreateAircraftResponse createAircraft(final CreateAircraftRequest createAircraftRequest) throws AviationServiceException {
        CreateAircraftResponse response = null;
        // TODO Auto-generated method stub
        this.logger.debug("begin operation {}", createAircraftRequest);

        // TODO validate request

        Company company = this.findCompanyByName(createAircraftRequest.getCompanyName());

        Aircraft aircraft = DomainFactory.newAircraft(createAircraftRequest.getName(), createAircraftRequest.getRegistration());
        this.aircraftRepository.save(aircraft);

        company.addAircraft(aircraft);

        // TODO response contents
        response = new CreateAircraftResponse();

        this.logger.debug("end operation {}", response);
        return response;
    }

    @Transactional(readOnly = true)
    @Override
    public SearchAircraftByCompanyResponse searchAircraftByCompany(SearchAircraftByCompanyRequest searchAircraftByCompanyRequest)
            throws AviationServiceException {
        SearchAircraftByCompanyResponse response = null;
        this.logger.debug("begin operation {}", searchAircraftByCompanyRequest);

        // TODO validate request
        Company company = this.findCompanyByName(searchAircraftByCompanyRequest.getCompanyName());

        List<Aircraft> aircrafts = this.aircraftRepository.findByCompany(company);

        // TODO response contents
        response = this.createSearchAircraftByCompanyResponse(aircrafts);

        this.logger.debug("end operation {}", response);
        return response;
    }

    private SearchAircraftByCompanyResponse createSearchAircraftByCompanyResponse(final List<Aircraft> aircrafts) {
        SearchAircraftByCompanyResponse response = null;
        List<AircraftSumary> sumaryList = new ArrayList<AircraftSumary>();

        for (Aircraft aircraft : aircrafts) {
            AircraftSumary sumary = ServiceUtils.convertAircraftToAircraftSumary(aircraft);
            sumaryList.add(sumary);
        }

        response = new SearchAircraftByCompanyResponse(sumaryList);

        return response;
    }

    private Company findCompanyByName(final String companyName) {
        Company company = this.companyRepository.findByName(companyName);

        if (!DomainUtils.isObject(company)) {
            throw new AviationServiceException("Company does not exist");
        }

        return company;
    }

}
