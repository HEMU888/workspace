<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	
	Cookie []  cookies = request.getCookies();
	if (cookies != null && cookies.length != 0){
		for(Cookie cookie : cookies){
			out.print(cookie.getName()+":"+cookie.getValue());
			out.print("<br>");
		}
	}
	else{
		out.print("没有cookie，正在创建cookie");
		Cookie cookie = new Cookie("name", "testcookie");
		cookie.setMaxAge(30);
		response.addCookie(cookie);
	}
	
%>
<%= request.getContextPath() %>
<%= config.getServletContext().getRealPath("cookie.jsp") %>

</body>
</html>