package com.tmf.had.model;

import java.util.Date;

public class Booking {
	private int bookingId;
	private int customerId;
	private int tripId;
//	private String pickupLocation;
//	private String dropLocation;
	private String status;
//	private double price;
//	private Date bookingdate;
	private String bookingdate;
	
	public String getBookingdate() {
		return bookingdate;
	}
	public void setBookingdate(String bookingdate) {
		this.bookingdate = bookingdate;
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBookingId() {
		return bookingId;
	}
	
	
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
//	public Date getBookingdate() {
//		return bookingdate;
//	}
//	public void setBookingdate(Date bookingdate) {
//		this.bookingdate = bookingdate;
//	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", customerId=" + customerId + ", tripId=" + tripId + ", status="
				+ status + ", bookingdate=" + bookingdate + "]";
	}
	
	
}

	