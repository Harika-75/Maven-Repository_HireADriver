package com.tmf.servlets;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.tmf.entity.User;

/**
 * Servlet implementation class AdminDashboardServlet
 */
@WebServlet("/AdminDashboardServlet")
public class AdminDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		
		 if (session == null) {
		        response.sendRedirect("login.html");
		        return;
		    }
		User admin = (User)session.getAttribute("loggedinUser");
		 
		 if (session == null || session.getAttribute("loggedinUser") == null) {
		        response.sendRedirect("login.html");
		        return;
		    }
		
		
		

		System.out.println(request.getParameter("user_name"));
		System.out.println(request.getParameter("password"));
		// TODO Auto-generated method stub
		response.getWriter().append("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Admin Dashboard Page</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<h1>Welcome to Admin Dashboard </h1>\r\n"
				+ admin.getUserName() + "<br/>"
				+ admin.getEmail() + "<br/>"
				+ " <form action=\"LogoutServlet\" method=\"post\">\r\n"
				+ "	<input type=\"submit\" value=\"Logout\"/>\r\n"
				+ "	</form>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
