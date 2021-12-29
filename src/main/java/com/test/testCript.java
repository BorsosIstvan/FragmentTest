package com.test;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Base64;

import com.code.Cript;
import com.code.generateKey;

public class testCript {
	
	public static void main(String args[]) throws Exception {
		
		// test crilp text
		String text = "Hello word! Text to code and later decode.";
		String key = "This is the secret key";
		
		String textEncrypted = Cript.encrypt(text, key);
		
		System.out.println(textEncrypted);
		
		// test decrypt encrypted text
		String textDecrypted = Cript.decrypt(textEncrypted, key);
		
		System.out.println(textDecrypted);
		
		// generate keypair
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA"); // DSA , EC
		keyPairGenerator.initialize(512);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		
		// test sign text
		String signature = Cript.sign(text, keyPair.getPrivate());
		
		System.out.println("Signature: "+signature);
		
		// verify signature
		boolean verified = Cript.verify(text, signature, keyPair.getPublic());
		
		System.out.println("Signature is: "+verified);
		
		// print keys
		String privateKeyString = Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded());
		String publicKeyString = Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded());
		System.out.println("privateKey: "+privateKeyString);
		System.out.println("publicKey: "+publicKeyString);
		String prvKeyString = "MIICXAIBADCCAjUGByqGSM44BAEwggIoAoIBAQCPeTXZuarpv6vtiHrPSVG28y7FnjuvNxjo6sSWHz79NgbnQ1GpxBgzObgJ58KuHFObp0dbhdARrbi0eYd1SYRpXKwOjxSzNggooi/6JxEKPWKpk0U0CaD+aWxGWPhL3SCBnDcJoBBXsZWtzQAjPbpUhLYpH51kjviDRIZ3l5zsBLQ0pqwudemYXeI9sCkvwRGMn/qdgYHnM423krcw17njSVkvaAmYchU5Feo9a4tGU8YzRY+AOzKkwuDycpAlbk4/ijsIOKHEUOThjBopo33fXqFD3ktm/wSQPtXPFiPhWNSHxgjpfyEc2B3KI8tuOAdl+CLjQr5ITAV2OTlgHNZnAh0AuvaWpoV499/e5/pnyXfHhe8ysjO65YDAvNVpXQKCAQAWplxYIEhQcE51AqOXVwQNNNo6NHjBVNTkpcAtJC7gT5bmHkvQkEq9rI837rHgnzGC0jyQQ8tkL4gAQWDt+coJsyB2p5wypifyRz6Rh5uixOdEvSCBVEy1W4AsNo0fqD7UielOD6BojjJCilx4xHjGjQUntxyaOrsLC+EsRGiWOefTznTbEBplqiuH9kxoJts+xy9LVZmDS7TtsC98kOmkltOlXVNb6/xF1PYZ9j897buHOSXC8iTgdzEpbaiH7B5HSPh++1/et1SEMWsiMt7lU92vAhErDR8C2jCXMiT+J67ai51LKSLZuovjntnhA6Y8UoELxoi34u1DFuHvF9veBB4CHEyQjH1oZ0nE1RxPdKQWDMivL6aHf54f2uWPvWw=";
		String pblKeyString = "MIIDQjCCAjUGByqGSM44BAEwggIoAoIBAQCPeTXZuarpv6vtiHrPSVG28y7FnjuvNxjo6sSWHz79NgbnQ1GpxBgzObgJ58KuHFObp0dbhdARrbi0eYd1SYRpXKwOjxSzNggooi/6JxEKPWKpk0U0CaD+aWxGWPhL3SCBnDcJoBBXsZWtzQAjPbpUhLYpH51kjviDRIZ3l5zsBLQ0pqwudemYXeI9sCkvwRGMn/qdgYHnM423krcw17njSVkvaAmYchU5Feo9a4tGU8YzRY+AOzKkwuDycpAlbk4/ijsIOKHEUOThjBopo33fXqFD3ktm/wSQPtXPFiPhWNSHxgjpfyEc2B3KI8tuOAdl+CLjQr5ITAV2OTlgHNZnAh0AuvaWpoV499/e5/pnyXfHhe8ysjO65YDAvNVpXQKCAQAWplxYIEhQcE51AqOXVwQNNNo6NHjBVNTkpcAtJC7gT5bmHkvQkEq9rI837rHgnzGC0jyQQ8tkL4gAQWDt+coJsyB2p5wypifyRz6Rh5uixOdEvSCBVEy1W4AsNo0fqD7UielOD6BojjJCilx4xHjGjQUntxyaOrsLC+EsRGiWOefTznTbEBplqiuH9kxoJts+xy9LVZmDS7TtsC98kOmkltOlXVNb6/xF1PYZ9j897buHOSXC8iTgdzEpbaiH7B5HSPh++1/et1SEMWsiMt7lU92vAhErDR8C2jCXMiT+J67ai51LKSLZuovjntnhA6Y8UoELxoi34u1DFuHvF9veA4IBBQACggEARyrtfmvESwJD60SYooDhbt6E5JIJAKWYcql9DGKRZBdIhRwg1uGrPo6/aHXnfYzOh+FzT5u4dcW67TtUJp5ZJX+UYQ3dEpf44hjABNo8GHoe+0JZSIL0+7/fpFWdtiGM4nx4ripk0CnAWzmJ/b+jiKQqk9dJKV8kHGb5QVU/cP83bVMOXt4/FtZQZCbjrbj0Dy73bdOWsiy1eosEj4UkUX9TUdpdqqt4vF4sAFoy3mdUVfl+cbjASR6kRi8drvKjsqgkaIiPc5od8WDvfvwoGmf3XZGFQWOxR3hTU6lskXTw6aCgS3cu4wGbZC5B/3PsSOZkTevn4rBAaze5zaHoPQ==";
		
		System.out.println("privateKey is same = "+privateKeyString.equals(prvKeyString));
		System.out.println("publicKey is same = "+publicKeyString.equals(pblKeyString));
		
		// attempt to create key prom string
		Key privateKeyGet = generateKey.getPrivateKey(prvKeyString);
		Key publicKeyGet = generateKey.getPublicKey(pblKeyString);
		
		// check if keys works
		String signatureGet = Cript.sign(text, privateKeyGet);
		System.out.println(signatureGet);
		boolean verifiedGet = Cript.verify(text, signatureGet, publicKeyGet);
		System.out.println("verified get = "+verifiedGet);
		
		// check greenpass keys
		String greenPrvKey = "MD4CAQAwEAYHKoZIzj0CAQYFK4EEAAoEJzAlAgEBBCA/91TedBb60HkhPBTZZE7WNhCjnb1UTBxRNnlMtN9wZg==";
		String greenPubKey = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEnL9+WnIp9fvbcocZSGUFlSw9ffW/jbMONzcvm1X4c+pXOPEs7C4/83+PxS8Swea2hgm/tKt4PI0z8wgnIehojw==";
		// generate keys from green
		Key grePrvKeyGen = generateKey.getEcPrivateKey(greenPrvKey);
		Key grePubKeyGen = generateKey.getEcPublicKey(greenPubKey);
		// try sign text with green keys
//		String signGreText = Cript.sign(text, grePrvKeyGen);
		// verify if work
//		boolean verifiedGreen = Cript.verify(text, signatureGet, grePubKeyGen);
//		System.out.println("Green signature validation is: "+verifiedGreen);
		
		// attempt to generate ECDSA key
		KeyPair kp = generateKey.genEcKey();
		String puks = Base64.getEncoder().encodeToString(kp.getPublic().getEncoded());
		String prks = Base64.getEncoder().encodeToString(kp.getPrivate().getEncoded());
		
		System.out.println("publicKey: "+prks);
		System.out.println("privateKey: "+puks);
		
		// sign Ec text
		String signatureEcText = Cript.signEc(text, prks);
		System.out.println("Signature Ec : "+signatureEcText);
		
		// verify signature
		boolean verifiedEc = Cript.verifyEc(text, signatureEcText, greenPubKey);
		System.out.println("Text signature Ec validation is: "+verifiedEc);
		
			
	}
	

}
