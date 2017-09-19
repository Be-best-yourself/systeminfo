package com.zfw.handles.systeminfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.SigarException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zfw.entity.systeminfo.CpuEntity;
import com.zfw.entity.systeminfo.MemoryEntity;
import com.zfw.entity.systeminfo.ProcessRunInfo;
import com.zfw.entity.systeminfo.ProcessState;
import com.zfw.handles.AbstractController;
import com.zfw.tips.Tips;
import com.zfw.utils.ProcessUtils;
import com.zfw.utils.SystemInfoUtils;

/**
 * 系统信息controller
 * 
 * @author zhang
 *
 */
@Controller
@RequestMapping("/system")
public class SystemInfoController extends AbstractController {
	/**
	 * 内存信息controller
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/mem")
	public ModelAndView getMem(ModelMap model) {
		MemoryEntity memoryEntity = new MemoryEntity();
		super.success(model, memoryEntity);
		return new ModelAndView();
	}

	/**
	 * cpu信息列表
	 * 
	 * @param model
	 * @return
	 * @throws SigarException
	 */
	@RequestMapping("/cpuinfos")
	public ModelAndView getCpuInfoList(ModelMap model) throws SigarException {
		List<CpuEntity> cpuEntities = new ArrayList<CpuEntity>();
		CpuInfo[] cpuInfos = SystemInfoUtils.getCpuInfo();
		int cpuNum = 1;
		for (CpuInfo cpuInfo : cpuInfos) {
			CpuEntity cpuEntity = new CpuEntity();
			cpuEntity.setCpuNum(cpuNum);
			cpuEntity.setmHz(cpuInfo.getMhz());
			cpuEntity.setModel(cpuInfo.getModel());
			cpuEntity.setTotalCores(cpuInfo.getTotalCores());
			cpuEntity.setTotalSockets(cpuInfo.getTotalSockets());
			cpuEntity.setVendor(cpuInfo.getVendor());
			cpuEntities.add(cpuEntity);
			cpuNum++;
		}
		super.success(model, cpuEntities);
		return new ModelAndView();
	}

	/**
	 * 获取所有进程运行时信息，相当于得到top命令的瞬时信息
	 * 
	 * @param model
	 * @return
	 */

	@RequestMapping("/procruninfos")
	public ModelAndView getProcessRunInfoList(ModelMap model) {
		List<ProcessRunInfo> allProcessInfo = ProcessUtils.getAllProcessInfo();
		// list以属性字符串长度
		Collections.sort(allProcessInfo, new Comparator<ProcessRunInfo>() {
			/*
			 * int compare(Student o1, Student o2) 返回一个基本类型的整型， 返回负数表示：o1 小于o2，
			 * 返回0 表示：o1和o2相等， 返回正数表示：o1大于o2。
			 */
			@Override
			public int compare(ProcessRunInfo o1, ProcessRunInfo o2) {
				String o1MemUseString = o1.getMemUse().substring(0, o1.getMemUse().length() - 1);
				String o2MemUseString = o2.getMemUse().substring(0, o2.getMemUse().length() - 1);

				if (Double.valueOf(o1MemUseString) > Double.valueOf(o2MemUseString)) {
					return -1;
				}
				if (Double.valueOf(o1MemUseString) == Double.valueOf(o2MemUseString)) {
					return 0;
				}
				return 1;
			}

		});
		super.success(model, allProcessInfo);
		return new ModelAndView("/process/process");
	}

	/**
	 * 获取指定pid的进程运行时信息
	 * 
	 * @param model
	 * @param pid
	 * @return
	 */
	@RequestMapping("/procruninfo/{pid}")
	public ModelAndView getProcessRunInfoByPid(ModelMap model, @PathVariable long pid) {
		ProcessRunInfo processInfoByPid = null;
		try {
			processInfoByPid = ProcessUtils.getProcessInfoByPid(pid);
		} catch (SigarException e) {
			e.printStackTrace();
		}
		super.success(model, processInfoByPid);
		return new ModelAndView();
	}

	/**
	 * 获取指定pid的进程信息
	 * 
	 * @param model
	 * @param pid
	 * @return
	 * @throws SigarException
	 */
	@RequestMapping("/procinfo/{pid}")
	public ModelAndView getProcessInfoByPid(ModelMap model, @PathVariable long pid) throws SigarException {
		boolean havePidInProcess = ProcessUtils.isHavePidInProcess(pid);
		ProcessState processState = null;
		if (havePidInProcess) {
			processState = new ProcessState(pid);
		} else {
			super.success(model, new Tips(10001, "No such process", "进程中没此pid"));
		}
		super.success(model, processState);
		return new ModelAndView();
	}

}
