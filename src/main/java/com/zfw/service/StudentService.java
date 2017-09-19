package com.zfw.service;

import com.zfw.entity.Student;

public interface StudentService {
	public static final String SERVICE_NAME="studentService";
	public void addStudent(Student student);
	public Student findStudentById(int id);
}
