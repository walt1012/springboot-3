package com.wushang.model;

/**
 * @ClassName Student
 * @Description TODO
 * @Author wushang
 * @Date 2019-09-10 14:47
 */
public class Student {
	private Integer id;
	private String username;
	private String gender;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Student(String username, String gender) {
		this.username = username;
		this.gender = gender;
	}

	public Student(Integer id, String username, String gender) {

		this.id = id;
		this.username = username;
		this.gender = gender;
	}

	public Student() {
	}
}
