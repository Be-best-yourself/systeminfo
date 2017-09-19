package com.zfw.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zfw.service.StudentService;

public class ServiceTest {
	private ApplicationContext ac=null;
	@Autowired
	@Qualifier(StudentService.SERVICE_NAME)
	private StudentService studentService;
	@Test
	public void test() {
		ac=new ClassPathXmlApplicationContext("classpath:spring-service.xml");
		StudentService bean = ac.getBean(StudentService.class);
		System.out.println(bean);
	}
}
