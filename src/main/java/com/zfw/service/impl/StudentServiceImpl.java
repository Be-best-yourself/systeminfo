package com.zfw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zfw.dao.IStudentDao;
import com.zfw.entity.Student;
import com.zfw.service.StudentService;

@Service(value=StudentService.SERVICE_NAME)
public class StudentServiceImpl implements StudentService {
	@Autowired
	private IStudentDao dao;
	public void addStudent(Student student) {
		System.out.println("========================>"+dao);
		dao.insertStudent(student);;
	}
	public Student findStudentById(int id) {
		return dao.selectStudentById(id);
	}
}
