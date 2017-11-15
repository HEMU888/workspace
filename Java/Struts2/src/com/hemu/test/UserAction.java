package com.hemu.test;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

public class UserAction implements SessionAware,ApplicationAware {

	private String username;

	public void setUsername(String username){
		this.username = username;
	}

	public String execute() {

		session.put("username", username);

		Integer count = (Integer)application.get("count");

		if(count == null){
			count = 0;
		}

		count++;

		application.put("count", count);



		return "login-success";
	}

	public String logout() {

		Integer count = (Integer)application.get("count");
		if(count != null && count > 0){
			count--;
			application.put("count", count);
		}

		((SessionMap)session).invalidate();

		return "logout-success";
	}

	private Map<String, Object> session;
	private Map<String, Object> application;
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = arg0;
	}

	@Override
	public void setApplication(Map<String, Object> arg0) {
		// TODO 自動生成されたメソッド・スタブ
		this.application = arg0;
	}


	public String save() {
		System.out.println("save");
		return "success-save";
	}
	public String update() {
		System.out.println("update");
		return "success-update";
	}
	public String delete() {
		System.out.println("delelte");
		return "success-delete";
	}
	public String query() {
		System.out.println("query");
		return "success-query";
	}
}
