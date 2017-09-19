package com.zfw.tips;

public class Tips {
	private int numCode;
	private String enCode;
	private String zhCode;

	public Tips(int numCode, String enCode, String zhCode) {
		this.numCode = numCode;
		this.enCode = enCode;
		this.zhCode = zhCode;
	}

	public int getNumCode() {
		return numCode;
	}

	public void setNumCode(int numCode) {
		this.numCode = numCode;
	}

	public String getEnCode() {
		return enCode;
	}

	public void setEnCode(String enCode) {
		this.enCode = enCode;
	}

	public String getZhCode() {
		return zhCode;
	}

	public void setZhCode(String zhCode) {
		this.zhCode = zhCode;
	}
	
}
