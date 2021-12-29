package com.test;

import java.security.KeyPair;
import java.security.Signature;
import java.util.Base64;

import com.code.generateKey;
import com.decode.DecodeQrData;
import com.google.iot.cbor.CborMap;

public class testPass {
	
	public static void main(String args[]) throws Exception {
		
		// Generate ec keys
//		KeyPair keyPair = generateKey.genEcKey();
//		System.out.println("privateKey: "+Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded()));
//		System.out.println("publicKey: "+Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded()));
		
		// Generated keys copyed from terminal
		String privateKey = "MD4CAQAwEAYHKoZIzj0CAQYFK4EEAAoEJzAlAgEBBCD1GKBtiyPfBav2B73aqLhM+YxRh4+ZH6c2bFr2TrS98w==";
		String publicKey = "MFYwEAYHKoZIzj0CAQYFK4EEAAoDQgAEiA+6Vcemkw0gjVpdEJHiTPvshC3LSAgNx09h+vdA0CB895o1joYoC/lYzIThYYSdZYhZeB4RnPQU5yDsBPWdpA==";
		
		// Data to test signature
		String data = "HC1:6BFOXN%TSMAHN-H3YS1IK47ES6IXJR4E47X5*T917VF+UOGIS1RYZV:X9:IMJZTCV4*XUA2PSGH.+H$NI4L6HUC%UG/YL WO*Z7ON13:LHNG7H8H%BFP8FG4T 9OKGUXI$NIUZUK*RIMI4UUIMI.J9WVHWVH+ZEOV1AT1HRI2UHD4TR/S09T./08H0AT1EYHEQMIE9WT0K3M9UVZSVV*001HW%8UE9.955B9-NT0 2$$0X4PCY0+-CVYCRMTB*05*9O%0HJP7NVDEBO584DKH78$ZJ*DJWP42W5P0QMO6C8PL353X7H1RU0P48PCA7T5MCH5:ZJ::AKU2UM97H98$QP3R8BH9LV3*O-+DV8QJHHY4I4GWU-LU7T9.V+ T%UNUWUG+M.1KG%VWE94%ALU47$71MFZJU*HFW.6$X50*MSYOJT1MR96/1Z%FV3O-0RW/Q.GMCQS%NE";
		
		// Decode and deinflate and get cbormap
		CborMap cborMapData = DecodeQrData.DecodeQrData(data);
		Signature sign = null;
		
	}

}
