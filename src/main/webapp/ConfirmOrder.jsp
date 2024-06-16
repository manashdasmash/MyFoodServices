<%@page import="com.jsp.foodapp.entites.Item"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.foodapp.entites.FoodOrder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Details</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
	crossorigin="anonymous" referrerpolicy="no-referrer">
</head>
<%
FoodOrder foodOrder = (FoodOrder) request.getAttribute("foodOrder");
StringBuilder str = new StringBuilder();
for (Item item : foodOrder.getItems()) {
	str.append(item.getName()).append(",");
}
str.deleteCharAt(str.length()-1);
%>
<body>
	<div class="container">
		<h2 class="mb-4 text-center">Order Details</h2>

		<div class="row justify-content-center">
			<div class="col-md-8">
				<div
					class="container d-flex justify-content-center align-items-center">
					<div class="card border-primary" style="width: 700px;">
						<div class="card-body">
							<table class="table table-striped mb-0">
								<tr>
									<th>Name:</th>
									<td><%=foodOrder.getName()%></td>
								</tr>
								<tr>
									<th>Mobile No:</th>
									<td><%=foodOrder.getMoblieNumber()%></td>
								</tr>
								<tr>
									<th>Items:</th>
									<td><%=str.toString()%></td>
								</tr>
								<tr>
									<th>Price:</th>
									<td>Rs <%=foodOrder.getTotalBill()%> /-</td>
								</tr>
							</table>
						</div>
						<div class="card-footer bg-primary text-white text-center">
							<a href="finalSubmit" class="btn btn-lg btn-outline-light">Order
								Now</a>
						</div>
					</div>
				</div>
			</div>
		</div>
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