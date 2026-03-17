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
/*
body::before {
    content: "";
    position: absolute;
    inset: 0;
    background: url("/FIRSTCURDAPP/resources/images/coder.jpg") no-repeat center center;
    background-size: cover;
    filter: blur(3px);
    z-index: -1;
}
*/

body::before {
		content: "";
		position: fixed;
		inset: 0;
		background: url("/FIRSTCURDAPP/resources/images/Office_image.jpg") no-repeat center/cover;
		filter: blur(2px);
		z-index: -1;
	}
html {
		scroll-behavior: smooth;
	}
section {
		min-height: 100vh;
		display: flex;
		align-items: center;
		justify-content: center;
		text-align: center;
		padding: 60px 20px;
	}
	
	.overlay {
		background: rgba(0,0,0,0.6);
		padding: 40px;
		border-radius: 10px;
	}
	
	/*
	#about {
		background: rgba(0, 0, 0, 0.75);
	}

	#contact {
		background: rgba(0, 0, 0, 0.85);
	}
	*/

</style>
</head>
<body
	style="background-image: url('/images/course.png'); width: 100vw; height: 100vh">

	<div class="container-fluid bg-secondary text-end fixed-top">
	<a class="btn btn-secondary fw-bold text-white"
			style="text-decoration: none;" href="#main">Home</a>
			<a class="btn btn-secondary fw-bold text-white"
			style="text-decoration: none;" href="#about">About us</a>
			<a class="btn btn-secondary fw-bold text-white"
			style="text-decoration: none;" href="#contact">Contact</a>
		<a class="btn btn-primary fw-bold text-white"
			style="text-decoration: none;" href="log">Login</a>

	</div>
	<section id="main">
	<div class="overlay">

		<h1 class="text-center fw-bold display-3 text-light mt-1">Welcome
			To Course Management System</h1>
			<a href="log"
		   class="btn btn-success btn-lg mt-3">
			Get Started
		</a>

	</div>
	</section>
	
	<!-- ===== ABOUT SECTION ===== -->
<section id="about">
	<div class="overlay">
		<h1 class="fw-bold text-light">About Us</h1>
		<p class="mt-3 text-light">
			 The Course Management System (CMS) is a comprehensive web-based platform 
    designed to streamline and automate academic administration processes. 
    <p class="mt-3 text-light">
    It enables educational institutions to efficiently manage courses, students, 
    faculty members, and enrollment records within a centralized system.
    </p>
		</p>
		<p class="mt-3 text-light">
			Our system enhances operational efficiency by reducing manual paperwork, 
    improving data accuracy, and providing real-time access to critical academic 
    information. 
    </p>
    <p class="mt-3 text-light">
    With an intuitive user interface and secure access controls, 
    CMS ensures a seamless experience for administrators, instructors, and students.
		</p>
	</div>
</section>

<!-- ===== CONTACT SECTION ===== -->
<section id="contact">
	<div class="overlay">
		<h1 class="fw-bold text-light">Contact Us</h1>
		<p class="mt-3 text-light">📧 Email: vedantdumbre0503@gmail.com</p>
		<p class="mt-3 text-light">📞 Phone: +91 8805045685</p>
		<p class="mt-3 text-light">📍 Location: Pune, India</p>
	</div>
</section>
	

</body>
</html>