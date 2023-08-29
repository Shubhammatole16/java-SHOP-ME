package com.newproject.servlets;

import com.newproject.dao.*;
import com.newproject.entity.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;



@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		
		
		// Retrieve user input from the login form 
		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");
		
		
		
		
		// Created an instance of the userDAO
		UserDAO userDAO = new UserDAO();
		
		
		

		try {
			// get the user from the SHOPUSER TABLE
			User user = userDAO.getUserByEmailAndPassword(userEmail, userPassword);
			
			
			
	
			
			if(user != null) {
				// Successful login
				int userId  = user.getuserId();
	
				String userName = user.getuserFname();
				String userType = user.getuserType();
				session.setAttribute("userId", userId);
				session.setAttribute("userName", userName);
				session.setAttribute("userType", userType);
				
				
				
				
				// If user is admin then redirect to admin page
				if("admin".equals(userType)){
					session.setAttribute("statusMsgreg", "loginSuccess");
					response.sendRedirect("admin.jsp");
				}
				
				
				
				// If user is normal then redirect to index page
				else if("normal".equals(userType)) {
					session.setAttribute("statusMsgreg", "loginSuccess");
					response.sendRedirect("index.jsp");
				}
			}
			
			
			
			else {
				// Failed login
				session.setAttribute("statusMsgreg", "loginFailed");
				response.sendRedirect("login.jsp");
				
			}
		}
		
		
		
		// if any exception is occurred during login it will give loginFailed
		catch(Exception e) {
			e.printStackTrace();
			session.setAttribute("statusMsgreg", "loginFailed");
			response.sendRedirect("login.jsp");
		}
		
	}
}

	



















