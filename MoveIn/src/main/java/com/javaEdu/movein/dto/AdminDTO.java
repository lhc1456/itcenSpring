package com.javaEdu.movein.dto;

public class AdminDTO {
	
	String aId;
	String aPw;
	String aName;
	
	public AdminDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public AdminDTO(String aId, String aPw, String aName) {
		// TODO Auto-generated constructor stub
		this.aId = aId;
		this.aPw = aPw;
		this.aName = aName;
	}
	
	public String getaId() {
		return aId;
	}
	public void setaId(String aId) {
		this.aId = aId;
	}
	public String getaPw() {
		return aPw;
	}
	public void setaPw(String aPw) {
		this.aPw = aPw;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	
}
