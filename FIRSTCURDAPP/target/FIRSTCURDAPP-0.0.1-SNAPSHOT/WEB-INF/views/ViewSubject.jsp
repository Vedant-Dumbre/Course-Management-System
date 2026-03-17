<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src= "<c:url value="/resources/JS/AJAX.js" />"></script>
</head>
<body>
	<jsp:include page="index.jsp"></jsp:include>
<div class="container mt-5 p-2">
		<div class="form-group m-3">

			<input type="text" name="name" value="" class="form-control"
				>
		</div>
	</div>
<table class="table table-striped bg-light">
	<tr>
		<th>Sr no</th>
		<th>Subject Name</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="sub" items="${subject}">
		<tr>
			<th>${sub.getId()}</th>
			<th>${sub.getSname()}</th>
			<th><a href="">Update</a></th>
			<th><a href="deletesub?delsub=${sub.getId() }">Delete</a></th>

		</tr>

	</c:forEach>

</table>
</body>
</html>