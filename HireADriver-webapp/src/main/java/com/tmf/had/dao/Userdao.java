package com.tmf.had.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.tmf.had.model.Booking;
import com.tmf.had.util.DBConnection;

public class Userdao {
	public boolean registerUser(String fname,String lname,String uname,String pass, String phone, String email, LocalDate dob , String role, String gender,String addr) {
		try {
			Connection con = DBConnection.getConnection();
			 String sql = "INSERT INTO users " +
	                    "(firstname, lastname, username, password, phone_number, email, dob, user_type, gender, address) " +
	                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	         
	         PreparedStatement ps=con.prepareStatement(sql);
	         ps.setString(1, fname);
	         ps.setString(2, lname);
	         ps.setString(3, uname);
	         ps.setString(4, pass);
	         ps.setString(5, phone);
	         ps.setString(6, email);
	         ps.setDate(7, Date.valueOf(dob));
	         ps.setString(8, role);
	         ps.setString(9, gender);
	         ps.setString(10, addr);

	         int rows=ps.executeUpdate(); 
			return rows > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String loginUser(String email, String password) {
		try {
			Connection conn = DBConnection.getConnection();
			String sql = "SELECT role FROM users WHERE email=? AND password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getString("role");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
//	public List<Booking> getBookingsListByUserId(int userId) {
//		StringBuilder bookingsList = new StringBuilder();
//		try {
//			Connection conn = DBConnection.getConnection();
//			String sql = "SELECT b.id, b.booking_date, b.status, d.firstname AS driver_name " +
//					"FROM bookings b " +
//					"JOIN users d ON b.driver_id = d.id " +
//					"WHERE b.user_id = ?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, userId);
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
////				bookingsList.append("Booking ID: ").append(rs.getInt("id"))
////						.append(", Date: ").append(rs.getDate("booking_date"))
////						.append(", Status: ").append(rs.getString("status"))
////						.append(", Driver: ").append(rs.getString("driver_name"))
////						.append("\n");
//			
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return B
//	}

	
	public List<Booking> getBookingsListByUserId(int userId) {
		List<Booking> bookingsList = new ArrayList<>();
		try {
			Connection conn = DBConnection.getConnection();
			String sql= "select * from bookings";
//			String sql = "SELECT b.id, b.status, " +
//					"FROM bookings b " +;
//					"JOIN users d ON b.driver_id = d.id " +
//					"WHERE b.user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Booking booking = new Booking();
				booking.setBookingId(rs.getInt("booking_id")); 
				booking.setCustomerId(rs.getInt("customer_id"));
				booking.setTripId(rs.getInt("trip_id"));
				
				booking.setBookingdate(rs.getString("booking_date"));
				booking.setStatus(rs.getString("booking_status"));
//				booking.setDriverName(rs.getString("driver_name"));
				
				bookingsList.add(booking);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookingsList;
	}
}
