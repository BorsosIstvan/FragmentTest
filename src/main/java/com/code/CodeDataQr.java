package com.code;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;

import nl.minvws.encoding.Base45;

public class CodeDataQr {
	
	public static String CodeDataQr(ByteArrayOutputStream outputStream) {
		
		// zip data
		Deflater d = new Deflater();
        d.setInput(outputStream.toByteArray());
        d.finish();
        byte[] compressedbyte = new byte[outputStream.size()+3];
        int size = d.deflate(compressedbyte);
        d.end();
		
        // generate txt file to ready code qr
        String genText = "HC1:"+Base45.getEncoder().encodeToString(compressedbyte);
        
        // return txt file
        return genText;
		
	}
	


}
