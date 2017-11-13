package com.hemu.test;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class TestActionContextAction {
	public String execute(){

		ActionContext actionContext = ActionContext.getContext();

		Map<String, Object> applicationMap = actionContext.getApplication();


		applicationMap.put("applicationKey", "applicationValue");

		Object date = applicationMap.get("date");

		System.out.println(date);

		Map<String, Object> sessionMap= actionContext.getSession();
		sessionMap.put("sessionKey", "sessionValue");

		@SuppressWarnings("unchecked")
		Map<String, Object> requestMap = (Map<String, Object>) actionContext.get("request");
		requestMap.put("requestKey", "requestValue");



		Map<String, Object> parameters = actionContext.getParameters();
		System.out.println(((String[])parameters.get("name"))[0]);
		parameters.put("age", "100");


		return "success";
	}
}
