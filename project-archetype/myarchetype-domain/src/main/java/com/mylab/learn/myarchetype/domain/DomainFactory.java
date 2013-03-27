package com.mylab.learn.myarchetype.domain;

public class DomainFactory {

	/**
	 * Helper method for entity creation
	 * 
	 * @param name
	 *            entity name property
	 * @return the entity
	 */
	public static TemplateEntity newTemplateEntity(final String name) {
		TemplateEntity entity = new TemplateEntity();
		entity.setName(name);

		return entity;
	}
}
