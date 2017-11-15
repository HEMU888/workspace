<%@page import="com.hemu.tag.City"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		List<City> cities = new ArrayList<City>();
		cities.add(new City(1001, "AA"));
		cities.add(new City(1002, "BB"));
		cities.add(new City(1003, "CC"));
		cities.add(new City(1004, "DD"));

		request.setAttribute("cities", cities);
	%>



	<s:form action="save">
		<s:textfield name="userName" label="UserName"></s:textfield>
		<s:password name="pasword" label="Password"></s:password>
		<s:textarea name="desc" label="Desc" ></s:textarea>

		<s:checkbox name="married" label="Married"></s:checkbox>

		<s:radio name="gender" list="#{'1':'Male','0':'Female' }"></s:radio>
		<s:checkboxlist list="#request.cities"
			listKey="cityId"
			listValue="cityName"
			label="city"
			name="city"
			></s:checkboxlist>

		<s:select list="{11,12,13,14,15,16,17,18,19,20}"
			headerKey=""
			headerValue="--select--"
			name="age"
			label="Age">
			<s:optgroup label="21-30"
				list="#{21:21,22:22,23:23,24:24,25:25,26:26,27:27,28:28,29:29,30:30}"
			></s:optgroup>
			<s:optgroup label="other"
				list="#{31:31}"
			></s:optgroup>
		</s:select>



		<s:submit></s:submit>
	</s:form>


</body>
</html>