package com.situ.student.view;

import java.util.List;
import java.util.Scanner;

import javax.xml.stream.events.EndDocument;

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
			int choose = scanner.nextInt();
			if (choose == 0) {
				break;
			}
			
			switch (choose) {
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
		System.out.println("【1】根据姓名搜索  【2】根据年龄搜索【3】根据性别搜索  【4】根据出生时间段搜索 ");
		int choose = scanner.nextInt();
		List<Student> list = null;
		switch (choose) {
		case 1:// 【1】根据姓名搜索
			System.out.println("请输入要搜索的名字：");
			String name = scanner.next();
			list = findByName(name);
			printStudentList(list);
			break;
		case 2:// 【2】根据年龄搜索
			System.out.println("请输入要搜索的开始年龄：");
			int begin = scanner.nextInt();
			System.out.println("请输入要搜索的结束年龄：");
			int end = scanner.nextInt();
			list = findByAge(begin, end);
			printStudentList(list);
			break;
		case 3:// 【3】根据性别搜索
			System.out.println("请输入要搜索的性别：");
			String gender = scanner.next();
			list = findByGender(gender);
			printStudentList(list);
			break;
		case 4:// 【4】根据出生时间段搜索
			System.out.println("请输入要搜索的开始时间：");
			String beginTime = scanner.next();
			System.out.println("请输入要搜索的结束时间：");
			String endTime = scanner.next();
			list = findByBirthday(beginTime, endTime);
			printStudentList(list);
			break;
		default:
			break;
		}
	}

	private List<Student> findByBirthday(String beginTime, String endTime) {
		return studentController.findByBirthday(beginTime, endTime);
	}

	private List<Student> findByGender(String gender) {
		return studentController.findByGender(gender);
	}

	private List<Student> findByAge(int begin, int end) {
		return studentController.findByAge(begin, end);
	}

	private void printStudentList(List<Student> list) {
		for (Student student : list) {
			System.out.println(student);
		}
	}


	private List<Student> findByName(String name) {
		return studentController.findByName(name);
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
		printStudentList(list);
	}

	private void addStudent() {
		System.out.println("-----添加学生信息--------");
		System.out.println("学生姓名");
		String name = scanner.next();
		System.out.println("学生年龄");
		int age = scanner.nextInt();
		System.out.println("学生性别");
		String gender = scanner.next();
		System.out.println("学生出生日期");
		String birthday = scanner.next();
		
		boolean result = false;
		try {
			result = studentController.add(name, age, gender, birthday);
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
