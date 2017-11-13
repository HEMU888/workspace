package com.hemu.test;

public class UserAction {
	public String save() {
		System.out.println("save");
		return "success-save";
	}
	public String update() {
		System.out.println("update");
		return "success-update";
	}
	public String delete() {
		System.out.println("delete");
		return "success-delete";
	}
	public String query() {
		System.out.println("query");
		return "success-query";
	}
}
