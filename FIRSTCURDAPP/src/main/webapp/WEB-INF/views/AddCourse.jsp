<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/CSS/style.css" />" rel="stylesheet" />
</head>
<body>
	<jsp:include page="index.jsp" />
	<div class="container mt-5 bg-light p-3" style="width: 400px;">
		<form name="frm" action="save" method="POST">
			<div class="form-group m-3">
				<input type="text" name="cname" value=""
					placeholder="Enter Courese name" class="form-control">
			</div>
			<div class="form-group m-3">
				<input type="submit" name="submit" value="Add new Course"
					class="form-control" style="background-color: gray;">
			</div>
			<span class="text-light"><h3>${msg }</h3></span>
		</form>
	</div>
	
</body>
</html>