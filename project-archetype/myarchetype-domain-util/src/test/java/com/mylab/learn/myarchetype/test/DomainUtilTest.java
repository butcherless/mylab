package com.mylab.learn.myarchetype.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mylab.learn.myarchetype.domain.Aircraft;
import com.mylab.learn.myarchetype.domain.Company;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:domain-util-unit-test.xml")
public class DomainUtilTest {

    @Autowired
    protected DomainUtil domainUtil;

    @Before
    public void setUp() {
        Assert.assertNotNull("missing repository", this.domainUtil);
    }

    @Test
    public void testCountAircrafts() {
        Assert.assertEquals(Long.valueOf(0L), this.domainUtil.countAircrafts());
    }

    @Test
    public void testCountCompanies() {
        Assert.assertEquals(Long.valueOf(0L), this.domainUtil.countCompanies());
    }

    @Test
    public void testCountDestinations() {
        Assert.assertEquals(Long.valueOf(0L), this.domainUtil.countDestinations());
    }

    @Test
    public void testCreateCompany() {
        String companyName = "companyName";
        Company company = this.domainUtil.createCompany(companyName);
        Assert.assertNotNull("company doesn't exist", company);
        Assert.assertNotNull("company id doesn't exist", company.getId());
    }

    @Test
    public void testAddAircraftToCompany() {
        Aircraft aircraft = new Aircraft();
        String companyName = "companyName";
        this.domainUtil.addAircraftToCompany(aircraft, companyName);
        Assert.assertNotNull("aircraft id doesn't exist", aircraft.getId());
    }

    @Test
    public void testAddAircraftToCompanyKo() {
        Aircraft aircraft = new Aircraft();
        String companyName = "companyName1";
        this.domainUtil.addAircraftToCompany(aircraft, companyName);
        Assert.assertNull("aircraft id exists", aircraft.getId());
    }

}
