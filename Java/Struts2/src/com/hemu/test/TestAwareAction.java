package com.hemu.test;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

public class TestAwareAction implements ApplicationAware,SessionAware,RequestAware,ParameterAware {
	public String execute(){
		application.put("applicationKey2",	"applicationValue2");

		System.out.println(application.get("date"));
		return "success";
	}

	private Map<String, Object> application;
	private Map<String, Object> session;
	private Map<String, Object> request;
	private Map<String, String[]> parameters;
	@Override
	public void setApplication(Map<String, Object> arg0) {
		// TODO 自動生成されたメソッド・スタブ
		this.application = arg0;
	}
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO 自動生成されたメソッド・スタブ
		this.request = arg0;

	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = arg0;
	}
	@Override
	public void setParameters(Map<String, String[]> arg0) {
		// TODO 自動生成されたメソッド・スタブ
		this.parameters = arg0;
	}
}
