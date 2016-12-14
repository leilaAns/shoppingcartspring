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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<a href="<spring:url value="/createNewItem"/>">Create New Item</a>
	</div>
	<table>
		<tr>
			<td>Id</td>
			<td>name</td>
			<td>type</td>
			<td>description</td>
		</tr>
		<c:forEach items="${allItems}" var="item">
			<tr>
				<td><a href='<spring:url value="/showItem/${item.id}"/>'>${item.id}</td>
				<td>${item.name}</td>
				<td>${item.type}</td>
				<td>${item.des}</td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>