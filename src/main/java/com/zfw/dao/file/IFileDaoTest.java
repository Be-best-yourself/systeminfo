package com.zfw.dao.file;

import java.io.File;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zfw.entity.file.FileEntity;
/**
 * 测试文件dao
 * @author zhang
 *
 */
public class IFileDaoTest {
	private ApplicationContext ac=null;
	private SqlSession sqlSession;
	private SqlSessionFactory sqlSessionFactory;
	private IFileDao fileDao;
	@Before
	public void before() {
		ac=new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-db.xml");
		sqlSessionFactory = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
		sqlSession=sqlSessionFactory.openSession();
		fileDao = sqlSession.getMapper(IFileDao.class);
	}
	@Test
	public void testInsertFile() {
		File file=new File("F:\\eclipse");
		FileEntity fileEntity=new FileEntity();
		fileEntity.setFileName(file.getName());
		fileEntity.setFilePath(file.getPath());
		fileEntity.setFileSize(file.length());
		fileEntity.setParentPath(file.getParent());
		fileDao.insertFile(fileEntity);
	}
	
	
	@After
	public void after() {
		if (sqlSession!=null) {
			sqlSession.close();
		}
	}
}
