package com.decode;

import java.io.ByteArrayOutputStream;
import java.util.zip.Inflater;

import com.google.iot.cbor.CborMap;

import COSE.Encrypt0Message;
import COSE.Message;
import nl.minvws.encoding.Base45;

public class DecodeQrData {
	private static final int BUFFER_SIZE = 1024;
	
	public static ByteArrayOutputStream DecodeQrData(String text) throws Exception {
		
        // 2 - remove prefix "HC1:" and decode base45 string
        byte[] bytecompressed = Base45.getDecoder().decode(text.substring(4));
        // 3 - inflate string using zlib
        Inflater inflater = new Inflater();
        inflater.setInput(bytecompressed);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(bytecompressed.length);
        byte[] buffer = new byte[BUFFER_SIZE];
        while (!inflater.finished()) {
            final int count = inflater.inflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        return outputStream;
        // 4 - decode COSE message (no signature verification done)
//        Message a = Encrypt0Message.DecodeFromBytes(outputStream.toByteArray());
        // 5 create CborObject MAP
//        return a;
//        CborMap cborMap = CborMap.createFromCborByteArray(a.GetContent());
        // 6 return data
//        return cborMap;
	}

}
