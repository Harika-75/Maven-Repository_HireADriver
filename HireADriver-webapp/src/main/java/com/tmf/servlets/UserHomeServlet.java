package com.tmf.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tmf.entity.User;

		    /**
		     * Servlet implementation class UserHomeServlet
		     */
@WebServlet("/UserHomeServlet")
public class UserHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		           
		        /**
		         * @see HttpServlet#HttpServlet()
		         */
		        public UserHomeServlet() {
		            super();
		            // TODO Auto-generated constructor stub
		        }

		    	/**
		    	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		    	 */
		    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    		HttpSession session = request.getSession(false);
		     

		    		 if (session == null || session.getAttribute("user") == null) {
		    		     response.sendRedirect("login.html");
		    		     return;
		    		 }

		    		 User user = (User) session.getAttribute("user");
		    		 response.setContentType("text/html");
		    		    PrintWriter out = response.getWriter();
		    		    
		    		    out.println("""
		    		    		<!DOCTYPE html>
		    		    		<html>
		    		    		<head>
		    		    		<meta charset="UTF-8">
		    		    		<title>User Home Page</title>
		    		    		<style>
		    		    		 table {
								    width: 100%;
								    border-collapse: collapse;
								    margin-top: 15px;
								}

								th {
								    background-color: #34495e;
								    color: white;
								    padding: 12px;
								    text-align: left;
								}

								td {
								    padding: 12px;
								    border-bottom: 1px solid #ddd;
								}

								tr:hover {
								    background-color: #f2f2f2;
								}

								.status {
								    padding: 5px 12px;
								    border-radius: 20px;
								    font-size: 12px;
								    font-weight: bold;
								}

								.completed {
								    background: #2ecc71;
								    color: white;
								}

								.pending {
								    background: #f39c12;
								    color: white;
								}

								.cancelled {
								    background: #e74c3c;
								    color: white;
								}
							    </style>
								</head>
								<body>
								<div class="header">
								""");

		    		    		// ✅ dynamic content OUTSIDE text block
		    		    		out.println("<h1>Welcome, " + user.getUserName() + "</h1>");

		    		    		out.println("""
		    		    		<form action="LogoutServlet" method="post">
		    		    		    <input type="submit" value="Logout"/>
		    		    		</form>
		    		    		</div>

		    		    		<div class="container">
		    		    		<div class="profile">
		    		    		<h3>User Profile</h3>
		    		    		""");

		    		    		out.println("<p><strong>Name:</strong> " + user.getUserName() + "</p>");
		    		    		out.println("<p><strong>Email:</strong> " + user.getEmail() + "</p>");
		    		    		out.println("<p><strong>Phone:</strong> " + user.getPhone() + "</p>");
		    		    		out.println("<p><strong>City:</strong> " + user.getCity() + "</p>");

		    		    		out.println("""
		    		    		</div>
		    		    		<div class="bookings">
		    		    		<h3>Previous Bookings</h3>
		    		    		<table>
		    		    		<tr>
		    		    		<th>ID</th><th>Date</th><th>Driver</th><th>Route</th><th>Status</th>
		    		    		</tr>
		    		    		""");

		    		// TODO Auto-generated method stub
		    		
		    		try {
		    		    Connection con = DriverManager.getConnection(
		    		        "jdbc:mysql://localhost:3306/javaproject",
		    		        "root",
		    		        "root"
		    		    );

		    		    PreparedStatement ps = con.prepareStatement(
		    		    	    "SELECT * FROM bookings WHERE id = ?"
		    		    	);
		    		    	ps.setInt(1, user.getId());

		    		    	ResultSet rs = ps.executeQuery();
		    		        boolean hasBookings = false;

		    		    	while (rs.next()) {
		    		    		hasBookings = true;
		    		    	    String status = rs.getString("status");
		    		    	    String cssClass = status.equalsIgnoreCase("COMPLETED")
		    		    	            ? "completed"
		    		    	            : "cancelled";

		    		    	    out.println("<tr>");
		    		    	    out.println("<td>" + rs.getInt("booking_id") + "</td>");
		    		    	    out.println("<td>" + rs.getDate("booking_date") + "</td>");
		    		    	    out.println("<td>Assigned Driver</td>"); // driver table not yet linked
		    		    	    out.println("<td>" + rs.getString("source") + " → "
		    		    	                       + rs.getString("destination") + "</td>");
		    		    	    out.println("<td><span class='status " + cssClass + "'>"
		    		    	                       + status + "</span></td>");
		    		    	    out.println("</tr>");
		    	}
		    		    	if (!hasBookings) {
		    	                out.println("""
		    	                <tr>
		    	                    <td colspan="5" style="text-align:center;">No bookings found
		    	                    </td>
		    	                </tr>
		    	                """);
		    	            }

		    	        } catch (Exception e) {
		    	            e.printStackTrace();
		    	            out.println("<tr><td colspan='5'>Error loading bookings</td></tr>");
		    	        }

		    	        
		    	        out.println("""
		    	        </table>
		    	        </div>
		    	        </div>
		    	        </body>
		    	        </html>
		    	        """);
		    	    }

		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
