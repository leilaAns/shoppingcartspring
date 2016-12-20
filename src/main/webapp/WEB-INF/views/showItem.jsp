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
	<jsp:include page="adminSideMenu.jsp"></jsp:include>
	<form:form modelAttribute="item">
		<div>
			<div>
				<label>Id : </label>
				<form:input path="Id" id="Id" readonly="true" />
			</div>

			<div>
				<label>Name : </label>
				<form:input path="name" id="name" />
			</div>
			<div>
				<label>Type : </label>
				<form:input path="type" id="type" />
			</div>
			<div>
				<label>Description : </label>
				<form:textarea path="des" rows="5" id="des" />
			</div>

			<div>
				<label>Price : </label>
				<form:input path="price" />
			</div>

			<div>
				<div></div>
				<button type="submit" name="action" value="edit">Edit</button>
				<button type="submit" name="action" value="delete">Delete</button>
			</div>
			<div>
				<br> <br>
			</div>


		</div>
	</form:form>
</body>
</html>