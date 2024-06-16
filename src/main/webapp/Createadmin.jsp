 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Registration</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<style>
.container {
	margin-top: 50px;
	max-width: 600px; /* Set the maximum width of the container */
	background-color: powderblue;
	padding: 12px;
	border-radius: 12px;
}
body{

background: linear-gradient(45deg, blue, #979751, #fdf7ed);
height: 100vh;

}
</style>
</head>
<body>
	<div class="container my-5">
		<h1 class="text-center">Admin Registration</h1>
		<form:form action="saveAdmin" method="post" modelAttribute="admin">

			<div class="mb-3">
				<label for="name" class="form-label">Name:</label>
				<form:input class="form-control" placeholder="Enter your name" path="name" />
			</div>

			<div class="mb-3">
				<label for="email" class="form-label">Email:</label>
				<form:input class="form-control" placeholder="Enter your Email" path="email" />
			</div>

			<div class="mb-3">
				<label for="password" class="form-label">Password:</label>
				<form:input class="form-control" type="password" placeholder="Enter Password" path="password" />
			</div>

			<div class="btn-center text-center">
				<button type="submit" class="btn btn-primary">Register</button>
			</div>
		</form:form>
	</div>
	<!-- Bootstrap JS and dependencies -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
		integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
		crossorigin="anonymous"></script>


</body>
</html> 