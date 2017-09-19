package com.zfw.utils;

import java.util.ArrayList;
import java.util.List;

import org.hyperic.sigar.ProcMem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.cmd.Ps;
import org.junit.Test;

import com.zfw.entity.systeminfo.ProcessRunInfo;

public class ProcessUtils {
	/**
	 *	查找所有进程信息 
	 * @return
	 */
	public static List<ProcessRunInfo> getAllProcessInfo() {
		List<ProcessRunInfo> processInfos = new ArrayList<ProcessRunInfo>();
		try {
			long[] pids = SystemInfoUtils.getPids();
			for (long pid : pids) {
				processInfos.add(getProcessInfoByPid(pid));
			}
		} catch (SigarException e) {
			e.printStackTrace();
		}
		return processInfos;
	}
	
	public static ProcessRunInfo getProcessInfoByPid(long pid) throws SigarException{
		Ps ps=new Ps();
		ProcessRunInfo processRunInfo=new ProcessRunInfo();
		@SuppressWarnings({ "unchecked", "static-access" })
		List<String> info = ps.getInfo(new Sigar(), pid);
		for (int i = 0; i <= info.size(); i++) {
			switch (i) {
			case 0:
				processRunInfo.setPid(info.get(0));
				break;
			case 1:
				processRunInfo.setUser(info.get(1));
				break;
			case 2:
				processRunInfo.setStartTime(info.get(2));
				break;
			case 3:
				processRunInfo.setMemSize(info.get(3));
				break;
			case 4:
				processRunInfo.setMemUse(info.get(4));
				break;
			case 5:
				processRunInfo.setMemhare(info.get(5));
				break;
			case 6:
				processRunInfo.setState(info.get(6));
				break;
			case 7:
				processRunInfo.setCpuTime(info.get(7));
				break;
			case 8:
				processRunInfo.setName(info.get(8));
				break;
			}
		}
		
		return processRunInfo;
	}
	/**
	 * 判断pid是否存在进程中
	 * @param pid
	 * @return
	 * @throws SigarException
	 */
	public static boolean isHavePidInProcess(long pid) throws SigarException{
		long[] pids=null;
		try {
			pids = SystemInfoUtils.getPids();
		} catch (SigarException e) {
			throw new SigarException("进程中没要查询的pid信息");
		}
		for (long l : pids) {
			if (pid==l) {
				return true;
			}
		}
		return false;
	}

	
	@Test
	public void test() throws SigarException {
		ProcMem procMem = SystemInfoUtils.getSigar().getProcMem(1864);
		System.out.println(procMem.getSize()/1024l/1024l);
		/*System.out.println(isHavePidInProcess(111));*/
		/*List<ProcessRunInfo> processInfo = getAllProcessInfo();
		for (ProcessRunInfo processInfo2 : processInfo) {
			System.out.println(processInfo2);
		}*/

	}
}
