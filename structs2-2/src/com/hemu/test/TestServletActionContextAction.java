package com.hemu.test;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;


public class TestServletActionContextAction {
	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		ServletContext servletContext = ServletActionContext.getServletContext();

		System.out.println("execute....");
		return "success";
	}
}
