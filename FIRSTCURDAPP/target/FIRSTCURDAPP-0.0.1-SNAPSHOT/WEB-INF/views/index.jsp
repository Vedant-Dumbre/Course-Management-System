<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/resources/CSS/style.css" />" />
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
    position: absolute;
    inset: 0;
    background: url("/FIRSTCURDAPP/resources/images/coder.jpg") no-repeat center center;
    background-size: cover;
    filter: blur(3px);
    z-index: -1;
}


</style>

</head>
<body style="background-image: url('/images/course.png'); width: 100vw; height: 100vh">
	<div class="container-fluid bg-dark">
		<!-- container div -->
		<div>
			<!-- side bar div -->
			<button class="btn btn-primary" type="button"
				data-bs-toggle="offcanvas" data-bs-target="#offcanvasScrolling"
				aria-controls="offcanvasScrolling">Menu</button>

			<div class="offcanvas offcanvas-start " data-bs-scroll="true"
				data-bs-backdrop="false" tabindex="-1" id="offcanvasScrolling"
				aria-labelledby="offcanvasScrollingLabel" style="width: 15%">
				<div class="offcanvas-header">
					<h5 class="offcanvas-title" id="offcanvasScrollingLabel">Colored
						with scrolling</h5>
					<button type="button" class="btn-close text-reset"
						data-bs-dismiss="offcanvas" aria-label="Close"></button>
				</div>
				<div class="offcanvas-body">
					<ul>
						<li> Course Master
							<ul>
								<li><a href='addcourse'>Add Course</a></li>
								<li><a href='view'>View Course</a></li>
								<li><a href='viewcd'>View Course Details</a></li>
							</ul>
						</li>
						<li> Subject Master
							<ul>
								<li><a href='addSub'>Add Subject</a></li>
								<li><a href='viewsub'>View Subject</a></li>
							</ul>

						</li>
					</ul>
				</div>
			</div>
		</div>



	</div>
</body>
</html>