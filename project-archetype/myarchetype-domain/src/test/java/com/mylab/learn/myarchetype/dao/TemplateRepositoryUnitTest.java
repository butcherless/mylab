package com.mylab.learn.myarchetype.dao;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:template-domain-unit-test.xml")
public class TemplateRepositoryUnitTest extends TemplateRepositoryTestAdapter {

	@Transactional
	@Override
	public void testCreateTemplate() {
		super.testCreateTemplate();
		this.logger.debug("entity created by unit test.");
	}

}