package com.situ.student.test;

import java.util.List;

import org.junit.Test;

import com.situ.student.dao.IStudentDao;
import com.situ.student.dao.impl.StudentDaoMysqlImpl;
import com.situ.student.entity.Student;

public class TestStudentDaoMysqlImpl {
	
	@Test
	public void testAdd() {
		Student student = new Student("xxx", 99, "男");
		IStudentDao studentDao = new StudentDaoMysqlImpl();
		boolean result = studentDao.add(student);
		if (result) {
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败");
		}
	}
	
	@Test
	public void testDelete() {
		Student student = new Student(7, "xxx", 99, "男");
		IStudentDao studentDao = new StudentDaoMysqlImpl();
		boolean result = studentDao.delete(student);
		if (result) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
	}
	
	@Test
	public void testUpdate() {
		Student student = new Student(8, "aaaa", 199, "男");
		IStudentDao studentDao = new StudentDaoMysqlImpl();
		boolean result = studentDao.update(student);
		if (result) {
			System.out.println("更新成功");
		} else {
			System.out.println("更新失败");
		}
	}
	
	@Test
	public void testfindAll() {
		IStudentDao studentDao = new StudentDaoMysqlImpl();
		List<Student> list = studentDao.findAll();
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	@Test
	public void testFindById() {
		IStudentDao studentDao = new StudentDaoMysqlImpl();
		Student student= studentDao.findById(8);
		System.out.println(student);
	}
}
