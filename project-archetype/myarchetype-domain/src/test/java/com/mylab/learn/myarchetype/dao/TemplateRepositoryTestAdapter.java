package com.mylab.learn.myarchetype.dao;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.mylab.learn.myarchetype.domain.Aircraft;
import com.mylab.learn.myarchetype.domain.Destination;
import com.mylab.learn.myarchetype.domain.SimpleText;
import com.mylab.learn.myarchetype.domain.TemplateEntity;
import com.mylab.learn.myarchetype.domain.Translation;
import com.mylab.learn.myarchetype.repository.AircraftRepository;
import com.mylab.learn.myarchetype.repository.DestinationRepository;
import com.mylab.learn.myarchetype.repository.SimpleTextRepository;
import com.mylab.learn.myarchetype.repository.TemplateRepository;

public abstract class TemplateRepositoryTestAdapter implements TemplateRepositoryTestInterface {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected TemplateRepository templateRepository;

	@Autowired
	protected SimpleTextRepository simpleTextRepository;

	@Autowired
	protected AircraftRepository aircraftRepository;

	@Autowired
	protected DestinationRepository destinationRepository;

	private TemplateEntity templateEntity;
	private String entityName = "template-name";

	@Before
	public void setUp() {
		this.templateEntity = new TemplateEntity();
		this.templateEntity.setName(entityName);
	}

	@Test
	@Transactional
	public void testCreateTemplate() {
		long entityCount = this.templateRepository.count();
		this.templateRepository.save(this.templateEntity);

		Assert.assertNotNull(this.templateEntity.getId());
		Assert.assertEquals("entity count", (entityCount + 1), this.templateRepository.count());
	}

	@Test
	@Transactional
	public void testFindByNameTemplate() {
		this.templateRepository.save(this.templateEntity);
		TemplateEntity result = this.templateRepository.findByName(this.entityName);

		Assert.assertNotNull("entity does not exist", result);
		Assert.assertEquals("entity name does not match", this.entityName, result.getName());
	}

	@Test
	@Transactional
	public void testUpdateTemplate() {
		String entityNameUpdated = this.entityName + "-updated";
		this.templateRepository.save(this.templateEntity);
		this.templateEntity.setName(entityNameUpdated);
		this.templateRepository.save(this.templateEntity);
		TemplateEntity result = this.templateRepository.findOne(this.templateEntity.getId());
		Assert.assertEquals("entity name has not been updated", entityNameUpdated, result.getName());
	}

	@Test
	@Transactional
	public void testDeleteTemplate() {
		this.templateRepository.save(this.templateEntity);
		long entityCount = this.templateRepository.count();
		this.templateRepository.delete(templateEntity);
		Assert.assertEquals("entity count", (entityCount - 1), this.templateRepository.count());
	}

	@Test
	@Transactional
	public void testSimpleText() {
		SimpleText simpleText = new SimpleText();
		simpleText.setText("a very simple text");

		Translation translationEN = new Translation("en", "english text");
		Translation translationPT = new Translation("pt", "texto português");
		List<Translation> translations = Arrays.asList(translationEN, translationPT);

		simpleText.setTranslations(translations);

		long entityCount = this.simpleTextRepository.count();
		this.simpleTextRepository.save(simpleText);

		Assert.assertNotNull(simpleText.getId());
		Assert.assertEquals("entity count", (entityCount + 1), this.simpleTextRepository.count());
	}

	@Test
	@Transactional
	public void testCreateAircraft() {
		Aircraft entity = this.createPicosDeEuropaAircraft();
		long entityCount = this.aircraftRepository.count();
		this.aircraftRepository.save(entity);

		Assert.assertNotNull(entity.getId());
		Assert.assertEquals("entity count", (entityCount + 1), this.aircraftRepository.count());
	}

	@Test
	@Transactional
	public void testCreateDestination() {
		String airportName = "Madrid Barajas";
		String shortCode = "MAD";
		Destination entity = this.createDestination(airportName, shortCode);
		long entityCount = this.destinationRepository.count();
		this.destinationRepository.save(entity);

		Assert.assertNotNull(entity.getId());
		Assert.assertEquals("entity count", (entityCount + 1), this.destinationRepository.count());
	}

	@Test
	@Transactional
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

	@Test
	@Transactional
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

	@Test
	@Transactional
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

	private Aircraft createAircraft(String name, String registration) {
		Aircraft entity = new Aircraft();
		entity.setName(name);
		entity.setRegistration(registration);

		return entity;
	}

	private Destination createDestination(String airportName, String shortCode) {
		Destination entity = new Destination();
		entity.setAirportName(airportName);
		entity.setShortCode(shortCode);

		return entity;
	}

	private Aircraft createPicosDeEuropaAircraft() {
		String name = "Picos de Europa";
		String registration = "EC-LUB";

		return this.createAircraft(name, registration);
	}

	private Destination createBarajasDestination() {
		String airportName = "Madrid Barajas";
		String shortCode = "MAD";

		return this.createDestination(airportName, shortCode);
	}

	private Destination createLasPalmasDestination() {
		String airportName = "Las Palmas de Gran Canaria";
		String shortCode = "LPA";

		return this.createDestination(airportName, shortCode);
	}

}
