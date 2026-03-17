<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="Dashboard.jsp" />
	<div class="container mt-5 p-3"
		style="width: 400px; background-color: #e0e0e0">
		<form name="frm" action="login" method="POST">
			<div class="form-group m-3 ">
				<input type="text" name="username" value=""
					placeholder="Enter username" class="form-control">
			</div>
			<div class="form-group m-3 ">
				<input type="password" name="password" value=""
					placeholder="Enter Passwor" class="form-control">
			</div>
			<div class="form-group m-3 ">
				<input type="submit" name="submit" value="Login" class="form-control">
			</div>
			Create New Account<a style="text-decoration: none;" class="fw-bold" href="reg">Sign up</a>
		</form>

	</div>
</body>
</html>