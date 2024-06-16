<%@page import="com.jsp.foodapp.entites.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Panel</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
	crossorigin="anonymous" referrerpolicy="no-referrer">
<!-- Custom Styles -->
<style>
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	transition: background-color 0.5s;
	background-color: #dfd8d9;
}

body.dark-mode {
	background-color: #333;
	color: #fff;
}

h1 {
	text-align: center;
	color: #007bff;
	margin-bottom: 30px;
}

.container {
	text-align: center;
}

.btn-admin {
	font-size: 18px;
	margin: 10px;
	border-radius: 10px;
	padding: 10px 20px;
	transition: transform 0.2s ease-in-out;
}

.btn-create-account {
	background-color: #28a745;
	border-color: #28a745;
	color: #fff;
}

.btn-add-product {
	background-color: #ffc107;
	border-color: #ffc107;
	color: #333;
}

.btn-view-all-orders {
	background-color: #007bff;
	border-color: #007bff;
	color: #fff;
}

.btn-view-all-products {
	background-color: #6610f2;
	border-color: #6610f2;
	color: #fff;
}

.btn-view-by-id {
	background-color: #dc3545;
	border-color: #dc3545;
	color: #fff;
}

.btn-admin:hover {
	transform: scale(1.05);
}

.btn-view-all-products {
	background-color: #6610f2;
	border-color: #6610f2;
	color: #fff;
}

.btn-view-all-products:hover {
	background-color: #6610f2;
	border-color: #6610f2;
	color: #fff;
}

#toggleBtn {
	background-color: transparent;
	border: none;
}

#toggleBtn i {
	color: #fff;
	margin: 4px;
	font-size: 21px;
}
</style>
</head>
<%-- <%
response.setHeader("Pragma", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Expires", "0");
response.setDateHeader("Expires", -1);
%> --%>
<%
Admin admin = (Admin) session.getAttribute("admin");
if (admin != null) {
	String userName = admin.getName();
%>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Food-App</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index.jsp">Home</a></li>
				</ul>
				<!-- Admin Profile -->
				<div class="d-flex align-items-center" style="margin-right: 20px">
					<!-- Toggle button for light/dark mode -->
					<a id="toggleBtn" class="btn btn-secondary"> <i
						class="fas fa-sun"></i> <!-- Moon icon --> <i class="fas fa-moon"
						style="display: none;"></i> <!-- Sun icon -->
					</a> <a href="#" data-bs-toggle="modal"
						data-bs-target="#adminProfileModal"
						class="text-decoration-none text-light d-flex align-items-center me-3">
						<!-- Example user icon from FontAwesome --> <i
						class="fas fa-user-circle fa-lg me-2"></i><%=userName%><span
						class="d-none d-md-inline"> </span>
					</a>

					<!-- Modern "Log Out" link -->
					<a href="adminLogout" class="text-decoration-none text-light">
						<i class="fas fa-sign-out-alt fa-lg me-1 "></i> Log Out
					</a>
				</div>
			</div>
		</div>
	</nav>

	<div class="container mt-2">
		<div id="successLoginAlert">${message}</div>
		<div id="successAlert">${saveProductMessage}</div>
		<h1>Welcome to Admin Panel</h1>
		<p>Manage your system with ease.</p>

		<a href="addProduct" class="btn btn-warning btn-admin btn-add-product">Add
			Product</a> 
		<!-- <a href="viewProductById"
			class="btn btn-danger btn-admin btn-view-by-id">View Product by
			ID</a> -->
		<a href="allProduct"
			class="btn btn-purple btn-admin btn-view-all-products">View All
			Products</a> <a href="viewAllFoodOrders"
			class="btn btn-primary btn-admin btn-view-all-orders">View All
			Food Orders</a>
	</div>
	<div class="container table-container">

		<%-- <%@ include file="AllProduct.jsp"%>
 --%>
	</div>

	<!-- Bootstrap JS and dependencies -->
	<script>
		// JavaScript code to hide the alert after 3000 milliseconds (3 seconds)
		setTimeout(function() {
			document.getElementById("successAlert").style.display = "none";
		}, 3000);
		setTimeout(
				function() {
					document.getElementById("successLoginAlert").style.display = "none";
				}, 3000);
	</script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
		integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
		crossorigin="anonymous"></script>

	<script>
		$(document).ready(function() {
			// Set the initial mode to light
			$('body').removeClass('dark-mode');
			$('#toggleBtn i.fa-sun').show();
			$('#toggleBtn i.fa-moon').hide();

			// Toggle mode when the button is clicked
			$('#toggleBtn').on('click', function() {
				$('body').toggleClass('dark-mode');

				// Toggle the icons
				$('#toggleBtn i.fa-moon').toggle();
				$('#toggleBtn i.fa-sun').toggle();
			});
		});
	</script>
	<%
	} else {
	%>
	<h2 style="color: red; text-align: center; margin-top: 40px;">
		Admin not found....<br>
	</h2>
	<div class="text-center">
		<a href="index.jsp">GoTo Home Page</a>
	</div>
	<%
	}
	%>
</body>
</html>