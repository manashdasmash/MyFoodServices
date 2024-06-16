<%@page import="com.jsp.foodapp.entites.Item"%>
<%@page import="com.jsp.foodapp.entites.FoodOrder"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.jsp.foodapp.entites.Product"%>
<%@ page import="java.util.Base64"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Food Orders</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
	crossorigin="anonymous" referrerpolicy="no-referrer"
	isELIgnored="false">
</head>
<%
FoodOrder foodOrder = (FoodOrder) request.getAttribute("showItems");
List<Item> items = foodOrder.getItems();
%>
<body>
	<div id="productTable" class="container mt-4">
		<div class="text-center mb-3">
			<h2 class="text-center text-white bg-primary p-3">
				<%= foodOrder.getName()%>'s Order Details<span><a class="btn btn-success"
					style="float: right;" onclick="goBack()">Back</a> </span>
			</h2>
		</div>

		<div class="table-container">
			<div class="table-responsive">
				<h4 class="text-center text-white bg-secondary p-3">Items</h4>
				<table class="table table-striped table-bordered">
					<thead class="table-dark">
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Type</th>
							<th>Quantity</th>
							<th>Cost</th>
						</tr>
					</thead>
					<tbody>
						<%
						if (items.isEmpty()) {
						%>
						<tr>
							<td colspan="6">
								<h4 class="text-center text-danger">No Item Found.</h4>
							</td>
						</tr>
						<%
						} else {
						for (Item item : items) {
						%>
						<tr
							class="${status.index % 2 == 0 ? 'table-info' : 'table-secondary'}">
							<td><%=item.getId()%></td>
							<td><%=item.getName()%></td>
							<td><%=item.getType()%></td>
							<td><%=item.getQuentity()%></td>
							<td><%=item.getCost()%></td>
						</tr>
						<%
						}
						}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script>
		setTimeout(function() {
			document.getElementById("successAlert").style.display = "none";
		}, 3000);

		function goBack() {
			window.history.back();
		}
	</script>
	<script>
		window
				.addEventListener(
						'pageshow',
						function(event) {
							var historyTraversal = event.persisted
									|| (typeof window.performance != 'undefined' && window.performance.navigation.type === 2);
							if (historyTraversal) {
								document.getElementById("successAlert").innerText = "";
							}
						});
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

</body>
</html>