package com.situ.student.view;

import java.util.List;
import java.util.Scanner;

import com.situ.student.controller.StudentController;
import com.situ.student.entity.Student;
import com.situ.student.exception.NameRepeatException;

/**
 * UI层的界面
 * @author Gao
 *
 */
public class StudentView {
	private Scanner scanner = null;
	private StudentController studentController = null;

	public StudentView() {
		scanner = new Scanner(System.in);
		studentController = new StudentController();
	}
	
	public void showView() {
		
		while (true) {
			System.out.println("-------学生信息管理系统----------");
			System.out.println("【1】查询所有  【2】添加  【3】修改 【4】删除 【0】退出");
			System.out.println("请选择");
			int type = scanner.nextInt();
			if (type == 0) {
				break;
			}
			
			switch (type) {
			case 1://1、查询所有
				showStudentInfos();
				break;
			case 2:
				addStudent();
				break;
			case 3:
				//updateStudent();
				break;
			case 4:
				//deleteStudent();
				break;
			default:
				break;
			}
		}
		
	}

	private void showStudentInfos() {
		List<Student> list = studentController.findAll();
		for (Student student : list) {
			System.out.println(student);
		}
	}

	private void addStudent() {
		System.out.println("-----添加学生信息--------");
		System.out.println("学生姓名");
		String name = scanner.next();
		System.out.println("学生年龄");
		int age = scanner.nextInt();
		System.out.println("学生性别");
		String gender = scanner.next();
		
		Student student = new Student(name, age, gender);
		boolean result = false;
		try {
			result = studentController.add(student);
		} catch (NameRepeatException e) {
			System.out.println("名字重复");
			//e.printStackTrace();
		}
		if (result) {
			System.out.println("插入学生成功");
		} else {
			System.out.println("插入学生失败");
		}
	}
	
}
