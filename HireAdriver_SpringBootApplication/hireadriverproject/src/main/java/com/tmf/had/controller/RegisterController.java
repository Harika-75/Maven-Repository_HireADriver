package com.tmf.had.controller;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public String register() {
		System.out.println("RegisterController.register()");
//		response.setContentType("text/html");		
//		PrintWriter out=response.getWriter();
		
		String fname="HARIKA";
		String lname="RAVURI";
		String uname="harika";
		String pass="harika";
		String phone="1234567890";
		String email="harika@gmail.com";
		String dob   ="2004-05-07";
		String type  = "customer";
		String gender= "female";
        String addr  = "vijayawada";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/javaproject",
                "root",
                "root"
            );
            
         String sql = "INSERT INTO users " +
                    "(firstname, lastname, username, password, phone_number, email, dob, role, gender, address) " +
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
        	 	System.out.println("Registration successful! Please login.");
        	 	//sleep(1000) Pause for 2 seconds before redirecting
//              	response.sendRedirect("login.html");
        	  
        	} else {
        	   System. out.println("Registration failed. Please try again.");
        	} 
         
        }catch (Exception e) {
        	 e.printStackTrace();
             System.out.println(" Error: " + e.getMessage());
        	
        }
		return null;
	}
}
