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
				<td></td>
				<td>type</td>
				<td></td>
				<td>description</td>
				<td></td>
				<td>price</td>
				<td></td>
				<td>count</td>
				<td></td>
			</tr>
			<c:forEach items="${purchasedItems}" var="item">
				<tr>
					<td>${item.name}</td>
					<td></td>
					<td>${item.type}</td>
					<td></td>
					<td>${item.des}</td>
					<td></td>
					<td>${item.price}</td>
					<td></td>
					<td>${item.count}</td>
					<td></td>

				</tr>

			</c:forEach>

		
			<td></td>

		</table>

		<div>
			<label>TotalPrice :</label> <input type="text" name="totalPrice"
				value=${totalPrice } readonly />
		</div>


		<div>
			<div></div>
			<button value="pay" name="action">Pay</button>

			<button type="submit" name="action" value="recharge">Recharge</button><label>recharge your account by 100$</label>
		</div>
		<div>
		
			<div id="status_message" name="message">${message }</div>
			<a href="ws/balance.wsdl">Balance.wsdl</a>
	</form:form>


</body>

</html>