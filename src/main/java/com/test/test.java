package com.test;

import java.io.ByteArrayOutputStream;

import com.GenerateGreenPass;
import com.code.CodeDataQr;
import com.decode.DecodeQrData;

public class test {
	
	public static void main(String args[]) throws Exception {
		// Qr from pan
		String dataQr = "HC1:NCFOXN%TSMAHN-HBUKN8N2A709SZ%K/A2I:ID 4NPVJ59E3UBP7M*48FJ*0TCV4*XUA2PSGH.+H$NI4L6Q*U%UG/YL WO*Z7ON13.LK.VVNO% R5F4SH4B*F.S57TBLUFEP1Q*V2Q1CTOD-PC/PGSGW$INTICZUC4TX/KQ96/-KKTCY73JC3DG3IFTJ6B3ZCH13H0D3ZCL4JMYAZ+S-A5$XKX6TVTCR/S09T./0LWTKD3323 L0.LJB/S7-SN2H N37J3JFTULJ5CB8X2+36D-I/2DBAJDAJCNB-43 X4VV2 73-E3GG3V20-7TZD5CC9T0H23LV22:PI/E2$4JY/KY.K /3W*UQK9DO9T+U4T9 UP-C9I7F1C9M:0%44UDBQEAJJKKKMWC8DM81O8ZD7-NIYIQM*P4$605VEQ42FDMXG2%M+ZU.RCF5JCD4TSTZ+4-:I 6FIYA*75C%BOKV/R1T-H9U7EOF/:JBZPX4IFXO%XO$8WKS0RK9RUE";

//		String dataQr = "HC1:6BFOXN%TSMAHN-H+XO5XF7:UY%FJ.GMB2B2J5B9%*3/04XG47QT1BUKQCW7KCV4*XUA2PWKP/HLIJLKNF8JF7LPMIH-O92UQ6SQN-V8PGNSG3UQ0QQXQGCOOO2WXZQOJ91OG.LT2%4TQ6E:7LYPPTQ*886EOHCRCU7BDL8FF0D9E2LBHHGKLO-K%FGMIA6EAYHILIIX2MBIH2HI6IA9G3V-0FS15*ITAF%Y0NMN:XFLREOH68ZUOP6OH6XO9IE5IVU4S2PQONTI4L6W%S6VH6ZL4XP:N6ON1Z:LBYFEXFMM0DRGR/J4W1DQ55Y52O1QR3L6M+$JK8KCFWMXG*8O7L72:GI5SZUQM/N 16JUVK.APAS-AA*/16.4O19V3ER$U0B1P-VKKRP269%9VSC%9GOS5XG409L$ZJ.87000 VM4ED";

		String dataMel = "HC1:NCFOXN%TSMAHN-HBUKN8N2A709SZ%K0II7ZL 437PG/EB2QINOUA4DKJ9C07G5KNO4*J8OX4W$C2VLWLI2P53O8J.V J8$XJK*L5R17PGA-LJ+PJN4G1W5K4C+H6/VWD4B$PUSB$VKCV5--NHTOSR9VE0H+H:PI:IG7Y47%S7Y48YIZ73423ZQT5I3EG32R4UZ2 NVV5TN%2UP20J5/5LEBFD-48YI+T4D-4HRVUMNMD3323R1370RC-4A+2XEN QT QTHC31M3+E3CP456L X4CZKHKB-43.E3KD3OAJ5%IKTCMD3QHBZQJLIFHJP7NVDEBK3JQ7T$$0VON$3LIGF5JNBPIOSU$0O2UKBX33UQKRQ% B/V70TB/UIGSU.44TNP8EF BEFRMLNKNM8POCJPG2:0B+O-GE5G2W49F/R*9O7A692G5TL3HFT7T4 7 EJ1GHB0O+GB:+T:%RBEA35UU.U8ATGWB2KODDV81P9FUHV5JK3%WH+*F0DWRH3+B1LZ9*7F";
		
		String dataArp = "HC1:NCFOXN%TSMAHN-HBUKN8N2A709SZ%K89245JD 4NPVJ59DX4C8C-RIGWB4TQ NI4EFSYSS"
				+ "%OM6PYE9*FJ UVQC8$.AIGCY0K5$0V+A+6WF5U:IG5-48 2J.C71LP72I"
				+ "+CYII71L:9WK.8NY0S4P "
				+ "98EQPYE9/MVTZU7LAXPMHQ1*P14W19UESU96IA5B8X64SV8UDP4C5K11N4D.PD*NIGDBN"
				+ "+SYIJGDBGIASJLA8KOHSLOJJPAYGI4OIMEDTJCJKDLEDL9CWZJ$7K+ "
				+ "CREDOC0SF1U:7L/5R3FMIAE-B/EMUANLOS9+5LF9OIFR3HDPG*Z1.NN6ALD-IRTGG1WRT7YZQ "
				+ "H9+W30C0E$BUVPQRHIY1+ H1O1TQ3PTAZ6JL3EV4NNZRB3V67I3MUL-49VVY*K:5C/DRFWP"
				+ "+CV.8LP1P$QM06A9%SZRA PAGJPLFFDC4TA7 :HRPJ5FL-7TL13+4P00F/60/XHC0";
		
		String dataAdf = "HC1:6BFOXN%TSMAHN-H3YS1IK47ES6IXJR4E47X5*T917VF+UOGIS1RYZV:X9:IMJZTCV4*XUA2PSGH.+H$NI4L6HUC%UG/YL WO*Z7ON13:LHNG7H8H%BFP8FG4T 9OKGUXI$NIUZUK*RIMI4UUIMI.J9WVHWVH+ZEOV1AT1HRI2UHD4TR/S09T./08H0AT1EYHEQMIE9WT0K3M9UVZSVV*001HW%8UE9.955B9-NT0 2$$0X4PCY0+-CVYCRMTB*05*9O%0HJP7NVDEBO584DKH78$ZJ*DJWP42W5P0QMO6C8PL353X7H1RU0P48PCA7T5MCH5:ZJ::AKU2UM97H98$QP3R8BH9LV3*O-+DV8QJHHY4I4GWU-LU7T9.V+ T%UNUWUG+M.1KG%VWE94%ALU47$71MFZJU*HFW.6$X50*MSYOJT1MR96/1Z%FV3O-0RW/Q.GMCQS%NE";
		
//		ByteArrayOutputStream m = DecodeQrData.DecodeQrData(dataMel);
//		ByteArrayOutputStream p = DecodeQrData.DecodeQrData(dataQr);
//		byte[] a = m.toByteArray();
//		for(int i=0;i<a.length;i++) {
//			System.out.print((char)a[i]);
//		}
//		System.out.println();
//		byte[] b = p.toByteArray();
//		for(int i=0;i<b.length;i++) {
//			System.out.print((char)b[i]);
//		}
//		System.out.println();
//		
//		//change byte 18
//		System.out.println(b[18]);
//		b[18] = -8;
		
//		ByteArrayOutputStream baos = new ByteArrayOutputStream(b.length);
//		baos.write(b, 0, b.length);
//		// prepare deta for qr
//		String preparedText = CodeDataQr.CodeDataQr(baos);
//		System.out.println(preparedText);
//		
//		//generate qr from dataArp
//		String text = preparedText;
		GenerateGreenPass.GenerateGreenPass(dataAdf);

		
		
	}



}
