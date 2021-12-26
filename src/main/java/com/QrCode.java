package com;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import nl.minvws.encoding.Base45;

public class QrCode {
	private static final int BUFFER_SIZE = 1024;
	
	public static void main(String args[]) throws Exception {
		
//		Input data from qrCode pan
//		String data = "HC1:NCFOXN%TSMAHN-HBUKN8N2A709SZ%K/A2I:ID 4NPVJ59E3UBP7M*48FJ*0TCV4*XUA2PSGH.+H$NI4L6Q*U%UG/YL WO*Z7ON13.LK.VVNO% R5F4SH4B*F.S57TBLUFEP1Q*V2Q1CTOD-PC/PGSGW$INTICZUC4TX/KQ96/-KKTCY73JC3DG3IFTJ6B3ZCH13H0D3ZCL4JMYAZ+S-A5$XKX6TVTCR/S09T./0LWTKD3323 L0.LJB/S7-SN2H N37J3JFTULJ5CB8X2+36D-I/2DBAJDAJCNB-43 X4VV2 73-E3GG3V20-7TZD5CC9T0H23LV22:PI/E2$4JY/KY.K /3W*UQK9DO9T+U4T9 UP-C9I7F1C9M:0%44UDBQEAJJKKKMWC8DM81O8ZD7-NIYIQM*P4$605VEQ42FDMXG2%M+ZU.RCF5JCD4TSTZ+4-:I 6FIYA*75C%BOKV/R1T-H9U7EOF/:JBZPX4IFXO%XO$8WKS0RK9RUE";

		// poci
		String data = "HC1:6BFOXN%TSMAHN-H+XO5XF7:UY%FJ.GMB2B2J5B9%*3/04XG47QT1BUKQCW7KCV4*XUA2PWKP/HLIJLKNF8JF7LPMIH-O92UQ6SQN-V8PGNSG3UQ0QQXQGCOOO2WXZQOJ91OG.LT2%4TQ6E:7LYPPTQ*886EOHCRCU7BDL8FF0D9E2LBHHGKLO-K%FGMIA6EAYHILIIX2MBIH2HI6IA9G3V-0FS15*ITAF%Y0NMN:XFLREOH68ZUOP6OH6XO9IE5IVU4S2PQONTI4L6W%S6VH6ZL4XP:N6ON1Z:LBYFEXFMM0DRGR/J4W1DQ55Y52O1QR3L6M+$JK8KCFWMXG*8O7L72:GI5SZUQM/N 16JUVK.APAS-AA*/16.4O19V3ER$U0B1P-VKKRP269%9VSC%9GOS5XG409L$ZJ.87000 VM4ED";
		
//		Decode base45 and remove prefix "H1C:"
		byte[] bytecompressed = Base45.getDecoder().decode(data.substring(4));
		
//		Inflate string with zlib
		Inflater inflater = new Inflater();
        inflater.setInput(bytecompressed);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(bytecompressed.length);
        byte[] buffer = new byte[BUFFER_SIZE];
        while (!inflater.finished()) {
            final int count = inflater.inflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        
//       Change data in 
        byte[] byteData = outputStream.toByteArray();
        // change G to H 233-71 to 72
//        byteData[0] = 72;

		// write back to output stream
		ByteArrayOutputStream baos = new ByteArrayOutputStream(outputStream.size());
		baos.writeBytes(byteData);
//		System.out.println(outputStream.toString());
		
		
//		Deflate 
        Deflater d = new Deflater();
        d.setInput(baos.toByteArray());
        d.finish();
        byte[] compressedbyte = new byte[338];
        int size = d.deflate(compressedbyte);
        d.end();
		
        String genText = "HC1:"+Base45.getEncoder().encodeToString(compressedbyte);
        
//        System.out.println(genText);
        GenerateGreenPass.GenerateGreenPass(genText);
        
	}

}
