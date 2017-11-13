<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="testtag" uri="http://www.hemutest.com/mytag/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<testtag:hello value="inputtest" count ="10" />
	<testtag:frag>qwert</testtag:frag>
	<c:import url="https://www.baidu.com">
		<c:param name="test">hemu</c:param>
	</c:import>
	
</body>
</html>