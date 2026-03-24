package com.tmf.had.model;

import java.util.List;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

public class BookingTableTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Booking> bookings;

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();

			out.println("<table border='1'>");
			out.println("<tr>");
			out.println("<th>Booking ID</th>");
			out.println("<th>Customer ID</th>");
			out.println("<th>Trip ID</th>");
			out.println("<th>DATE</th>");
			out.println("<th>Status</th>");
			out.println("</tr>");
			if (bookings != null) {
				for (Booking b : bookings) {
					out.println("<tr>");
					out.println("<td>" + b.getBookingId() + "</td>");
//					out.println("<td>" + b.getPickupLocation() + "</td>");
//					out.println("<td>" + b.getDropLocation() + "</td>");
					out.println("<td>" + b.getCustomerId() + "</td>");
					out.println("<td>" + b.getTripId() + "</td>");
					out.println("<td>" + b.getBookingdate() + "</td>");
					out.println("<td>" + b.getStatus() + "</td>");
//					out.println("<td>" + b.getPrice() + "</td>");
					out.println("</tr>");
				}
			}
			out.println("</table>");
		} catch (Exception e) {
			throw new JspException(e);
		}

		return SKIP_BODY;
	}

}
