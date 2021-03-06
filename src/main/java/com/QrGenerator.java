package com;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QrGenerator {
	 // Function to create the QR code
    public static void createQR(String data, String path,
                                String charset, Map hashMap,
                                int height, int width)
        throws WriterException, IOException
    {
 
        BitMatrix matrix = new MultiFormatWriter().encode(
            new String(data.getBytes(charset), charset),
            BarcodeFormat.QR_CODE, width, height);
 
        MatrixToImageWriter.writeToFile(
            matrix,
            path.substring(path.lastIndexOf('.') + 1),
            new File(path));
    }
   
    // Driver code
    public static void main(String[] args)
        throws WriterException, IOException,
               NotFoundException
    {
 
        // The data that the QR code will contain
//        String data = "HC1:NCFOXN%TS3DH3ZSUZK+.V0ETD%65NL-AH-R6IOO6+IUKRG*I.I5BROCWAAT4V22F/8X*G3M9JUPY0BX/KR96R/S09T./0LWTKD33236J3TA3M*4VV2 73-E3GG396B-43O058YIB73A*G3W19UEBY5:PI0EGSP4*2DN43U*0CEBQ/GXQFY73CIBC:G 7376BXBJBAJ UNFMJCRN0H3PQN*E33H3OA70M3FMJIJN523.K5QZ4A+2XEN QT QTHC31M3+E32R44$28A9H0D3ZCL4JMYAZ+S-A5$XKX6T2YC 35H/ITX8GL2-LH/CJTK96L6SR9MU9RFGJA6Q3QR$P2OIC0JVLA8J3ET3:H3A+2+33U SAAUOT3TPTO4UBZIC0JKQTL*QDKBO.AI9BVYTOCFOPS4IJCOT0$89NT2V457U8+9W2KQ-7LF9-DF07U$B97JJ1D7WKP/HLIJLRKF1MFHJP7NVDEBU1J*Z222E.GJF67Z JA6B.38O4BH*HB0EGLE2%V -3O+J3.PI2G:M1SSP2Y3D38-G9C+Q3OT/.J1CDLKOYUV5C3W1A:75S4LB:6REPKM3ZYO4+QDNDLT2*ESLIH";
//        String data = "HC1:NCFOXN%TSMAHN-H3ZSUZK+.V0ET9%6-AH-XI1ROR$SIOOV*I+X6FF1+WA5%PH82F/8X*G3M9FQH+4JZW4Z*AK.GNNVR*G0C7PHBO33BC7R7BWBJ+47RK3X77JD7IHJMOJCRN%BB%KNEB32NJND3XSJBG71MJRPFSZ4ZI00T9 E9PF6846A$Q436BPKZXI551DDQV ONM5WOP4LT1833ZCO1B8ZVV5TN%2UP20J5/5LEBFD-48YIWFT-67-C0*E6-RI PQVW5/O16%HAT1Z%PPRAAUICO10W5:EOL:P WUQRELS431TCRVJ0R$%2DU2O3J$NNP5SLAFG.CILFSCA6LF20HFJC3DAYJDPKD4JB2E9Z3E8AE-QD+PB.QCD-H/8O3BEQ8L9VNT7A6LFCD9KWNHPA%8L+5INKE$JDVPL32K01KCZG%V0MEP.4C:5WD$N*7RZRBU2SA1WK I*XTY.1H9EJ$QX E4%KFGO1YNUMVEQEY1M6JI:LFF8I2FD4%TEWKIN5Z0MEOKDL9VPJ 9WD6CW10NBS+3";
//    	String data = "{1:'RO',4:1668979348,6:1637443348,-260:{1:{'r':[{'ci':'URN:UVCI:01:RO:858CC18CFCF5965EF82F60E493349AA5#K','co':'RO','df':'2021-04-04','du':'2021-10-04','fr':'2021-02-20','is':'Ministry of Health, Roemenie','tg':'840539006'}],'dob':'1970-05-07','nam':{'fn':'Borsos','gn':'Istvan','fnt':'BORSOS','gnt':'ISTVAN'},'ver':'1.2.1'}}}";
 
//    	String data = "HC1:6BFNX1:HM*I0PS3TLU.NGMU5AG8JKM:SF9VN1RFBIKJ:3AXL1RR+ 8::N$OAG+RC4NKT1:P4.33GH40HD*98UIHJIDB 4N*2R7C*MCV+1AY3:YP*YVNUHC.G-NFPIR6UBRRQL9K5%L4.Q*4986NBHP95R*QFLNUDTQH-GYRN2FMGO73ZG6ZTJZC:$0$MTZUF2A81R9NEBTU2Y437XCI9DU 4S3N%JRP:HPE3$ 435QJ+UJVGYLJIMPI%2+YSUXHB42VE5M44%IJLX0SYI7BU+EGCSHG:AQ+58CEN RAXI:D53H8EA0+WAI9M8JC0D0S%8PO00DJAPE3 GZZB:X85Y8345MOLUZ3+HT0TRS76MW2O.0CGL EQ5AI.XM5 01LCWBA.RE.-SUYH+S7SBE0%B-KT+YSMFCLTQQQ6LEHG.P46UNL6DA2C$AF-SQ00A58HYO5:M8 7S$ULGC-IP49MZCSU8ST3HDRJNPV3UJADJ9BVV:7K13B4WQ+DCTEG4V8OT09797FZMQ3/A7DU0.3D148IDZ%UDR9CYF";

//    	String data = "HC1:NCFOXN%TSMAHN-H-ZSZHLRB432A+2OM52Z651WGVC536KDJ5S.NNK08WA9%EG70F/8X*G3M9JUPY0BZW4I:A63HNNVR*G0C7PHBO33:X0 QBXP08J3CHNZ/876B5V0%OF5BFBU8VLVUA3:WND:GR-8:LJVTNSZ4SL0EN9UKP0T9WC5PF6846A$QZ76SW6O$9FQ5CVU2+PFQ51C5EWAC1A.GUQ$9WC5499Q$95:UENEUW6646936DNLO$9KZ56DE/.QC$Q3J62:6LZ6O59++9-G9+E93ZM$96PZ6+Q6X46+E5+DP:Q67ZMA$6BVU5SI:TU+MM0W5+R5MX1X%EZ%P WUQRELS4J1T0C7 7FQA7%*4R9T%IVMHFTAFMRTV/37D1XTQP SM7JC0JVE0L+9P8QHLPTHP+47P/GZLGUVPQRHIY1VS11O19Q3GDWA5V  V-UFT8PQ+LS2T30IS/M+W65N7G/E-L8SYD/IJ:JNN4HQE1V-IF:F2EB9CU XRGFV*8L3Y5$RO0AS+JSMS3-NPX2Q*N9MU4%*S2EG";
//      Qr mel:
//        String data = "HC1:NCFOXN%TSMAHN-HBUKN8N2A709SZ%K0II7ZL 437PG/EB2QINOUA4DKJ9C07G5KNO4*J8OX4W$C2VLWLI2P53O8J.V J8$XJK*L5R17PGA-LJ+PJN4G1W5K4C+H6/VWD4B$PUSB$VKCV5--NHTOSR9VE0H+H:PI:IG7Y47%S7Y48YIZ73423ZQT5I3EG32R4UZ2 NVV5TN%2UP20J5/5LEBFD-48YI+T4D-4HRVUMNMD3323R1370RC-4A+2XEN QT QTHC31M3+E3CP456L X4CZKHKB-43.E3KD3OAJ5%IKTCMD3QHBZQJLIFHJP7NVDEBK3JQ7T$$0VON$3LIGF5JNBPIOSU$0O2UKBX33UQKRQ% B/V70TB/UIGSU.44TNP8EF BEFRMLNKNM8POCJPG2:0B+O-GE5G2W49F/R*9O7A692G5TL3HFT7T4 7 EJ1GHB0O+GB:+T:%RBEA35UU.U8ATGWB2KODDV81P9FUHV5JK3%WH+*F0DWRH3+B1LZ9*7F";
        
//      Qr pan:
//        String data = "HC1:NCFOXN%TSMAHN-HBUKN8N2A709SZ%K/A2I:ID 4NPVJ59E3UBP7M*48FJ*0TCV4*XUA2PSGH.+H$NI4L6Q*U%UG/YL WO*Z7ON13.LK.VVNO% R5F4SH4B*F.S57TBLUFEP1Q*V2Q1CTOD-PC/PGSGW$INTICZUC4TX/KQ96/-KKTCY73JC3DG3IFTJ6B3ZCH13H0D3ZCL4JMYAZ+S-A5$XKX6TVTCR/S09T./0LWTKD3323 L0.LJB/S7-SN2H N37J3JFTULJ5CB8X2+36D-I/2DBAJDAJCNB-43 X4VV2 73-E3GG3V20-7TZD5CC9T0H23LV22:PI/E2$4JY/KY.K /3W*UQK9DO9T+U4T9 UP-C9I7F1C9M:0%44UDBQEAJJKKKMWC8DM81O8ZD7-NIYIQM*P4$605VEQ42FDMXG2%M+ZU.RCF5JCD4TSTZ+4-:I 6FIYA*75C%BOKV/R1T-H9U7EOF/:JBZPX4IFXO%XO$8WKS0RK9RUE";
   
//        Qr modif pan han
        String data = "HC1:6BFOXN%TSMAHN-HBUKN8N2A709SZ%K/A2I:ID 4NPVJ59E3UBP7M*48FJ*0TCV4*XUA2PSGH.+H$NI4L6Q*U%UG/YL WO*Z7ON13.LK.VVNO% R5F4SH4B*F.S57TBLUFEP1Q*V2Q1CTOD-PC/PGSGW$INTICZUC4TX/KQ96/-KKTCY73JC3DG3IFTJ6B3ZCH13H0D3ZCL4JMYAZ+S-A5$XKX6TVTCR/S09T./0LWTKD3323 L0.LJB/S7-SN2H N37J3JFTULJ5CB8X2+36D-I/2DBAJDAJCNB-43 X4VV2 73-E3GG3V20-7TZD5CC9T0H23LV22:PI/E2$4JY/KF-KXQ3W*UQK9DO9T+U4T9 UP-C9I7F1C9M:0%44UDBQEAJJKKKMWC8DM81O8ZD7-NIYIQM*P4$605VEQ42FDMXG2%M+ZU.RCF5JCD4TSTZ+4-:I 6FIYA*75C%BOKV/R1T-H9U7EOF/:JBZPX4IFXO%XO$8WKS0+M9SUE";
        
        // The path where the image will get saved
        String path = "src\\main\\resources\\static\\img\\myqr.png";
 
        // Encoding charset
        String charset = "UTF-8";
 
        Map<EncodeHintType, ErrorCorrectionLevel> hashMap
            = new HashMap<EncodeHintType,
                          ErrorCorrectionLevel>();
 
        hashMap.put(EncodeHintType.ERROR_CORRECTION,
                    ErrorCorrectionLevel.L);
 
        // Create the QR code and save
        // in the specified folder
        // as a jpg file
        createQR(data, path, charset, hashMap, 300, 300);
        System.out.println("QR Code Generated!!! ");
    }
}
