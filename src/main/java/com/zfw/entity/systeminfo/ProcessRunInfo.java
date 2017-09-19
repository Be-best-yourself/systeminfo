package com.zfw.entity.systeminfo;

import org.junit.Test;

public class ProcessRunInfo {

	private String pid;

	private String user;

	private String startTime;

	private String memSize;

	private String memUse;

	private String memhare;

	private String state;

	private String cpuTime;

	private String name;

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getMemSize() {
		return memSize;
	}

	public void setMemSize(String memSize) {
		this.memSize = memSize;
	}

	public String getMemUse() {
		return memUse;
	}

	public void setMemUse(String memUse) {
		this.memUse = stringKToMUtil(memUse);
	}

	public String getMemhare() {
		return memhare;
	}

	public void setMemhare(String memhare) {
		this.memhare = memhare;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCpuTime() {
		return cpuTime;
	}

	public void setCpuTime(String cpuTime) {
		this.cpuTime = cpuTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProcessInfo [pid=" + pid + ", user=" + user + ", startTime=" + startTime + ", memSize=" + memSize
				+ ", memUse=" + memUse + ", memhare=" + memhare + ", state=" + state + ", cpuTime=" + cpuTime
				+ ", name=" + name + "]";
	}

	public String stringKToMUtil(String str) {
		if (str != null && !"".equals(str) && str.endsWith("K")) {
			String substring = str.substring(0, str.length() - 1);
			double douK = Double.valueOf(substring);
			// 保留两位小数
			String douM = (String.format("%.2f", douK / 1024));
			str = douM + "M";
		}
		if (str != null && !"".equals(str) && str.endsWith("M")) {
			Double substring = Double.valueOf(str.substring(0, str.length() - 1));
			String douM = (String.format("%.2f", substring));
			str=douM+"M";
		}
		return str;
	}
	@Test
	public void test(){
		System.out.println(stringKToMUtil("10M"));
	}
}
