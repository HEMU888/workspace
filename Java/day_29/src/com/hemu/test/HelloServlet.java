package com.hemu.test;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class HelloServlet implements Servlet {

	public HelloServlet() {
		System.out.println("helloServlet's constructor.....");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy");

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		System.out.println("getServletConfig");
		;
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		System.out.println("getServletInfo");
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init");
		String user = arg0.getInitParameter("user");
		System.out.println(user);
		
		Enumeration<String> users = arg0.getInitParameterNames();
		while(users.hasMoreElements()) {
			String name = users.nextElement();
			String value = arg0.getInitParameter(name);
			System.out.println(name + ":" + value);
		}
		
		ServletContext context = arg0.getServletContext();
		String path = context.getRealPath("/hello.jsp");
		System.out.println(path);
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service ");
	}

}
