package com.code;

import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Base64;

import javax.crypto.Cipher;

public class Cript {
	// Function encrypt
	public static String encrypt(String text, String key) throws Exception {
		
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, generateKey.setKey(key));
        
        return Base64.getEncoder().encodeToString(cipher.doFinal(text.getBytes("UTF-8")));
    }
	
	// Function decrypt
	public static String decrypt(String text, String key) {
		
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, generateKey.setKey(key));
			
			return new String(cipher.doFinal(Base64.getDecoder().decode(text)));
		} catch (Exception e) {}
		return null;
	}
	
	// Function signature
	public static String sign(String text, Key privateKey) throws Exception {
		
		Signature signature = Signature.getInstance("SHA256WithDSA");
		signature.initSign((PrivateKey) privateKey);
		signature.update(text.getBytes());
		byte[] digitalSignature = signature.sign();

		return Base64.getEncoder().encodeToString(digitalSignature);
		
	}
	
	// Function verify signature
	public static boolean verify(String text, String digitalSignature,Key publicKey) throws Exception {
		
		Signature signature = Signature.getInstance("SHA256WithDSA");
		signature.initVerify((PublicKey) publicKey);
		signature.update(text.getBytes());
		byte[] byteDigitalSignature = Base64.getDecoder().decode(digitalSignature);
		
		return signature.verify(byteDigitalSignature);
		
	}
	
	// Function sign EC
	public static String signEc(String text, String key) throws Exception {
		Signature sign = Signature.getInstance("SHA256withECDSA");
		Key privateKey = generateKey.getEcPrivateKey(key);
		sign.initSign((PrivateKey) privateKey);
		sign.update(text.getBytes("UTF-8"));
		byte[] signature = sign.sign();
		
		return Base64.getEncoder().encodeToString(signature);
	}
	
	// Function verify Ec signature
	public static boolean verifyEc(String text, String signString, String key) throws Exception {
		Signature sign = Signature.getInstance("SHA256withECDSA");
		Key publicKey = generateKey.getEcPublicKey(key);
		sign.initVerify((PublicKey) publicKey);
		sign.update(text.getBytes());
		
		return sign.verify(Base64.getDecoder().decode(signString));
	}

}
