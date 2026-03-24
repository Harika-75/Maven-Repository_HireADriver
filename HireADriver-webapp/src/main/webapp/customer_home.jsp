<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--  <%@ taglib prefix="hd" uri = "http://hireadriver/tags" %> --%>

<%@ page import="com.tmf.had.dao.Userdao" %>
<%@ page import="com.tmf.had.model.Booking" %>
<%@ page import="java.util.List" %>

<html>
<head>
<meta charset="UTF-8">
<title>User Home</title>

<style>
body {
	font-family: Arial, sans-serif;
	background: #f4f6f9;
	margin: 0;
}

/* HEADER */
.header {
	background: #34495e;
	color: white;
	padding: 18px 25px;
	position: relative;
}

.header h2 {
	margin: 0;
}

/* HAMBURGER */
#menu-toggle {
	display: none;
}

.menu-icon {
	position: absolute;
	right: 25px;
	top: 18px;
	font-size: 28px;
	cursor: pointer;
	color: white;
}

/* SIDEBAR */
.sidebar {
	position: fixed;
	top: 0;
	right: -1000px;
	width: 280px;
	height: 100%;
	background: white;
	box-shadow: -3px 0 10px rgba(0, 0, 0, 0.2);
	transition: 0.3s;
	padding: 25px;
}

#menu-toggle:checked ~ .sidebar {
	right: 0;
}

.close-btn {
	font-size: 22px;
	cursor: pointer;
	float: right;
}

/* PROFILE */
.profile-header {
	text-align: center;
	margin-top: 20px;
}

.avatar {
	width: 80px;
	height: 80px;
	border-radius: 50%;
	background: #ddd;
	margin: auto;
}

.profile-header h3 {
	margin-top: 10px;
}

.profile-info {
	margin-top: 25px;
}

.profile-info p {
	margin: 10px 0;
	border-bottom: 1px solid #eee;
	padding-bottom: 8px;
}

/* LOGOUT */
.logout-btn {
	width: 100%;
	padding: 10px;
	background: #e74c3c;
	color: white;
	border: none;
	border-radius: 6px;
	cursor: pointer;
	margin-top: 20px;
}

/* MAIN */
.container {
	display: flex;
	flex-direction: column;
	align-items: center;
	padding: 40px;
}

/* BOOK TRIP */
.booking-form {
	background: white;
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
	width: 450px;
	margin-bottom: 40px;
}

.booking-form h3 {
	text-align: center;
	margin-bottom: 20px;
}

.form-row {
	display: flex;
	gap: 15px;
}

.booking-form input, .booking-form select {
	width: 100%;
	padding: 10px;
	margin: 8px 0;
	border: 1px solid #ccc;
	border-radius: 6px;
}

.book-btn {
	width: 100%;
	padding: 12px;
	background: #27ae60;
	color: white;
	border: none;
	border-radius: 6px;
	cursor: pointer;
	margin-top: 10px;
	font-size: 15px;
}

/* BOOKINGS */
.bookings {
	width: 80%;
	background: white;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 15px;
}

th {
	background: #34495e;
	color: white;
	padding: 12px;
}

td {
	padding: 12px;
	border-bottom: 1px solid #ddd;
}

.status {
	padding: 5px 12px;
	border-radius: 20px;
	font-size: 12px;
	font-weight: bold;
	color: white;
}

.completed {
	background: #2ecc71;
}

.pending {
	background: #f39c12;
}
</style>
</head>

<body>

	<input type="checkbox" id="menu-toggle">

	<!-- HEADER -->

	<div class="header">

		<h2>Welcome, Harika</h2>

		<label for="menu-toggle" class="menu-icon">☰</label>

	</div>

	<!-- SIDEBAR -->

	<div class="sidebar">

		<label for="menu-toggle" class="close-btn">✖</label>

		<div class="profile-header">

			<div class="avatar"></div>

			<h3>Harika</h3>

		</div>

		<div class="profile-info">

			<p>
				<strong>Email:</strong> harika@gmail.com
			</p>
			<p>
				<strong>Phone:</strong> 9876543210
			</p>
			<p>
				<strong>City:</strong> Hyderabad
			</p>

		</div>

		<form action="LogoutServlet" method="post">
			<button class="logout-btn">Logout</button>
		</form>

	</div>

	<!-- MAIN -->

	<div class="container">

		<div class="booking-form">

			<h3>Book a New Trip</h3>

			<form action="BookTripServlet" method="post">

				<div class="form-row">
					<input type="text" name="source" placeholder="Source" required>
					<input type="text" name="destination" placeholder="Destination"
						required>
				</div>

				<div class="form-row">
					<input type="number" name="price" placeholder="Price" required>
					<input type="datetime-local" name="time" required>
				</div>

				<!--  <select name="driver">
<option>Select Driver</option>
<option>Ramesh</option>
<option>Suresh</option>
<option>Mahesh</option>
</select>-->

				<button class="book-btn">Book Trip</button>

			</form>

		</div>
		<% 
				Userdao dao=new Userdao();
				List<Booking> bookingsList=dao.getBookingsListByUserId(1); // Assuming user ID is 1
				System.out.println("Bookings List: " + bookingsList.size()); // Debugging statement
				Booking b = bookingsList.get(0); // Get the first booking for debugging
				String s= b.toString(); // Convert the booking to a string for debugging
				System.out.println("First Booking: " + s); // Debugging statement
				pageContext.setAttribute("bookingsList", bookingsList);
				%> 

		<div class="bookings">

			<h3>Previous Bookings</h3>
			<hd:bookingTable bookings="${bookingsList }" />
			<table>

				<!--  tr>
					<th>Booking ID</th>
					<th>Customer ID</th>
					<th>Trip ID</th>
					<th>DATE</th>
					<th>Status</th>
				</tr>-->
				
				<%-- using jstl tags
				
				<c:out value="${s}" /><!-- Debugging statement -->
				
				<c:forEach items="${bookingsList}" var="b">
					
					<tr>
					<td><c:out value="${b.bookingId}" /></td>
					<td><c:out value="${b.customerId}"/></td>
					<td><c:out value="${b.tripId}"/></td>

					<td><c:out value="${b.bookingdate}"/></td>
					<td><c:out value="${b.status}"/></td>

				</tr>
				</c:forEach>
				--%>
				<%--
				using base jsp scriplet tags  
				<%
				for(int i=0;i<bookingsList.size();i++){
			%>
				<tr>
					<td><%=bookingsList.get(i).getBookingId() %></td>
					<td><%=bookingsList.get(i).getCustomerId() %></td>
					<td><%=bookingsList.get(i).getTripId() %></td>

					<td><%=bookingsList.get(i).getBookingdate() %></td>
					<td><%=bookingsList.get(i).getStatus() %></td>

				</tr>
				<%
				}
			%>
			

				<%-- <c:bookingTable bookings="${bookingsList }" />  --%>



				<!--  <tr>
<td>101</td>
<td>2026-03-01</td>
<td>Ramesh</td>
<td>Hyderabad → Bangalore</td>
<td><span class="status completed">COMPLETED</span></td>
</tr>

<tr>
<td>102</td>
<td>2026-03-05</td>
<td>Suresh</td>
<td>Chennai → Hyderabad</td>
<td><span class="status pending">PENDING</span></td>
</tr> -->

			</table>

		</div>

	</div>

</body>
</html>