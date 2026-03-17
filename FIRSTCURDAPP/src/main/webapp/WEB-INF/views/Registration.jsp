<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>\
<script type="text/javascript">
function checkvalue()
{
	let value=document.getElementById("sel").value;
	let val=parseInt(value);
	alert(val);
	alert(typeof val);
	
	}

</script>

</head>
<body >
	<jsp:include page="Dashboard.jsp" />
	<div class="container mt-3 p-3"
		style="width: 400px; background-color: #e0e0e0;">
		<form name='frm' action="register" method="POST">
		
			<div class="form-group m-3">
				<input type="text" name="name" value=""
					placeholder="Enter your name" class="form-control" >
			</div>
			<div class="form-group m-3">
				<input type="text" name="email" value=""
					placeholder="Enter your Email" class="form-control">
			</div>
			 <div class="form-group m-3">
				<input type="text" name="uname" value=""
					placeholder="Enter your username" class="form-control">
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
				<select class="form-control" id="sel" name="rid">
				<option >Select Role</option>
				<option value="1">Teacher</option>
				<option value="2">Student</option>
				</select>
			</div>
			<div class="form-group m-3" >
			Select Courses:
				<select multiple class="form-control" id="select" name="usercourse" style="height:50px">
				<c:forEach var="uc" items="${course}">
				<option value="${uc.getId()}">${uc.getCname()}</option>
				
				</c:forEach>
				
				</select>
			</div>
			<div class="form-group m-3">
				<input type="submit" name="submit" value="Sign-Up" class="form-control" onclick="checkvalue()">
			</div>
			<span>${msg}</span>
		</form>
	</div>

</body>
</html>