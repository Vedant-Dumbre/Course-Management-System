<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="index.jsp"></jsp:include>
<div class="container mt-5" style="width: 60%;">
<span><h3 class="text-light fw-bold">${csname.getCname()}</h3></span>
<table class="table table-striped bg-light">

	<tr>
		<th>Sr no</th>
		<th>Subject Name</th>
		<th>Syllabus</th>
	</tr>
	<c:forEach var="cd" items="${coursedetail}">
		<tr>
			<th>${cd.getId()}</th>
			<th>${cd.getSname()}</th>
			<th><a style="text-decoration: none;" href="<c:url value='/PDF/${cd.getPdfPath()}' />" >Download</a></th>

		</tr>

	</c:forEach>

</table>
</div>
</body>
</html>