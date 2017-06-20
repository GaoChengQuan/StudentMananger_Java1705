package com.situ.student.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.situ.student.entity.Student;
import com.situ.student.exception.NameRepeatException;
import com.situ.student.service.IStudentService;
import com.situ.student.service.impl.StudentServiceImpl;

/**
 * controller层作用: 控制层, 获取界面上的数据,为界面设置数据; 将要实现的功能交给业务层处理
 * 后期这一块是SpringMVC帮助我们管理
 * @author Gao
 *
 */
public class StudentController {
	IStudentService studentService = new StudentServiceImpl();
	
	public boolean add(String name, int age, String gender, String birthday) throws NameRepeatException {
		SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = simpleDateFormat.parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Student student = new Student(name, age, gender, date);
		return studentService.add(student);
	}
	
	public List<Student> findAll() {
		return studentService.findAll();
	}
	
	public Student findById(int id) {
		return studentService.findById(id);
	}
	
	public boolean delete(int id) {
		return studentService.delete(id);
	}
	
	public boolean update(int id, String name, int age, String gender) {
		Student student = studentService.findById(id);
		student.setName(name);
		student.setAge(age);
		student.setGender(gender);
		return studentService.update(student);
	}

	public List<Student> findByName(String name) {
		return studentService.findByName(name);
	}

	public List<Student> findByAge(int begin, int end) {
		return studentService.findByAge(begin, end);
	}

	public List<Student> findByGender(String gender) {
		return studentService.findByGender(gender);
	}

	public List<Student> findByBirthday(String beginTime, String endTime) {
		return studentService.findByBirthday(beginTime, endTime);
	}
	
}
