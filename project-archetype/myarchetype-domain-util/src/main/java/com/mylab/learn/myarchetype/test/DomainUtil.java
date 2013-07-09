package com.mylab.learn.myarchetype.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mylab.learn.myarchetype.domain.Aircraft;
import com.mylab.learn.myarchetype.domain.Company;
import com.mylab.learn.myarchetype.domain.DomainFactory;
import com.mylab.learn.myarchetype.domain.DomainUtils;
import com.mylab.learn.myarchetype.repository.AircraftRepository;
import com.mylab.learn.myarchetype.repository.CompanyRepository;
import com.mylab.learn.myarchetype.repository.DestinationRepository;

@Component
public class DomainUtil {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AircraftRepository aircraftRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private DestinationRepository destinationRepository;

    public Long countCompanies() {
        return this.companyRepository.count();
    }

    public Company createCompany(final String companyName) {
        Company company = DomainFactory.newCompany(companyName);
        this.companyRepository.save(company);

        return company;
    }

    public Long countDestinations() {
        return this.destinationRepository.count();
    }

    public Long countAircrafts() {
        return this.aircraftRepository.count();
    }

    public void addAircraftToCompany(final Aircraft aircraft, final String companyName) {
        Company company = this.companyRepository.findByName(companyName);
        if (DomainUtils.isEntity(company)) {
            this.aircraftRepository.save(aircraft);
            company.addAircraft(aircraft);
        }
    }
}
