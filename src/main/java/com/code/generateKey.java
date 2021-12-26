package com.code;

import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class generateKey {
	
	private static SecretKey secretKey;
    private static byte[] key;
    
    // Function generate key from string
    public static SecretKey setKey(String myKey) throws Exception {
    	MessageDigest sha = null;
    	key = myKey.getBytes("UTF-8");
    	sha = MessageDigest.getInstance("SHA-1");
    	key = sha.digest(key);
    	key = Arrays.copyOf(key, 16);
    	secretKey = new SecretKeySpec(key, "AES");
    	
    	return secretKey;
    }
    
    // Function get private key
    public static Key getPrivateKey(String privateKey) throws Exception {
    	Key prvKey = null;
    	byte[] privateKeyByte = Base64.getDecoder().decode(privateKey);
    	PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyByte);
		KeyFactory keyFactory = KeyFactory.getInstance("DSA");//DSA
		prvKey = keyFactory.generatePrivate(keySpec);
			
    	return prvKey;
    }
    
    // Function get public key
    public static Key getPublicKey(String publicKey) throws Exception {
    	Key pblKey = null;
    	byte[] publicKeyByte = Base64.getDecoder().decode(publicKey);
    	X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyByte);
    	KeyFactory keyFactory = KeyFactory.getInstance("DSA");//DSA
    	pblKey = keyFactory.generatePublic(keySpec);
    	
    	return pblKey;
    }

}
