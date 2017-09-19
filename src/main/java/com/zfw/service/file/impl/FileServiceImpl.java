package com.zfw.service.file.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.zfw.dao.file.IFileDao;
import com.zfw.entity.file.FileEntity;
import com.zfw.service.file.IFileService;

public class FileServiceImpl implements IFileService {

	@Autowired
	private IFileDao fileDao;
	@Override
	public void addFile(FileEntity fileEntity) {
		fileDao.insertFile(fileEntity);
	}

}
