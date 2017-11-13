<%@page import="java.util.List"%>
<%@page import="com.test.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" cellpadding="10" cellspacing="0">
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>删除</th>
		</tr>
	<%
		List<Student> stus = (List<Student>)request.getAttribute("students");
		for(Student s: stus){
	%>
		<tr>
		 	<td>
			<%= s.getId() %>
			</td>
		 	<td>
			<%= s.getName() %>
			</td>
			<td>
				<a href = "deleteStudent?id=<%=s.getId()%>">删除</a>
			</td>
		</tr>
		
	<%		
		}
	%>
	</table>

</body>
</html>