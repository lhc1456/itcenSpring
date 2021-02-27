package com.javaEdu.movein.dto;

public class AddrCodeDTO {
	
	String code;
	String sido;
	String gugun;

	public AddrCodeDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public AddrCodeDTO(String code, String sido, String gugun) {
		// TODO Auto-generated constructor stub
		this.code = code;
		this.sido = sido;
		this.gugun = gugun;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getGugun() {
		return gugun;
	}

	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	
}
