<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/CSS/style.css" />" rel="stylesheet" />
<script type="text/javascript" src= "<c:url value="/resources/JS/AJAX.js" />"></script>
</head>
<body>
	<jsp:include page="index.jsp" />
	
	<div class="container mt-5 p-2">
		<div class="form-group m-3">

			<input type="text" name="name" value="" class="form-control"
				onkeyup="SearchCourse(this.value)">
		</div>
	</div>
	<table class="table table-striped bg-light">
		<tr>
			<th>Sr no</th>
			<th>Course name</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<tbody id="tbody">
		<c:forEach var="cs" items="${course}">
			<tr>
				<th>${cs.getId() }</th>
				<th>${cs.getCname() }</th>
				<th><a href='updt?upd=${cs.getId() }'>Update</a></th>
				<th><a href='delete?del=${cs.getId() }'>Delete</a></th>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<span><h4>${msg }</h2></span>
</body>
</html>