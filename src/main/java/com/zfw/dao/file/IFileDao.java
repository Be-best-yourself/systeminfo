package com.zfw.dao.file;

import com.zfw.entity.file.FileEntity;

public interface IFileDao {
	void insertFile(FileEntity fileEntity);
	void insertFileCatchId(FileEntity fileEntity);
}
