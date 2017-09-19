package com.zfw.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDataTest {
	private ApplicationContext ac=null;

	/**
	 * 测试数据源是否配置成功
	 */
	@Test
	public void test() {
		ac=new ClassPathXmlApplicationContext("classpath:spring-db.xml");
		DataSource dataSource = (DataSource) ac.getBean("dataSource");
		System.out.println(dataSource);
	}
}
