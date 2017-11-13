<%@page import="java.util.Date"%>
<%@ page import = "com.hemu.test.Person" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	   Person p = new Person();
	   System.out.println(p.personinfo() );
	   Date d = new Date();
	   System.out.println(d);
	   String path = "";
	   config.getServletContext().getRealPath(path);
	   System.out.println(config.getServletContext().getContextPath());
	   System.out.println(path);
	%>
	<a href="forwardServlet">ForwardServlet</a>
	<br><br>
	<a href="redirectServlet">RedirectServlet</a>
</body>
</html>