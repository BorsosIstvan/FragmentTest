package com.simpson;

import java.util.List;

public class CertificatePayload {
	
	PersonPayload nam;
	List<VaccinationPayload> v;
	String dob;
	String ver;
	
	public String getVer() {
		return ver;
	}
	public void setVer(String ver) {
		this.ver = ver;
	}
	public PersonPayload getNam() {
		return nam;
	}
	public void setNam(PersonPayload nam) {
		this.nam = nam;
	}
	public List<VaccinationPayload> getV() {
		return v;
	}
	public void setV(List<VaccinationPayload> v) {
		this.v = v;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	
}
