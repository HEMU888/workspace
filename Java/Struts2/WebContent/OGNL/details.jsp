<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
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
	<h4>Details Page</h4>
	<s:debug></s:debug>
	<h4>OGNL获取值栈</h4>
	ProductName: <s:property value="[1].productName" />
	<br><br>
	ProductDesc: <s:property value="[0].productDesc" />
	<br><br>
	ProductPrice: <s:property value="productPrice" />

	<h4>OGNL获取request session</h4>
	ProductName1: ${sessionScope.product.productName }-OGNL:
	<s:property value="#session.product.productName"/>
	<br><br>
	ProductName2: ${requestScope.test.productName }-OGNL:
	<s:property value="#request.test.productName"/>

	<h4>OGNL调用public类静态字段和public静态方法</h4>
	<s:property value="@java.lang.Math@PI" />

	<h4>调用对象栈的方法为一个属性</h4>
	<s:property value="setProductName('atguigu') "/>
	ProductName: <s:property value="productName" />

	<h4>调用数组对象的属性</h4>
	<%
		String[] names = new String[]{"aaa","bbb","ccc"};
		request.setAttribute("names", names);
	%>
	length:<s:property value="#attr.names.length" />
	<br>
	names[2]:<s:property value="#attr.names[2]" />

	<h4>Map调用</h4>
	<%
		Map<String, String> letters = new HashMap<String,String>();
		request.setAttribute("letters", letters);
		letters.put("AA","a");
		letters.put("BB","b");
		letters.put("CC","c");
		letters.put("DD","d");
	%>

	Map count:<s:property value="#attr.letters.size" />
	<br>
	AA:<s:property value="#attr.letters['AA']" />

</body>
</html>