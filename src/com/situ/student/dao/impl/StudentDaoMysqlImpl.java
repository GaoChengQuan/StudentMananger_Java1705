package com.situ.student.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.situ.student.dao.IStudentDao;
import com.situ.student.entity.Student;
import com.situ.student.util.JdbcUtil;

public class StudentDaoMysqlImpl implements IStudentDao{

	@Override
	public boolean add(Student student) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "insert into student(name,age,gender,birthday) values(?,?,?,?);";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setString(3, student.getGender());
			//date milliseconds since January 1, 1970,
			preparedStatement.setDate(4, new java.sql.Date(student.getBirthday().getTime()));
			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "delete from student where id=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Student student) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "update student set name=?,age=?,gender=? where id=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setString(3, student.getGender());
			preparedStatement.setInt(4, student.getId());
			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Student> findAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> list = new ArrayList<>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select * from student;";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				Date birthday = resultSet.getDate("birthday");
				Student student = new Student(id, name, age, gender, birthday);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Student findById(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Student student = null;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select * from student where id=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int stuId = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				student = new Student(id, name, age, gender);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public boolean checkStudent(Student student) {
		List<Student> list = findAll();
		boolean isFind = false;
		for (Student stu : list) {
			if (stu.getName().equalsIgnoreCase(student.getName())) {
				isFind = true;
			}
		}
		return isFind;
	}

	@Override
	public List<Student> findByName(String name) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> list = new ArrayList<Student>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select * from student where name like ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%" + name + "%");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String stuName = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				Student student = new Student(id, stuName, age, gender);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Student> findByAge(int begin, int end) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> list = new ArrayList<Student>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select * from student where age>=? and age<=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, begin);
			preparedStatement.setInt(2, end);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String stuName = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				Student student = new Student(id, stuName, age, gender);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Student> findByGender(String gender) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> list = new ArrayList<Student>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select * from student where gender=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, gender);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String stuGender = resultSet.getString("gender");
				Student student = new Student(id, name, age, stuGender);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
