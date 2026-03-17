<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<style>
body {
    margin: 0;
    height: 100vh;
    position: relative;
}

body::before {
    content: "";
    position: fixed;
    inset: 0;
    background: url("/FIRSTCURDAPP/resources/images/coder.jpg") no-repeat center/cover;
    background-size: cover;
    filter: blur(3px);
    z-index: -1;
}


</style>
</head>
<body
	style="background-image: url('/images/course.png'); width: 100vw; height: 100vh">

	<div class="container-fluid bg-secondary text-end">
	<a class="btn btn-secondary fw-bold text-white"
			style="text-decoration: none;" href="dashboard">Home</a>
			<a class="btn btn-secondary fw-bold text-white"
			style="text-decoration: none;" href="">About us</a>
			<a class="btn btn-secondary fw-bold text-white"
			style="text-decoration: none;" href="">Contact</a>
		<a class="btn btn-primary fw-bold text-white"
			style="text-decoration: none;" href="log">Login</a>

	</div>
	<div>

		<h1 class="text-center fw-bold display-3 text-light mt-1">Welcome
			To Course Management System</h1>

	</div>

</body>
</html>