<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<a href="product-input.action">Product Input</a>
	<br>
	<a href="TestActionContext.action?name=atguigu">TestAction</a>
	<%
		if(application.getAttribute("date") == null){
			application.setAttribute("date", new Date());
		}
	%>
	<br>

	<a href="TestAware.action">TestAware</a>
	<br>

	<a href="TestServletActionContext.action">TestServletActionContext</a>
	<br>
	<a href="TestServletAwareAction.action">TestServletAwareAction</a>
	<br>
	<a href="login-ui.do">Login UI</a>
	<br>
	<a href="testResult.do?number=5">testResult</a>
	<br>

	<a href="UserAction-save.do">save</a>
	<br>
	<a href="UserAction-update.do">update</a>
	<br>
	<a href="UserAction-delete.do">delete</a>
	<br>
	<a href="UserAction-query">query</a>
	<br><br>
	<a href="testDynamicMethodInvocation">Test DynamicMethodInvocation</a>
	<br>
	<a href="TestTag?name=hemu">Test Tag</a>
	<br>
	<a href="emp-list.do">List All Employees(CRUD)</a>

</body>
</html>