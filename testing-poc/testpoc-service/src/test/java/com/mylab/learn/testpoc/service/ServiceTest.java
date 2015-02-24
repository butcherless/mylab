package com.mylab.learn.testpoc.service;

import org.junit.Assert;
import org.junit.Test;

import com.mylab.learn.tools.test.TestUtils;

public class ServiceTest {

	@Test
	public void testException() {
		try {
			TestUtils.testException(MessageServiceException.class);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}
}
