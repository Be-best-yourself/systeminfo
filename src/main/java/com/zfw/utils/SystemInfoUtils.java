package com.zfw.utils;

import org.hyperic.sigar.Cpu;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.ProcCpu;
import org.hyperic.sigar.ProcMem;
import org.hyperic.sigar.ProcState;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.junit.Test;

/**
 * 获取系统信息工具类
 * @author zhang
 *
 */
public class SystemInfoUtils {
	/**
	 * 获取第三方sigar对象，用于获取系统信息
	 * @return
	 */
	public static Sigar getSigar() {
		return new Sigar();
	} 
	/**
	 * 得到内存对象，用于获取内存信息
	 * @return
	 * @throws SigarException
	 */
	public static Mem getMemory() throws SigarException {
		return getSigar().getMem();
	}
	/**
	 * 得到Cpu对象，
	 * @return
	 * @throws SigarException
	 */
	public static Cpu getCpu() throws SigarException {
		return getSigar().getCpu();
	}
	/**
	 * 获取文件系统信息对象
	 * @throws SigarException
	 */
	public static FileSystem[] getFile() throws SigarException {
		FileSystem[] fileSystems = getSigar().getFileSystemList();
		return fileSystems;
	}
	/**
	 * 获取cpu信息
	 * @return
	 * @throws SigarException
	 */
	public static CpuInfo[] getCpuInfo() throws SigarException {
		return getSigar().getCpuInfoList();
	}
	/**
	 * 获取运行进程PID列表
	 * @return
	 * @throws SigarException
	 */
	public static long[] getPids() throws SigarException {
		 return getSigar().getProcList();
	}
	@Test
	public  void main() throws SigarException {
		long[] pids = getPids();
		for (long l : pids) {
			System.out.println(l);
			ProcState procState = getSigar().getProcState(l);
			System.out.println(procState.getName());
		}
		System.out.println(pids.length);
	}
	@Test
	public void test1() throws SigarException {
		ProcState state = getSigar().getProcState(1316);
		ProcCpu procCpu = getSigar().getProcCpu(1316);
		ProcMem procMem = getSigar().getProcMem(1316);
		System.err.println(procMem.getShare());;
	}
}
