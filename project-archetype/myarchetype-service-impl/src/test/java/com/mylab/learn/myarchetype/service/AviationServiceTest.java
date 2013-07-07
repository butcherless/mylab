package com.mylab.learn.myarchetype.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mylab.learn.myarchetype.domain.Aircraft;
import com.mylab.learn.myarchetype.domain.Destination;
import com.mylab.learn.myarchetype.domain.DomainFactory;
import com.mylab.learn.myarchetype.repository.AircraftRepository;
import com.mylab.learn.myarchetype.repository.DestinationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:aviation-service-unit-test.xml")
public class AviationServiceTest {

	@Autowired
	private AircraftRepository aircraftRepository;
	@Autowired
	private DestinationRepository destinationRepository;

	@Autowired
	private AviationService aviationService;

	@Before
	public void setUp() {
		Destination destination = DomainFactory.newDestination("barajas", "mad");
		this.destinationRepository.save(destination);
		Assert.assertNotNull(destination.getId());
	}

	@Transactional
	@Test
	public void testCreateAircraftWithDestination() {
		Long id = this.aviationService.dummyOperation();

		Assert.assertNotNull(id);
		Assert.assertTrue(this.destinationRepository.count() == 1);
		Assert.assertTrue(this.aircraftRepository.count() == 1);

		Assert.assertTrue(this.countAircraftDestinations(id) == 1);
	}

	private int countAircraftDestinations(Long id) {
		Aircraft aircraft = this.aircraftRepository.findOne(id);
		Assert.assertNotNull(aircraft);
		// TODO Auto-generated method stub
		return aircraft.destinationCount();
	}

}
