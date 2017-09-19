package com.zfw.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zfw.dao.IStudentDao;
import com.zfw.entity.Student;
/**
 * 测试mybaties是否集成成功
 * @author zhang
 *
 */
public class MybatiesTest {
	private SqlSession sqlSession=null;
	private ApplicationContext ac=null;
	IStudentDao dao=null;
	@Before
	public void testBefore(){
		ac=new ClassPathXmlApplicationContext("spring-db.xml","spring-mybatis.xml");
		SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
		sqlSession = sqlSessionFactory.openSession();
		dao = sqlSession.getMapper(IStudentDao.class);
	}
	@Test
	public void testInsertStudent() {
		System.err.println(sqlSession);
		Student student=new Student("张三", 21, 66);
		dao.insertStudent(student);
	}
	
	@Test
	public void testInsertStudentCatchId(){
		Student student=new Student("王五",32,43);
		dao.insertStudentCatchId(student);
		System.out.println(student);
		sqlSession.commit();
	}
	@Test
	public void testDeleteStudentById(){
		dao.deleteStudentById(1);
		sqlSession.commit();
	}
	@Test
	public void testUpdateStudentById(){
		Student student=new Student();
		student.setId(2);
		student.setName("李四");
		dao.updateStudentById(student);
		sqlSession.commit();
	}
	@Test
	public void testSelectStudentById(){
		Student student = dao.selectStudentById(2);
		System.out.println(student);
	}
	@Test
	public void testSelectAllStudent(){
		List<Student> students = dao.selectAllStudent();
		for (Student student : students) {
			System.out.println(student);
		}
	}
	@Test
	public void testSelectStudentByName(){
		List<Student> students = dao.selectStudentByName("五");
		for (Student student : students) {
			System.out.println(student);
		}
		sqlSession.commit();
	}
	@After
	public void testAfter(){
		if (sqlSession!=null) {
			sqlSession.close();
		}
	}
}