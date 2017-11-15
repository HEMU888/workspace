<%@page import="com.hemu.test.PersonComparator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hemu.test.Person"%>
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
	<h4>Common Tag Page</h4>
	<s:debug></s:debug>
	<br>
	<s:property value="#parameters.name[0]" />
	<br>
	<s:url value="/testUrl" var="url">
	<!--对value值自动解析  -->
		<s:param name="productId" value="productId"></s:param>
	</s:url>
	${url }
	<br>
	<s:url value="/testUrl" var="url2">
	<!--对value值不自动解析  -->
		<s:param name="productId" value="'productId'"></s:param>
		<s:param name="date" value="#session.date"></s:param>
	</s:url>
	${url2 }

	<br>
	<s:url action="testAction" namespace="/helloWorld" method="save" var="url4">
	<!--对value值不自动解析  -->
		<s:param name="productId" value="'productId'"></s:param>
	</s:url>
	${url4 }

	<br>
	<s:url value="testUrl" var="url5" includeParams="get"></s:url>
	${url5 }

	<br>
	s:set: 向page，request，session，application对象中加入一个值
	<br>
	<s:set name="productName" value="productName" scope="request"></s:set>
	productName: ${requestScope.productName }
	<br>
	s:push: 把一个对象在标签开始后压入到值栈中，标签结束时，弹出值栈
	<br>
	<%
		Person person = new Person();
		person.setName("personname");
		person.setAge(55);

		request.setAttribute("person", person);
	%>
	<s:push value="#request.person">
		${name }
	</s:push>
	<br>
	--${name }--
	<br>
	s:if, s:else, s:elseif
	<br>
	<s:if test="productPrice > 1000">
		I7处理器
	</s:if>
	<s:elseif test="productPrice > 800">
		I5处理器
	</s:elseif>
	<s:else>
		I3处理器
	</s:else>
	<br>
	s:iterator 遍历集合，吧这个可遍历的对象里面的每一个元素一次压入和弹出

	<%
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("DD", 40));
		persons.add(new Person("AA", 10));
		persons.add(new Person("CC", 30));
		persons.add(new Person("BB", 20));

		request.setAttribute("persons", persons);
	%>
	<br>
	<s:iterator value="#request.persons" status="status">
		index:${status.index }-count:${status.count }: ${name } - ${age } <br>
	</s:iterator>
	<br>
	s:sor 可以对集合中的元素进行排序
	<br>
	<%
		PersonComparator pc = new PersonComparator();
		request.setAttribute("comparator", pc);
	%>
	<s:sort comparator="#request.comparator" source="#request.persons" var="persons2"></s:sort>
	<s:iterator value="#attr.persons2">
		index:${status.index }-count:${status.count }: ${name } - ${age } <br>
	</s:iterator>
	<br>
	s:date 可以对date进行排版
	<br>
	<%
		session.setAttribute("date", new Date());
	%>
	<s:date name="#session.date" format="yyyy-MM-dd hh:mm:ss" var="date2"/>
	Date：${date2 }
	<br>
	<s:iterator value="#attr.persons" status="status">
	<!-- 可以使用%{}把属性包装起来，进行OGNL强制解析  -->
		<s:a href="getPerson.action?name=%{name}">${name }<br></s:a>
	</s:iterator>

</body>
</html>