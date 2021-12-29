package com.simpson;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.CompressorStreamFactory;

import com.GenerateGreenPass;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.upokecenter.cbor.CBORObject;

import COSE.AlgorithmID;
import COSE.Attribute;
import COSE.HeaderKeys;
import COSE.KeyKeys;
import COSE.OneKey;
import COSE.Sign1Message;
import nl.minvws.encoding.Base45;

public class Encoding {
	
	public static void main(String args[]) throws Exception {
		
		// data to json
		List<VaccinationPayload> vaccinations = new ArrayList<>();
		VaccinationPayload vaccine = new VaccinationPayload();
		
		vaccine.setCi("URN:UVCI:01:DE:187/37512422923");
		vaccine.setCo("DE");
		vaccine.setDn(2); // Dose number: 2
		vaccine.setDt("2021-09-24");
		vaccine.setIs("Robert Koch-Institut");
		vaccine.setMa("ORG-100030215"); // Biontech
		vaccine.setMp("EU/1/20/1528");
		vaccine.setSd(2); // Expected doses: 2
		vaccine.setTg("840539006");
		vaccine.setVp("1119349007"); // COVID-19 mRNA vaccine

		vaccinations.add(vaccine);

		PersonPayload person = new PersonPayload();
		person.setFn("SIMPSON");
		person.setGn("HOMER");
		person.setFnt("SIMPSON");
		person.setGnt("HOMER");

		CertificatePayload certificate = new CertificatePayload();
		certificate.setNam(person);
		certificate.setV(vaccinations);
		certificate.setDob("1956-05-12");
		certificate.setVer("1.3.0");


		ObjectMapper mapper  = new ObjectMapper();
		mapper.setVisibility(mapper.getSerializationConfig()
			.getDefaultVisibilityChecker()
			.withFieldVisibility(Visibility.ANY)
			.withGetterVisibility(Visibility.NONE)
			.withSetterVisibility(Visibility.NONE)
			.withCreatorVisibility(Visibility.NONE));

		String json = mapper.writeValueAsString(certificate);
		
		System.out.println(json);
		
		// json to cbor
		
		long issuedAtSec = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli() / 1000L;
		long expirationSec = LocalDateTime.now().plusYears(1).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli() / 1000L;

		CBORObject map = CBORObject.NewMap();
		map.set(CBORObject.FromObject(1), CBORObject.FromObject("DE"));
		map.set(CBORObject.FromObject(6), CBORObject.FromObject(issuedAtSec));
		map.set(CBORObject.FromObject(4), CBORObject.FromObject(expirationSec));
		CBORObject hcertVersion = CBORObject.NewMap();
		CBORObject hcert = CBORObject.FromJSONString(json);
		hcertVersion.set(CBORObject.FromObject(1), hcert);
		map.set(CBORObject.FromObject(-260), hcertVersion);

		byte[] cbor = map.EncodeToBytes();
		
		System.out.println("Cbor: "+new String(cbor));
		
		// cbor to cose
		
		OneKey privateKey = OneKey.generateKey(AlgorithmID.ECDSA_256);
		byte[] kid = UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8);

		Sign1Message msg = new Sign1Message();
		msg.addAttribute(HeaderKeys.Algorithm, privateKey.get(KeyKeys.Algorithm), Attribute.PROTECTED);
		msg.addAttribute(HeaderKeys.KID, CBORObject.FromObject(kid), Attribute.PROTECTED);
		msg.SetContent(cbor);
		msg.sign(privateKey);

		byte[] cose = msg.EncodeToBytes();
		
		System.out.println("Cose: "+new String(cose));
		
		// get public key and signature
		
		
		
		// cose to compressed
		
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		try (CompressorOutputStream deflateOut = new CompressorStreamFactory()
			.createCompressorOutputStream(CompressorStreamFactory.DEFLATE,
			stream)) {
				deflateOut.write(cose);
			}
		byte[] zip = stream.toByteArray();
		
		// compressed to base45
		
		String base45 = Base45.getEncoder().encodeToString(zip);
		
		// add prefix HC1
		
		String hc1 = "HC1:" + base45;
		
		System.out.println(hc1);
		
		// generate qr simpson
		
		GenerateGreenPass.GenerateGreenPass(hc1 , "simpson");
		
	}

}
