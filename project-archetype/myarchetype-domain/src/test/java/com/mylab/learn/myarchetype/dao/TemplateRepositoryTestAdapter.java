package com.mylab.learn.myarchetype.dao;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mylab.learn.myarchetype.domain.SimpleText;
import com.mylab.learn.myarchetype.domain.TemplateEntity;
import com.mylab.learn.myarchetype.domain.Translation;
import com.mylab.learn.myarchetype.repository.SimpleTextRepository;
import com.mylab.learn.myarchetype.repository.TemplateRepository;

public abstract class TemplateRepositoryTestAdapter implements TemplateRepositoryTestInterface {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected TemplateRepository templateRepository;

	@Autowired
	protected SimpleTextRepository simpleTextRepository;

	private TemplateEntity templateEntity;
	private String entityName = "template-name";

	@Before
	public void setUp() {
		this.templateEntity = new TemplateEntity();
		this.templateEntity.setName(entityName);
	}

	@Test
	public void testCreateTemplate() {
		long entityCount = this.templateRepository.count();
		this.templateRepository.save(this.templateEntity);

		Assert.assertNotNull(this.templateEntity.getId());
		Assert.assertEquals("entity count", (entityCount + 1), this.templateRepository.count());
	}

	@Test
	public void testFindByNameTemplate() {
		this.templateRepository.save(this.templateEntity);
		TemplateEntity result = this.templateRepository.findByName(this.entityName);

		Assert.assertNotNull("entity does not exist", result);
		Assert.assertEquals("entity name does not match", this.entityName, result.getName());
	}

	@Test
	public void testUpdateTemplate() {
		String entityNameUpdated = this.entityName + "-updated";
		this.templateRepository.save(this.templateEntity);
		this.templateEntity.setName(entityNameUpdated);
		this.templateRepository.save(this.templateEntity);
		TemplateEntity result = this.templateRepository.findOne(this.templateEntity.getId());
		Assert.assertEquals("entity name has not been updated", entityNameUpdated, result.getName());
	}

	@Test
	public void testDeleteTemplate() {
		this.templateRepository.save(this.templateEntity);
		long entityCount = this.templateRepository.count();
		this.templateRepository.delete(templateEntity);
		Assert.assertEquals("entity count", (entityCount - 1), this.templateRepository.count());
	}

	@Test
	public void testSimpleText() {
		SimpleText simpleText = new SimpleText();
		simpleText.setText("a very simple text");
		
		Translation translationEN = new Translation("en", "english text");
		Translation translationPT= new Translation("pt", "texto português");
		List<Translation> translations = Arrays.asList(translationEN, translationPT);
		
		simpleText.setTranslations(translations);
		
		long entityCount = this.simpleTextRepository.count();
		this.simpleTextRepository.save(simpleText);

		Assert.assertNotNull(simpleText.getId());
		Assert.assertEquals("entity count", (entityCount + 1), this.simpleTextRepository.count());
	}
}
