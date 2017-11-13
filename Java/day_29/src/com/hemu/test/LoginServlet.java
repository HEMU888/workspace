package com.hemu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class LoginServlet extends HttpServlet {
	
	private ServletContext Context = null;
	private ServletConfig Config = null;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		this.Context = arg0.getServletContext();
		this.Config = arg0;
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("qing qiu lai le ");
		System.out.println(arg0.getParameter("user") + "aaa");
		System.out.println(arg0.getParameter("password"));
		
		Map<String, String[]> map = (Map<String, String[]>) arg0.getParameterMap();
		for(Map.Entry<String, String[]>  entry: map.entrySet()) {
			System.out.println("**" + entry.getKey() + Arrays.asList(entry.getValue())  );
		}
		
		HttpServletRequest hsr = (HttpServletRequest) arg0;
		
		System.out.println(hsr.getRequestURI());
		System.out.println(hsr.getRequestURL());
		System.out.println(hsr.getMethod());
		
		PrintWriter out = arg1.getWriter();
		String username = arg0.getParameter("user");
		String password = arg0.getParameter("password");
		
		String inituser = Context.getInitParameter("user");
		String initpassword = Context.getInitParameter("password");
		
		if(username.equals(inituser) && password.equals(initpassword)) {
			out.println( "hello:" + username);
		}
		else {
			out.println("sorry:" + username);
		}
		String path = "LoginServlet.java";
		
		
		
		System.out.println(Context.getRealPath(path));
		System.out.println(Context.getContextPath());
		
	}

}
