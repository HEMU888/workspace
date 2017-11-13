package com.hemu.mvcapp.dao;

import javax.management.loading.PrivateClassLoader;

public class CriteriaCustomer {
	private String name;
	private String Address;
	private String Phone;
	
	public String getName() {
		return name == null ? "%%" : "%"+ name +"%";
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return Address == null ? "%%" : "%"+ Address +"%";
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhone() {
		return Phone == null ? "%%" : "%"+ Phone +"%";
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	
	public CriteriaCustomer(String name, String address, String phone) {
		super();
		this.name = name;
		Address = address;
		Phone = phone;
	}
}
