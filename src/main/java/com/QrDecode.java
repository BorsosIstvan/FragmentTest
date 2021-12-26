package com;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import com.google.iot.cbor.CborMap;

import COSE.Encrypt0Message;
import COSE.Message;
import nl.minvws.encoding.Base45;

public class QrDecode {
    private static final int BUFFER_SIZE = 1024;

    public static void main(String args[]) throws Exception{

        // 1 - read text from file
//        File file = new File("green-pass.jpg");
//        BufferedImage bufferedImage = ImageIO.read(file);
//        LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
//        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
//        Result result = new MultiFormatReader().decode(bitmap);
//        String text = result.getText();
//    	String text ="HC1:NCFOXN%TSMAHN-H3ZSUZK+.V0ET9%6-AH-XI1ROR$SIOOV*I+X6FF1+WA5%PH82F/8X*G3M9FQH+4JZW4Z*AK.GNNVR*G0C7PHBO33BC7R7BWBJ+47RK3X77JD7IHJMOJCRN%BB%KNEB32NJND3XSJBG71MJRPFSZ4ZI00T9 E9PF6846A$Q436BPKZXI551DDQV ONM5WOP4LT1833ZCO1B8ZVV5TN%2UP20J5/5LEBFD-48YIWFT-67-C0*E6-RI PQVW5/O16%HAT1Z%PPRAAUICO10W5:EOL:P WUQRELS431TCRVJ0R$%2DU2O3J$NNP5SLAFG.CILFSCA6LF20HFJC3DAYJDPKD4JB2E9Z3E8AE-QD+PB.QCD-H/8O3BEQ8L9VNT7A6LFCD9KWNHPA%8L+5INKE$JDVPL32K01KCZG%V0MEP.4C:5WD$N*7RZRBU2SA1WK I*XTY.1H9EJ$QX E4%KFGO1YNUMVEQEY1M6JI:LFF8I2FD4%TEWKIN5Z0MEOKDL9VPJ 9WD6CW10NBS+3";

//    	String text = "HC1:6BFNX1:HM*I0PS3TLU.NGMU5AG8JKM:SF9VN1RFBIKJ:3AXL1RR+ 8::N$OAG+RC4NKT1:P4.33GH40HD*98UIHJIDB 4N*2R7C*MCV+1AY3:YP*YVNUHC.G-NFPIR6UBRRQL9K5%L4.Q*4986NBHP95R*QFLNUDTQH-GYRN2FMGO73ZG6ZTJZC:$0$MTZUF2A81R9NEBTU2Y437XCI9DU 4S3N%JRP:HPE3$ 435QJ+UJVGYLJIMPI%2+YSUXHB42VE5M44%IJLX0SYI7BU+EGCSHG:AQ+58CEN RAXI:D53H8EA0+WAI9M8JC0D0S%8PO00DJAPE3 GZZB:X85Y8345MOLUZ3+HT0TRS76MW2O.0CGL EQ5AI.XM5 01LCWBA.RE.-SUYH+S7SBE0%B-KT+YSMFCLTQQQ6LEHG.P46UNL6DA2C$AF-SQ00A58HYO5:M8 7S$ULGC-IP49MZCSU8ST3HDRJNPV3UJADJ9BVV:7K13B4WQ+DCTEG4V8OT09797FZMQ3/A7DU0.3D148IDZ%UDR9CYF";

//    	String text = "HC1:NCFOXN%TSMAHN-H-ZSZHLRB432A+2OM52Z651WGVC536KDJ5S.NNK08WA9%EG70F/8X*G3M9JUPY0BZW4I:A63HNNVR*G0C7PHBO33:X0 QBXP08J3CHNZ/876B5V0%OF5BFBU8VLVUA3:WND:GR-8:LJVTNSZ4SL0EN9UKP0T9WC5PF6846A$QZ76SW6O$9FQ5CVU2+PFQ51C5EWAC1A.GUQ$9WC5499Q$95:UENEUW6646936DNLO$9KZ56DE/.QC$Q3J62:6LZ6O59++9-G9+E93ZM$96PZ6+Q6X46+E5+DP:Q67ZMA$6BVU5SI:TU+MM0W5+R5MX1X%EZ%P WUQRELS4J1T0C7 7FQA7%*4R9T%IVMHFTAFMRTV/37D1XTQP SM7JC0JVE0L+9P8QHLPTHP+47P/GZLGUVPQRHIY1VS11O19Q3GDWA5V  V-UFT8PQ+LS2T30IS/M+W65N7G/E-L8SYD/IJ:JNN4HQE1V-IF:F2EB9CU XRGFV*8L3Y5$RO0AS+JSMS3-NPX2Q*N9MU4%*S2EG";
//		Qr from pan
    	String text = "HC1:NCFOXN%TSMAHN-HBUKN8N2A709SZ%K/A2I:ID 4NPVJ59E3UBP7M*48FJ*0TCV4*XUA2PSGH.+H$NI4L6Q*U%UG/YL WO*Z7ON13.LK.VVNO% R5F4SH4B*F.S57TBLUFEP1Q*V2Q1CTOD-PC/PGSGW$INTICZUC4TX/KQ96/-KKTCY73JC3DG3IFTJ6B3ZCH13H0D3ZCL4JMYAZ+S-A5$XKX6TVTCR/S09T./0LWTKD3323 L0.LJB/S7-SN2H N37J3JFTULJ5CB8X2+36D-I/2DBAJDAJCNB-43 X4VV2 73-E3GG3V20-7TZD5CC9T0H23LV22:PI/E2$4JY/KY.K /3W*UQK9DO9T+U4T9 UP-C9I7F1C9M:0%44UDBQEAJJKKKMWC8DM81O8ZD7-NIYIQM*P4$605VEQ42FDMXG2%M+ZU.RCF5JCD4TSTZ+4-:I 6FIYA*75C%BOKV/R1T-H9U7EOF/:JBZPX4IFXO%XO$8WKS0RK9RUE";
    	
    	
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
        
        for (int i=232;i<outputStream.size();i++)
        System.out.print((char)outputStream.toByteArray()[i]);
        System.out.println();
        System.out.println(outputStream.toByteArray()[232]);
        
        
        Deflater d = new Deflater();
        d.setInput(outputStream.toByteArray());
        d.finish();
        byte[] compressedbyte = new byte[400];
        int size = d.deflate(compressedbyte);
        d.end();
//        System.out.println(new String(compressedbyte));
//        System.out.println(new String(bytecompressed));
        
        Inflater i = new Inflater();
        i.setInput(compressedbyte);
        ByteArrayOutputStream oS = new ByteArrayOutputStream(compressedbyte.length);
        byte[] buff = new byte[1024];
        while (!i.finished()) {
        	int counter = i.inflate(buff);
        	oS.write(buff, 0, counter);
        }
        
//        System.out.println(oS.toString());
        
        String genText = "HC1:"+Base45.getEncoder().encodeToString(compressedbyte);
//        System.out.println(genText);


        // 4 - decode COSE message (no signature verification done)
        Message a = Encrypt0Message.DecodeFromBytes(oS.toByteArray());
//        ByteArrayOutputStream baos = Crypt0Message
        
//        System.out.println(a.GetContent().toString());

        // 5 create CborObject MAP
        CborMap cborMap = CborMap.createFromCborByteArray(a.GetContent());
//        System.out.println(cborMap.toString(2));
//        System.out.println(cborMap.toString().length());
        
 
    }
}
