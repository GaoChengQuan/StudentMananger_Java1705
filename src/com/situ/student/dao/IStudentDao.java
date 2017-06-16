package com.situ.student.dao;

import java.util.List;

import com.situ.student.entity.Student;
/**
 * 对Student进行Dao操作的接口
 * @author Gao
 *
 */
public interface IStudentDao {
	/**
	 * 添加学生
	 * @param student
	 * @return true:添加成功  false：添加失败
	 */
	public abstract boolean add(Student student);
	
	/**
	 * 删除学生
	 * @param student
	 * @return true:删除成功  false：删除失败
	 */
	public abstract boolean delete(Student student);
	
	/**
	 * 修改学生
	 * @param student
	 * @return true:修改成功  false：修改失败
	 */
	public abstract boolean update(Student student);
	
	/**
	 * 查询所有的学生信息
	 * @return 返回所有学生的集合
	 */
	public abstract List<Student> findAll();
	
	/**
	 * 根据id查找指定的学生
	 * @param id
	 * @return 返回学生信息
	 */
	public abstract Student findById(int id);
}
