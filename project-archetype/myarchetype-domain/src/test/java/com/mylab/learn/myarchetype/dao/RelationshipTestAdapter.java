package com.mylab.learn.myarchetype.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.mylab.learn.myarchetype.domain.Aircraft;
import com.mylab.learn.myarchetype.domain.Destination;
import com.mylab.learn.myarchetype.domain.DomainFactory;
import com.mylab.learn.myarchetype.repository.AircraftRepository;
import com.mylab.learn.myarchetype.repository.DestinationRepository;

public abstract class RelationshipTestAdapter implements RelationshipTestInterface {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected AircraftRepository aircraftRepository;

	@Autowired
	protected DestinationRepository destinationRepository;

	@Override
	@Transactional
	@Test
	public void testCreateAircraft() {
		Aircraft entity = this.createPicosDeEuropaAircraft();
		long entityCount = this.aircraftRepository.count();
		this.aircraftRepository.save(entity);

		Assert.assertNotNull(entity.getId());
		Assert.assertEquals("entity count", (entityCount + 1), this.aircraftRepository.count());
	}

	@Override
	@Transactional
	@Test
	public void testExistsAircraft() {
		Aircraft entity = this.createPicosDeEuropaAircraft();
		this.aircraftRepository.save(entity);
		Assert.assertNotNull(entity.getId());
		Assert.assertTrue(this.aircraftRepository.exists(entity.getId()));
	}
	
	@Override
	@Transactional
	@Test
	public void testNotExistsAircraft() {
		Assert.assertFalse(this.aircraftRepository.exists(Long.MAX_VALUE));
	}
	
	@Override
	@Transactional
	@Test
	public void testCreateDestination() {
		Destination destination = this.createBarajasDestination();

		this.destinationRepository.save(destination);

		Assert.assertNotNull(destination.getId());
		Assert.assertEquals("entity count", 1L, this.destinationRepository.count());
	}

	@Override
	@Transactional
	@Test
	public void testCreateAircraftWithDestinations() {
		Aircraft aircraft = this.createPicosDeEuropaAircraft();

		this.aircraftRepository.save(aircraft);

		// aircraft asserts
		Assert.assertNotNull(aircraft.getId());
		Assert.assertEquals("aircraft count", 1L, this.aircraftRepository.count());

		Destination destination = this.createBarajasDestination();

		aircraft.addDestination(destination);
		Assert.assertTrue("aircraft has not destinations", aircraft.hasDestinations());

		destination = this.createLasPalmasDestination();

		aircraft.addDestination(destination);
		Assert.assertTrue("aircraft has not destinations", aircraft.hasDestinations());

		// destination asserts
		Assert.assertEquals("destination count", 2L, this.destinationRepository.count());
	}

	@Override
	@Transactional
	@Test
	public void testAddDestinationToAircraft() {
		Aircraft aircraft = this.createPicosDeEuropaAircraft();

		Destination destination = this.createBarajasDestination();

		aircraft.addDestination(destination);

		this.aircraftRepository.save(aircraft);

		// aircraft asserts
		Assert.assertNotNull(aircraft.getId());
		Assert.assertEquals("aircraft count", 1L, this.aircraftRepository.count());
		Assert.assertTrue("aircraft has not destinations", aircraft.hasDestinations());

		// destination asserts
		Assert.assertEquals("destination count", 1L, this.destinationRepository.count());

		destination = this.createLasPalmasDestination();

		List<Aircraft> aircraftList = this.aircraftRepository.findByRegistration(aircraft.getRegistration());
		Assert.assertFalse("aircraft must exist", aircraftList.isEmpty());
		Aircraft aircraftFound = aircraftList.get(0);

		aircraftFound.addDestination(destination);

		// destination asserts
		Assert.assertEquals("destination count", 2L, this.destinationRepository.count());

		aircraftList = this.aircraftRepository.findByRegistration(aircraft.getRegistration());
		aircraftFound = aircraftList.get(0);
		// aircraft asserts
		Assert.assertTrue("v", 2 == aircraftFound.destinationCount());
	}

	@Override
	@Transactional
	@Test
	public void testRemoveDestinationFromAircraft() {
		Aircraft aircraft = this.createPicosDeEuropaAircraft();

		this.aircraftRepository.save(aircraft);

		// aircraft asserts
		Assert.assertNotNull(aircraft.getId());
		Assert.assertEquals("aircraft count", 1L, this.aircraftRepository.count());

		Destination destination = this.createBarajasDestination();

		aircraft.addDestination(destination);
		Assert.assertTrue("aircraft has not destinations", aircraft.hasDestinations());

		destination = this.createLasPalmasDestination();

		aircraft.addDestination(destination);
		Assert.assertTrue("aircraft has not destinations", aircraft.hasDestinations());

		// destination asserts
		Assert.assertEquals("destination count", 2L, this.destinationRepository.count());

		List<Aircraft> aircraftList = this.aircraftRepository.findByRegistration(aircraft.getRegistration());
		Assert.assertFalse("aircraft must exist", aircraftList.isEmpty());
		Aircraft aircraftFound = aircraftList.get(0);

		List<Destination> destinationList = this.destinationRepository.findByShortCode(destination.getShortCode());
		Destination destinationFound = destinationList.get(0);
		aircraftFound.removeDestination(destinationFound);

		// destination asserts
		Assert.assertEquals("destination count", 1L, this.destinationRepository.count());
	}

	// //////// H E L P E R S

	private Aircraft createPicosDeEuropaAircraft() {
		String name = "Picos de Europa";
		String registration = "EC-LUB";

		return DomainFactory.newAircraft(name, registration);
	}

	private Destination createBarajasDestination() {
		String airportName = "Madrid Barajas";
		String shortCode = "MAD";

		return DomainFactory.newDestination(airportName, shortCode);
	}

	private Destination createLasPalmasDestination() {
		String airportName = "Las Palmas de Gran Canaria";
		String shortCode = "LPA";

		return DomainFactory.newDestination(airportName, shortCode);
	}

}
