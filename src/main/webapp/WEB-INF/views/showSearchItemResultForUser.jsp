<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>

			<td>name</td>
			<td>type</td>
			<td>description</td>
		</tr>
		<c:forEach items="${result}" var="item">
			<tr>
				<td>${item.name}</td>
				<td>${item.type}</td>
				<td>${item.des}</td>

			</tr>
		</c:forEach>
	</table>
	<a href="<spring:url value="/userShowAllItems"/>"> Show all Items</a>
</body>
</html>