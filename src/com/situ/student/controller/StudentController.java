package com.situ.student.controller;

import java.util.List;

import com.situ.student.entity.Student;
import com.situ.student.exception.NameRepeatException;
import com.situ.student.service.IStudentService;
import com.situ.student.service.impl.StudentServiceImpl;

public class StudentController {
	IStudentService studentService = new StudentServiceImpl();
	
	public boolean add(Student student) throws NameRepeatException {
		return studentService.add(student);
	}
	
	public List<Student> findAll() {
		return studentService.findAll();
	}
}
