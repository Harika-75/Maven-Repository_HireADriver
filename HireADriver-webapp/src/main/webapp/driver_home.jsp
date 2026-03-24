<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Driver Home Page</title>

<style>
body {
	font-family: Arial, sans-serif;
	background: #f4f6f9;
	margin: 0;
	padding: 40px;
}

.header {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 30px;
}

.container {
	display: flex;
	gap: 40px;
}

.profile {
	width: 30%;
	background: white;
	padding: 25px;
	border-radius: 10px;
	box-shadow: 0 0 12px rgba(0, 0, 0, 0.08);
}

.earnings {
	width: 70%;
	background: white;
	padding: 25px;
	border-radius: 10px;
	box-shadow: 0 0 12px rgba(0, 0, 0, 0.08);
}

.profile p {
	margin: 10px 0;
}

.update-section {
	margin-top: 25px;
	padding-top: 15px;
	border-top: 1px solid #ddd;
}

.update-section input {
	margin-top: 8px;
	margin-bottom: 12px;
}

.upload-btn {
	padding: 8px 15px;
	background: #3498db;
	color: white;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.logout-btn {
	padding: 8px 18px;
	background: #e74c3c;
	color: white;
	border: none;
	border-radius: 6px;
	cursor: pointer;
	font-weight: bold;
}

.logout-btn:hover {
	background: #c0392b;
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
	text-align: left;
}

td {
	padding: 12px;
	border-bottom: 1px solid #ddd;
}

tr:hover {
	background: #f2f2f2;
}

.status {
	padding: 6px 14px;
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

	<div class="header">
		<h1>Welcome Driver, Ramesh</h1>
		 <form action="LogoutServlet" method="post">
    <button type="submit" class="logout-btn">Logout</button>
</form>
	</div>

	<div class="container">

		<div class="profile">

			<h3>Driver Profile</h3>

			<p>
				<strong>Name:</strong> Ramesh Kumar
			</p>
			<p>
				<strong>Email:</strong> ramesh@gmail.com
			</p>
			<p>
				<strong>Phone:</strong> 9876543210
			</p>
			<p>
				<strong>City:</strong> Hyderabad
			</p>

			<div class="update-section">

				<h3>Update Profile</h3>

				<label>Upload Recent Photo</label><br> <input type="file"><br>

				<label>Upload Driving Licence</label><br> <input type="file"><br>

				<button class="upload-btn">Update Profile</button>

			</div>

		</div>

		<div class="earnings">

			<h3>Track Your Earnings</h3>

			<table>

				<tr>
					<th>Trip ID</th>
					<th>Date</th>
					<th>Route</th>
					<th>Fare</th>
					<th>Status</th>
				</tr>

				<tr>
					<td>201</td>
					<td>2026-03-02</td>
					<td>Hyderabad → Bangalore</td>
					<td>₹3500</td>
					<td><span class="status completed">PAID</span></td>
				</tr>

				<tr>
					<td>202</td>
					<td>2026-03-05</td>
					<td>Chennai → Hyderabad</td>
					<td>₹4200</td>
					<td><span class="status completed">PAID</span></td>
				</tr>

				<tr>
					<td>203</td>
					<td>2026-03-08</td>
					<td>Visakhapatnam → Vijayawada</td>
					<td>₹2800</td>
					<td><span class="status pending">PENDING</span></td>
				</tr>

			</table>

		</div>

	</div>

</body>
</html>
