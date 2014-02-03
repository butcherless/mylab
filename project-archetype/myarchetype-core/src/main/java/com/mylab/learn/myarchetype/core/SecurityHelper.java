package com.mylab.learn.myarchetype.core;

import static javax.crypto.Cipher.DECRYPT_MODE;
import static javax.crypto.Cipher.ENCRYPT_MODE;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class SecurityHelper {

	private static final String ALGORITHM = "DES";
	private static final String CHARSET_NAME = "UTF-8";
	private static final String ROO_KEY = "Roo == Java + Productivity";

	public byte[] encode(String text) {
		try {
			return this.crypt(text.getBytes(CHARSET_NAME), ENCRYPT_MODE);
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException(e);
		}
	}

	public byte[] decode(byte[] encodedBytes) {
		return this.crypt(encodedBytes, DECRYPT_MODE);
	}

	/**
	 * Encrypts or decrypts the given input, according to the given
	 * <code>opmode</code>
	 * 
	 * @param input the bytes to operate upon (required)
	 * @param opmode the operation to perform, see the {@link Cipher} class for
	 *        suitable constants
	 * @return a non-<code>null</code> array
	 */
	private byte[] crypt(final byte[] input, final int opmode) {
		final Cipher cipher = getCipher(opmode);
		try {
			return cipher.doFinal(input);
		} catch (final GeneralSecurityException e) {
			throw new IllegalStateException(e);
		}
	}

	private Cipher getCipher(final int opmode) {
		try {
			final DESKeySpec keySpec = new DESKeySpec(ROO_KEY.getBytes(CHARSET_NAME));
			final SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
			final SecretKey skey = keyFactory.generateSecret(keySpec);
			final Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(opmode, skey);
			return cipher;
		} catch (final InvalidKeySpecException e) {
			throw new IllegalStateException(e);
		} catch (final NoSuchPaddingException e) {
			throw new IllegalStateException(e);
		} catch (final NoSuchAlgorithmException e) {
			throw new IllegalStateException(e);
		} catch (final InvalidKeyException e) {
			throw new IllegalStateException(e);
		} catch (final UnsupportedEncodingException e) {
			throw new IllegalStateException(e);
		}
	}

}
