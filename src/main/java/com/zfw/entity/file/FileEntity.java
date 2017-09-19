package com.zfw.entity.file;

import java.util.Date;

public class FileEntity {
	private int id;
	private String fileCode;//文件代码
	private String fileName;//文件名
	private String filePath;//文件路径
	private String fileType;//文件类型
	private Date modifyTime;//修改时间
	private int fileLevel;//文件层级
	private boolean isDirectory;//是否为目录
	private String parentPath;//父路径
	private double fileSize;//文件大小
	private String permission;//权限
	private Date createTime;//创建时间
	private int operTimes;//操作次数
	private int visitTimes;//访问次数
	
	public FileEntity() {
		this.createTime=new Date();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFileCode() {
		return fileCode;
	}
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public int getFileLevel() {
		return fileLevel;
	}
	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
	}
	public boolean isDirectory() {
		return isDirectory;
	}
	public void setDirectory(boolean isDirectory) {
		this.isDirectory = isDirectory;
	}
	public String getParentPath() {
		return parentPath;
	}
	public void setParentPath(String parentPath) {
		this.parentPath = parentPath;
	}
	public double getFileSize() {
		return fileSize;
	}
	public void setFileSize(double fileSize) {
		this.fileSize = fileSize;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getOperTimes() {
		return operTimes;
	}
	public void setOperTimes(int operTimes) {
		this.operTimes = operTimes;
	}
	public int getVisitTimes() {
		return visitTimes;
	}
	public void setVisitTimes(int visitTimes) {
		this.visitTimes = visitTimes;
	}
	@Override
	public String toString() {
		return "FileEntity [id=" + id + ", fileCode=" + fileCode + ", fileName=" + fileName + ", filePath=" + filePath
				+ ", fileType=" + fileType + ", modifyTime=" + modifyTime + ", fileLevel=" + fileLevel
				+ ", isDirectory=" + isDirectory + ", parentPath=" + parentPath + ", fileSize=" + fileSize
				+ ", permission=" + permission + ", createTime=" + createTime + ", operTimes=" + operTimes
				+ ", visitTimes=" + visitTimes + "]";
	}
	
}
