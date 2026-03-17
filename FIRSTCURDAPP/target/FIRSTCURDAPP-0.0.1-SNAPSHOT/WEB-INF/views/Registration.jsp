<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="Dashboard.jsp" />
	<div class="container mt-5 p-3"
		style="width: 400px; background-color: #e0e0e0">
		<form name='frm' action="register" method="POST">
			<div class="form-group m-3">
				<input type="text" name="uname" value=""
					placeholder="Enter your name" class="form-control">
			</div>
			<div class="form-group m-3">
				<input type="text" name="email" value=""
					placeholder="Enter your Email" class="form-control">
			</div>
			<div class="form-group m-3">
				<input type="password" name="password" value=""
					placeholder="Enter Password" class="form-control">
			</div>
			<div class="form-group m-3">
				<input type="text" name="contact" value=""
					placeholder="Enter Contact" class="form-control">
			</div>
			<div class="form-group m-3">
				<input type="submit" name="submit" value="Sign-Up" class="form-control">
			</div>
		</form>
	</div>

</body>
</html>