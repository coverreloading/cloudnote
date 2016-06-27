package com.cloudnote.entity;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

/**
 * 	FileName: User.java
 *	desc: 用户实体类.
 */

public class User  {

	private long id;
	private int userId;
	private String userName;
	private String password;
	private String email;
	private int age;
	private String sex;
	private String phone;
	private int displayPic;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDisplayPic() {
		return displayPic;
	}

	public void setDisplayPic(int displayPic) {
		this.displayPic = displayPic;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "user{" +
				"Id=" + id +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", age=" + age +
				", sex='" + sex + '\'' +
				", phone='" + phone + '\'' +
				", displayPic=" + displayPic +
				'}';
	}





}
