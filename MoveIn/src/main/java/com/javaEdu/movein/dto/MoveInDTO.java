package com.javaEdu.movein.dto;

public class MoveInDTO {
	
	int ren;
	String state;
	String beforeAddr;
	String beforedAddr;
	String afterAddr;
	String afterdAddr;
	String mId;
	
	public MoveInDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public MoveInDTO(int ren, String state, String beforeAddr, String beforedAddr, String afterAddr, String afterdAddr, String mId) {
		// TODO Auto-generated constructor stub
		this.ren = ren;
		this.state = state;
		this.beforeAddr = beforeAddr;
		this.beforedAddr = beforedAddr;
		this.afterAddr = afterAddr;
		this.afterdAddr = afterdAddr;
		this.mId = mId;
	}

	public int getRen() {
		return ren;
	}

	public void setRen(int ren) {
		this.ren = ren;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBeforeAddr() {
		return beforeAddr;
	}

	public void setBeforeAddr(String beforeAddr) {
		this.beforeAddr = beforeAddr;
	}

	public String getBeforedAddr() {
		return beforedAddr;
	}

	public void setBeforedAddr(String beforedAddr) {
		this.beforedAddr = beforedAddr;
	}

	public String getAfterAddr() {
		return afterAddr;
	}

	public void setAfterAddr(String afterAddr) {
		this.afterAddr = afterAddr;
	}

	public String getAfterdAddr() {
		return afterdAddr;
	}

	public void setAfterdAddr(String afterdAddr) {
		this.afterdAddr = afterdAddr;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}
	
}
