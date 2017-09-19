package com.zfw.entity.systeminfo;

public class CpuEntity {
	private int cpuNum;//第几块Cpu
	private int mHz;//CPU速度
	private String model;//CPU型号
	private int totalCores;//总CPU内核（逻辑）
	private int totalSockets;//总CPU插槽（物理）
	private String vendor;//CPU供应商ID

	public int getCpuNum() {
		return cpuNum;
	}
	public void setCpuNum(int cpuNum) {
		this.cpuNum = cpuNum;
	}
	public int getmHz() {
		return mHz;
	}
	public void setmHz(int mHz) {
		this.mHz = mHz;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getTotalCores() {
		return totalCores;
	}
	public void setTotalCores(int totalCores) {
		this.totalCores = totalCores;
	}
	public int getTotalSockets() {
		return totalSockets;
	}
	public void setTotalSockets(int totalSockets) {
		this.totalSockets = totalSockets;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

}
