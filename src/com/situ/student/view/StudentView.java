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
			System.out.println("【1】查询所有  【2】按条件查找  【3】添加  【4】修改 【5】删除  【0】退出");
			System.out.println("请选择");
			int type = scanner.nextInt();
			if (type == 0) {
				break;
			}
			
			switch (type) {
			case 1://1、查询所有
				showStudentInfos();
				break;
			case 2: //【2】按条件查找(姓名、年龄、性别)
				searchByCondition();
				break;
			case 3://【3】添加
				addStudent();
				break;
			case 4://【4】修改
				updateStudent();
				break;
			case 5://【5】删除
				deleteStudent();
				break;
			default:
				break;
			}
		}
		
	}

	private void searchByCondition() {
		
	}

	private void updateStudent() {
		System.out.println("请输入要更新的学生的id");
		int id = scanner.nextInt();
		System.out.println("请输入新的名字:");
		String name = scanner.next();
		System.out.println("请输入新的年龄:");
		int age = scanner.nextInt();
		System.out.println("请输入新的性别:");
		String gender = scanner.next();
		boolean result = studentController.update(id, name, age, gender);
		if (result) {
			System.out.println("修改成功");
		} else {
			System.out.println("修改失败");
		}
	}

	private void deleteStudent() {
		System.out.println("请输入要删除的学生的id");
		int id = scanner.nextInt();
		boolean result = studentController.delete(id);
		if (result) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
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
		
		boolean result = false;
		try {
			result = studentController.add(name, age, gender);
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
