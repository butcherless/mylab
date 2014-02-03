package com.mylab.learn.myarchetype.core;

import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Test;

public class CipherTest {

	@Test
	public void testTemplateServiceException() {
		Assert.assertTrue(true);
	}

	@Test
	public void testCipher() {
		SecurityHelper helper = new SecurityHelper();
		
		String decodedText = null, clearText = "cipher test message";
		
		byte[] encodedText = helper.encode(clearText);
		
		Assert.assertNotNull(encodedText);
		Assert.assertTrue(encodedText.length > 0);
		
		byte[] decodedBytes = helper.decode(encodedText);
		
		try {
	        decodedText = new String(decodedBytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        	Assert.fail(e.getMessage());
        }
		
		Assert.assertEquals(clearText, decodedText);
	}
	
}
