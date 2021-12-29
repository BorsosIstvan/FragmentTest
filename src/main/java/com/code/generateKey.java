package com.code;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
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
    	EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyByte);
		KeyFactory keyFactory = KeyFactory.getInstance("DSA");//DSA , EC
		prvKey = keyFactory.generatePrivate(keySpec);
			
    	return prvKey;
    }
    
    // Function get public key
    public static Key getPublicKey(String publicKey) throws Exception {
    	Key pblKey = null;
    	byte[] publicKeyByte = Base64.getDecoder().decode(publicKey);
    	EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyByte);
    	KeyFactory keyFactory = KeyFactory.getInstance("DSA");//DSA , EC
    	pblKey = keyFactory.generatePublic(keySpec);
    	
    	return pblKey;
    }
    
    // Function generate ECDSA key pair
    public static KeyPair genEcKey() throws Exception {
    	ECGenParameterSpec ecSpec = new ECGenParameterSpec("secp256k1");
    	KeyPairGenerator g = KeyPairGenerator.getInstance("EC");
    	g.initialize(ecSpec, new SecureRandom());
    	KeyPair keypair = g.generateKeyPair();
    	PublicKey publicKey = keypair.getPublic();
    	PrivateKey privateKey = keypair.getPrivate();
    	
    	return keypair;
    }
    
    // Function generate ECDSA public key from encodes key string
    public static Key getEcPublicKey(String pks) throws Exception {
    	EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(pks));
    	KeyFactory keyFactory = KeyFactory.getInstance("EC");
    	Key publicKey = keyFactory.generatePublic(publicKeySpec);
    	
    	return publicKey;
    	
    }
    
    // Functiom generate ECDSA private key from encoded key string
    public static Key getEcPrivateKey(String pks) throws Exception {
    	EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(pks));
    	KeyFactory keyFactory = KeyFactory.getInstance("EC");
    	Key privateKey = keyFactory.generatePrivate(privateKeySpec);
    	
    	return privateKey;
    }

}
