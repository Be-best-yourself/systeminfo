package com.zfw.entity.systeminfo;
/**
 * 内存信息实体
 * @author zhang
 *
 */

import org.hyperic.sigar.SigarException;

import com.zfw.utils.SystemInfoUtils;

public class MemoryEntity {
	private long total;//内存总量
	private double usedPercent;//已使用内存百分比
	private double freePercent;//空闲内存百分比
	private long actualFree;//实际空闲内存
	private long free;//获当前内存剩余量
	private long used;//当前内存使用量
	public MemoryEntity(){
		try {
			this.total=SystemInfoUtils.getMemory().getTotal();
			this.usedPercent=SystemInfoUtils.getMemory().getUsedPercent();
			this.freePercent=SystemInfoUtils.getMemory().getFreePercent();
			this.actualFree=SystemInfoUtils.getMemory().getActualFree();
			this.free=SystemInfoUtils.getMemory().getFree();
			this.used=SystemInfoUtils.getMemory().getUsed();
		} catch (SigarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public double getUsedPercent() {
		return usedPercent;
	}
	public void setUsedPercent(double usedPercent) {
		this.usedPercent = usedPercent;
	}
	public double getFreePercent() {
		return freePercent;
	}
	public void setFreePercent(double freePercent) {
		this.freePercent = freePercent;
	}
	public long getActualFree() {
		return actualFree;
	}
	public void setActualFree(long actualFree) {
		this.actualFree = actualFree;
	}
	public long getFree() {
		return free;
	}
	public void setFree(long free) {
		this.free = free;
	}
	public long getUsed() {
		return used;
	}
	public void setUsed(long used) {
		this.used = used;
	}
}
