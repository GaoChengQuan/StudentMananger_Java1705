package com.situ.student.app;

import com.situ.student.view.StudentView;
/**
 * 启动应用程序的类
 * @author Gao
 *
 */
public class MainApplication {
	public static void main(String[] args) {
		StudentView studentView = new StudentView();
		studentView.showView();
	}
}
