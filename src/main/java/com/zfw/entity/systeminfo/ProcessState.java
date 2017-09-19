package com.zfw.entity.systeminfo;

import org.hyperic.sigar.ProcState;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import com.zfw.utils.SystemInfoUtils;

/**
 * 进程信息
 * @author zhang
 *
 */
public class ProcessState {
	private String name;//进程名
	private long pid;//当前进程PID
	private long ppid;//父进程标识pid
	private int priority;//进程的内核调度优先级
	private int processor;//最后运行处理器号
	private char state;//进程的当前状态
	private long threads;//活动线程的数量
	private int _try;//控制终端的设备号码
	/**
	 * 通过进程pid获取进程状态信息的构造函数
	 * @param pid
	 * @throws SigarException
	 */
	public ProcessState(long pid) throws SigarException{
		Sigar sigar = SystemInfoUtils.getSigar();
		ProcState procState = sigar.getProcState(pid);
		this.pid=pid;
		this.name=procState.getName();
		this.ppid=procState.getPpid();
		this.state=procState.getState();
		this._try=procState.getTty();
		this.threads=procState.getThreads();
		this.priority=procState.getPriority();
		this.processor=procState.getProcessor();
	}
	/**
	 * 通过进程名获取进程状态信息的构造函数
	 * @param name
	 * @throws SigarException
	 */
	public ProcessState(String name) throws SigarException{
		Sigar sigar = SystemInfoUtils.getSigar();
		ProcState procState = sigar.getProcState(name);
		this.name=procState.getName();
		ppid=procState.getPpid();
		state=procState.getState();
		_try=procState.getTty();
		threads=procState.getThreads();
		priority=procState.getPriority();
		processor=procState.getProcessor();
	}
	public ProcessState(){
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public long getPpid() {
		return ppid;
	}
	public void setPpid(long ppid) {
		this.ppid = ppid;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getProcessor() {
		return processor;
	}
	public void setProcessor(int processor) {
		this.processor = processor;
	}
	public char getState() {
		return state;
	}
	public void setState(char state) {
		this.state = state;
	}
	public long getThreads() {
		return threads;
	}
	public void setThreads(long threads) {
		this.threads = threads;
	}
	public int get_try() {
		return _try;
	}
	public void set_try(int _try) {
		this._try = _try;
	}
}
