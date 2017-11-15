package com.hemu.tag;

import java.util.List;

public class UserAction {
	private String userName;
	private String userId;
	private String password;
	private String desc;
	private boolean married;
	private String gender;
	private List<String> city;
	public List<String> getCity() {
		return city;
	}
	public void setCity(List<String> city) {
		this.city = city;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	private String age;

	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String save() {
		System.out.println(this);
		return "input";
	}
	@Override
	public String toString() {
		return "UserAction [userName=" + userName + ", userId=" + userId + ", password=" + password + ", desc=" + desc
				+ ", married=" + married + ", gender=" + gender + ", city=" + city + ", age=" + age + "]";
	}





}
