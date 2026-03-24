package com.tmf.servlets;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register")


/**
 * Servlet implementation class RegisterServlet
 */

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//response.getWriter().append("Served at: ").append(request.getContextPath());

		response.sendRedirect("login.html");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");		
		PrintWriter out=response.getWriter();
		
		String fname=request.getParameter("firstname");
		String lname=request.getParameter("lastname");
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String dob   = request.getParameter("dob");
		String type  = request.getParameter("userType");
		String gender= request.getParameter("gender");
        String addr  = request.getParameter("address");
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/javaproject",
                "root",
                "root"
            );
            
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
         ps.setString(8, type);
         ps.setString(9, gender);
         ps.setString(10, addr);
         
         int i=ps.executeUpdate();  
         if(i > 0) {
        	 	out.println("Registration successful! Please login.");
        	 	//sleep(1000) Pause for 2 seconds before redirecting
              	response.sendRedirect("login.html");
        	  
        	} else {
        	    out.println("Registration failed. Please try again.");
        	} 
         
        }catch (Exception e) {
        	 e.printStackTrace();
             out.println(" Error: " + e.getMessage());
        	
        }

		
		// TODO Auto-generated method stub

		//doGet(request, response);
	}

}
