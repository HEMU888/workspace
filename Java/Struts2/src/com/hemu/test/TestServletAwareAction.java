package com.hemu.test;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

public class TestServletAwareAction implements ServletRequestAware, ServletContextAware, ServletResponseAware {

	public String execute() {
		return "success";
	}

	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println(arg0);

	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println(arg0);
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println(arg0);
	}

}
