<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="index.jsp" />
	<div class="container mt-5 bg-dark p-3" style="width: 400px;">
		<form name="frm" action="update" method="POST">
			<div class="form-group m-3">

				<input type="text" name="ucid" value="${cs.getId() }"
					class="form-control" readonly>
			</div>

			<div class="form-group m-3">

				<input type="text" name="ucname" value="${cs.getCname() }"
					class="form-control">
			</div>
			<div class="form-group m-3">
				<input type="submit" name="submit" value="Update"
					class="form-control" style="background-color: gray;">
			</div>

		</form>
	</div>
	<span><h2>${msg }</h2></span>
</body>
</html>