package com.situ.student.entity;

import java.util.Date;

public class Student {
	private int id;
	private String name;
	private int age;
	private String gender;
	private Date birthday;

	public Student() {
		super();
	}

	public Student(String name, int age, String gender, Date birthday) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.birthday = birthday;
	}
	
	public Student(String name, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public Student(int id, String name, int age, String gender, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.birthday = birthday;
	}

	public Student(int id, String name, int age, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date date) {
		this.birthday = date;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age
				+ ", gender=" + gender + ", birthday=" + birthday + "]";
	}
}
