package com.zfw.dao;

import java.util.List;

import com.zfw.entity.Student;

public interface IStudentDao {
	void insertStudent(Student student);

	void insertStudentCatchId(Student student);

	void deleteStudentById(int id);

	void updateStudentById(Student student);

	Student selectStudentById(int id);

	List<Student> selectAllStudent();

	List<Student> selectStudentByName(String name);
	
}
