<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	<form:form modelAttribute="item">
		<div>
			<div></div>

			<div>
				<label>Name : </label>
				<form:input path="name" />
			</div>
			<div>
				<label>Type : </label>
				<form:input path="type" />
			</div>
			<div>
				<label>Description : </label>
				<form:textarea path="des" rows="5" />
			</div>
			<div>
				<label>price : </label>
				<form:input path="price"  />
			</div>
				
			<div>

				<button type="submit">Save</button>
			</div>
			<div>
				<br>
				<br>
			</div>


		</div>
	</form:form>


</body>
</html>