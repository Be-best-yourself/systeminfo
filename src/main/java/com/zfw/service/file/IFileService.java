package com.zfw.service.file;

import com.zfw.entity.file.FileEntity;

public interface IFileService {
	public final static String SERICE_NAME="fileService"; 
	void addFile(FileEntity fileEntity);
}
