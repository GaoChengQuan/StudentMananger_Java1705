package com.situ.student.service.impl;

import java.util.List;

import com.situ.student.dao.IStudentDao;
import com.situ.student.dao.impl.StudentDaoMysqlImpl;
import com.situ.student.dao.impl.StudentDaoOraclempl;
import com.situ.student.entity.Student;
import com.situ.student.exception.NameRepeatException;
import com.situ.student.service.IStudentService;

public class StudentServiceImpl implements IStudentService{
	//后期这一块是Spring帮助我们管理
	private IStudentDao studentDao = new StudentDaoMysqlImpl();
	//private IStudentDao studentDao = new StudentDaoOraclempl();

	@Override
	public boolean add(Student student) throws NameRepeatException {
		if (studentDao.checkStudent(student)) {
			throw new NameRepeatException("姓名重复");
		} else {
			return studentDao.add(student);
		}
	}

	@Override
	public boolean delete(int id) {
		return studentDao.delete(id);
	}

	@Override
	public boolean update(Student student) {
		return studentDao.update(student);
	}

	@Override
	public List<Student> findAll() {
		return studentDao.findAll();
	}

	@Override
	public Student findById(int id) {
		return studentDao.findById(id);
	}

	@Override
	public List<Student> findByName(String name) {
		return studentDao.findByName(name);
	}

	@Override
	public List<Student> findByAge(int begin, int end) {
		return studentDao.findByAge(begin, end);
	}

	@Override
	public List<Student> findByGender(String gender) {
		return studentDao.findByGender(gender);
	}

	@Override
	public List<Student> findByBirthday(String beginTime, String endTime) {
		return studentDao.findByBirthday(beginTime, endTime);
	}

}
