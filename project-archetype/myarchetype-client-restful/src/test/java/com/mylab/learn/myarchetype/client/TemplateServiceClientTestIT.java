package com.mylab.learn.myarchetype.client;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mylab.learn.myarchetype.service.BusinessEnum;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:template-service-client-integration-test.xml")
public class TemplateServiceClientTestIT {

	@Autowired
	private TemplateServiceRestfulClient client;
	
	@Test
	public void testTemplateOperation() {
		String dummyProperty = BusinessEnum.MAIN_FLOW.toString();
		Boolean result = this.client.callTemplateOperation(dummyProperty);
		
		Assert.assertTrue("main flow", result);
	}

	@Test
	public void testTemplatePutOperation() {
		String dummyProperty = BusinessEnum.MAIN_FLOW.toString();
		Boolean result = this.client.callTemplatePostOperation(dummyProperty);
		
		Assert.assertTrue("main flow", result);
	}


}
