package com.mylab.learn.myarchetype.service;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mylab.learn.myarchetype.core.Validator;
import com.mylab.learn.myarchetype.repository.TemplateRepository;
import com.mylab.learn.myarchetype.repository.TemplateRepositoryImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:template-service-unit-test.xml")
public class TemplateServiceUnitTest extends TemplateServiceTestAdapter {

	@Before
	public void setUp() {
		Validator requestValidator = new TemplateRequestValidator();
		TemplateRepository templateRepository = new TemplateRepositoryImpl();
		TemplateServiceImpl templateServiceImpl = new TemplateServiceImpl();

		templateServiceImpl.setRequestValidator(requestValidator);
		templateServiceImpl.setTemplateRepository(templateRepository);

		super.templateService = templateServiceImpl;
	}

	@Override
	public void testMainTemplateOperation() {
		this.logger.debug("before service operation");
		super.testMainTemplateOperation();
		this.logger.debug("after service operation");
	}

}
