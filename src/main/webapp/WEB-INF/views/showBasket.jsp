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
	<form:form>
		<table>
			<tr>

				<td>name</td>
				<td>type</td>
				<td>description</td>
				<td>price</td>

			</tr>
			<c:forEach items="${allBuyableItemsInBasket}" var="buyabelItem">
				<tr>
					<td></td>
					<td>${buyabelItem.name}</td>
					<td>${buyabelItem.type}</td>
					<td>${buyabelItem.des}</td>
					<td>${buyabelItem.price}</td>
					<td><label>Count</label><input type="text" name="count"
						value="${buyabelItem.count}" readonly>
					<td><input type="checkbox" name="markedAsDeletedFromBasket"
						value="${buyabelItem.id}"></td>

				</tr>
			</c:forEach>


		</table>

		<td>
			<button type="submit" value="save">save</button>
		</td>
		<div>
			<a href="<spring:url value="/purchase"/>">Purchase-soapWS</a>

		</div>
		<div>
			<a href="<spring:url value="/purchaseRest"/>">Purchase-RestWS</a>
		</div>
	</form:form>
</body>
</html>