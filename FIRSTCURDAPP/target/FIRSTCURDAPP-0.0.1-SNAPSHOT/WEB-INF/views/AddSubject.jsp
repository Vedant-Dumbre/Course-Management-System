<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/CSS/style.css" />" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	function addSubject() {
		let sname = document.getElementById("sname").value;
		alert(typeof sname);
		let select = $('#sel').val().toString();

		//let select=document.getElementById('sel').value.toString();
		alert(select);
		alert(typeof select);
		let pdf=document.getElementById("pdf").value;
		alert(pdf);

	}
</script>
</head>
<body>
	<jsp:include page="index.jsp" />
	<div class="container mt-5 p-3"
		style="width: 400px; background-color: #e0e0e0">
		<form name='frm' action="savesub" method="POST" enctype="multipart/form-data">
			<div class="form-group m-3 ">
				<input type="text" name="sname" value="" id="sname">
			</div>
			<div class="form-group m-3">
				<select multiple id="sel" name="csVal" style="width: 250px;">
					<c:forEach var="cs" items="${course}">
						<option value="${cs.getId()}">${cs.getCname() }</option>
					</c:forEach>
				</select>
			</div>
			 <div class="form-group m-3 ">
				<input type="file" name="pdf" value="" id="pdf">
			</div> 
			<div class="form-group m-3">
				<input type="submit" name="submit" value="Add new Subject"
					class="form-control" style="background-color: gray;"
					onclick="addSubject()">
			</div>
			<span class="text-dark"><h3>${msg }</h3></span>
		</form>
	</div>
</body>
</html>