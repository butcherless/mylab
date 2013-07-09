package com.mylab.learn.myarchetype.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mylab.learn.myarchetype.domain.Aircraft;
import com.mylab.learn.myarchetype.domain.Company;
import com.mylab.learn.myarchetype.domain.Destination;
import com.mylab.learn.myarchetype.domain.DomainFactory;
import com.mylab.learn.myarchetype.domain.DomainUtils;
import com.mylab.learn.myarchetype.repository.AircraftRepository;
import com.mylab.learn.myarchetype.repository.CompanyRepository;
import com.mylab.learn.myarchetype.repository.DestinationRepository;
import com.mylab.learn.myarchetype.test.DomainUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:aviation-service-unit-test.xml")
public class AviationServiceTest {

    private static final String IBERIA_COMPANY = "Iberia";
    private static final String DELTA_COMPANY = "Delta";

    private static final String AIRCRAFT1_NAME = "Teide";

    private static final String AIRCRAFT1_REGISTRATION = "EC-PMA";
    private static final String BARAJAS_AIRPORT = "Barajas";
    private static final String BARAJAS_SHORT_CODE = "MAD";
    
    
    @Autowired
    private DomainUtil domainUtil;

    @Autowired
    private AircraftRepository aircraftRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private AviationService aviationService;

    @Before
    public void setUp() {
        this.domainUtil.createCompany(IBERIA_COMPANY);

//        Company company = DomainFactory.newCompany(COMPANY_NAME);
//        this.companyRepository.save(company);
//
//        Aircraft aircraft = DomainFactory.newAircraft(AIRCRAFT1_NAME, AIRCRAFT1_REGISTRATION);
//        this.aircraftRepository.save(aircraft);
//
//        Destination destination = DomainFactory.newDestination("barajas", "mad");
//        this.destinationRepository.save(destination);
//
//        Assert.assertNotNull(company.getId());
//        Assert.assertNotNull(aircraft.getId());
//        Assert.assertNotNull(destination.getId());
    }

    @Transactional
    @Test
    public void testCreateAircraftWithDestination() {
        long destinationCount = this.domainUtil.countDestinations();
        
        String airportName = BARAJAS_AIRPORT;
        String shortCode = BARAJAS_SHORT_CODE;
        CreateDestinationRequest createDestinationRequest = new CreateDestinationRequest(airportName, shortCode);
        CreateDestinationResponse response = this.aviationService.createDestination(createDestinationRequest);

        Assert.assertNotNull(response);
        Assert.assertEquals((destinationCount + 1), this.domainUtil.countDestinations().longValue());
    }

    @Transactional
    @Test
    public void testCreateCompanyOk() {
        long companyCount = this.domainUtil.countCompanies();
        CreateCompanyRequest createCompanyRequest = new CreateCompanyRequest(DELTA_COMPANY);
        CreateCompanyResponse response = this.aviationService.createCompany(createCompanyRequest);

        Assert.assertNotNull(response);
        Assert.assertEquals((companyCount + 1), this.domainUtil.countCompanies().longValue());
    }

    @Transactional
    @Test(expected = AviationServiceException.class)
    public void testCreateCompanyKo() {
        CreateCompanyRequest createCompanyRequest = new CreateCompanyRequest(IBERIA_COMPANY);
        CreateCompanyResponse response = this.aviationService.createCompany(createCompanyRequest);

        Assert.assertNotNull(response);
    }

    @Transactional
    @Test
    public void testCreateAircraft() {
        long aircraftCount = this.domainUtil.countAircrafts();
        String name = AIRCRAFT1_NAME;
        String registration = AIRCRAFT1_REGISTRATION;
        String companyName = IBERIA_COMPANY;
        CreateAircraftRequest createAircraftRequest = new CreateAircraftRequest(name, registration, companyName);
        CreateAircraftResponse response = this.aviationService.createAircraft(createAircraftRequest);

        Assert.assertNotNull(response);
        Assert.assertEquals((aircraftCount + 1), this.domainUtil.countAircrafts().longValue());
    }
}
