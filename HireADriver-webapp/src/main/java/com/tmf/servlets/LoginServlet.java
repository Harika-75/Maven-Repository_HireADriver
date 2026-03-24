package com.tmf.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tmf.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		  response.sendRedirect("login.html");

		
		/*Cookie ck[] =request.getCookies();
		String userName = null;
		if (ck != null) {
	       for (Cookie c : ck) {
	           if ("uname".equals(c.getName())) {
	                userName = c.getValue();
	                break;
	            }
	        }
	    }
		User user = new User(userName, "Client", "", "");
		request.setAttribute("loggedinUser", user);
		RequestDispatcher rd=request.getRequestDispatcher("UserHomeServlet");
		rd.forward(request, response);*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("user_name");
		String password = request.getParameter("password");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");

	             con = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/javaproject",
	                "root",
	                "root"
	            );
	            
	            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
	            ps = con.prepareStatement(sql);
	            ps.setString(1, username);
	            ps.setString(2, password);

	             rs = ps.executeQuery();
	            
	            if (rs.next()) {
	            
	            System.out.println("Login successful");
	            User user = new User();
	            user.setId(rs.getInt("id"));
	            user.setFirstname(rs.getString("firstname"));
	            user.setLastname(rs.getString("lastname"));
	            user.setUserName(rs.getString("username"));
	            user.setPhone(rs.getString("phone_number"));
	            user.setEmail(rs.getString("email"));
	            user.setDob(rs.getString("dob"));
	            user.setRole(rs.getString("role"));
	            user.setGender(rs.getString("gender"));
	            user.setCity(rs.getString("address"));
	            
	            HttpSession session = request.getSession();
                session.setAttribute("user", user);
	                
		
		/*Cookie ck=new Cookie("uname",uname);//creating cookie object 
		ck.setPath("/");  
		response.addCookie(ck);
		
		HttpSession session = request.getSession();
		session.setAttribute("uname", uname);*/
		
		
		//if(username!=null && password!=null &&!username.isEmpty()&&!password.isEmpty()&&username.equals("admin")&&password.equals("admin")) {
		//	System.out.println("Admin Login successful");
			/*RequestDispatcher rd=request.getRequestDispatcher("AdminDashboardServlet");  
			User adminUser = new User("ADMIN", "Administrator", "9818253870", "admin@gmail.com");
			
			session.setAttribute("loggedinUser", adminUser);
			response.sendRedirect("AdminDashboardServlet");
			
			
	        rd.forward(request, response);
		}*/
			if ("CUSTOMER".equalsIgnoreCase(user.getRole())) {
		        response.sendRedirect("customer_home.jsp");
		        return;
		    } else if ("DRIVER".equalsIgnoreCase(user.getRole())) {
		        response.sendRedirect("driver_home.jsp");
		        return;
		    } 
	                else {
	                    response.sendRedirect("login.jsp");
	                    return;
	                }

	            }
				
			/*	User user = new User(uname, "Client", "9121375506", uname+"@gmail.com");
				session.setAttribute("loggedinUser", user);
				response.sendRedirect("UserHomeServlet");
				RequestDispatcher rd=request.getRequestDispatcher("UserHomeServlet");  
		        rd.forward(request, response); */
	  else {
				System.out.println("Login failed");
				response.sendRedirect("login.jsp");
			}
		
		//doGet(request, response);
		 }
		 catch (Exception e) {
	            e.printStackTrace();
	            response.getWriter().println("Login Error: " + e.getMessage());
	        }
		 finally {
			    try {
			        if (rs != null) rs.close();
			        if (ps != null) ps.close();
			        if (con != null) con.close();
			    } catch (Exception e) {
			        e.printStackTrace();
			    }
			}

  }
}
