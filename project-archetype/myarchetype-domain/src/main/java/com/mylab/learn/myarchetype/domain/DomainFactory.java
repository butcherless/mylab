package com.mylab.learn.myarchetype.domain;

/**
 * Helper for entity creation
 * 
 * @author cmartin
 * 
 */
public class DomainFactory {

	/**
	 * Helper method for entity creation
	 * 
	 * @param name entity name property
	 * @return the entity
	 */
	public static TemplateEntity newTemplateEntity(final String name) {
		TemplateEntity entity = new TemplateEntity();
		entity.setName(name);

		return entity;
	}

	/**
	 * 
	 * @param text
	 * @return
	 */
	public static SimpleText newSimpleText(final String text) {
		SimpleText simpleText = new SimpleText();
		simpleText.setText(text);

		return simpleText;
	}

	/**
	 * 
	 * @param name
	 * @param registration
	 * @return
	 */
	public static Aircraft newAircraft(final String name, final String registration) {
		Aircraft entity = new Aircraft();
		entity.setName(name);
		entity.setRegistration(registration);

		return entity;
	}

	/**
	 * 
	 * @param airportName
	 * @param shortCode
	 * @return
	 */
	public static Destination newDestination(final String airportName, final String shortCode) {
		Destination entity = new Destination();
		entity.setAirportName(airportName);
		entity.setShortCode(shortCode);

		return entity;
	}
	
	public static Company newCompany(final String name) {
	    Company company = new Company();
	    company.setName(name);
	    
	    return company;
	}
}
