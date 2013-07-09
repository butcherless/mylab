package com.mylab.learn.myarchetype.service;

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

        List<Company> companies = this.companyRepository.findByName(createCompanyRequest.getName());
        if (companies.isEmpty()) { // company does not exist
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

        // search company by name.
        // create aircraft.
        // add aircraft to company.

        Company company = this.findCompanyByName(createAircraftRequest.getCompanyName());

        Aircraft aircraft = DomainFactory.newAircraft(createAircraftRequest.getName(), createAircraftRequest.getRegistration());
        this.aircraftRepository.save(aircraft);

        company.addAircraft(aircraft);

        // TODO response contents
        response = new CreateAircraftResponse();

        this.logger.debug("end operation {}", response);
        return response;
    }

    private Company findCompanyByName(final String companyName) {
        List<Company> companies = this.companyRepository.findByName(companyName);
        if (companies.isEmpty()) {
            throw new AviationServiceException("Company does not exist");
        }
        if (!DomainUtils.hasUniqueResult(companies)) {
            throw new AviationServiceException("Company name must be unique");
        }

        return companies.get(0);
    }
}
