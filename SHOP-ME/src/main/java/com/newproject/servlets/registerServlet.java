package com.newproject.servlets;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.newproject.dao.UserDAO;

import com.newproject.entity.User;



@WebServlet(name = "registerServlet", urlPatterns = {"/registerServlet"})
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		
		
		
		 // Retrieve user input from the registration form
		String userFname = request.getParameter("userFname");
		String userLname = request.getParameter("userLname");
		String userMobile = request.getParameter("userMobile");
		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");
		String userType = "normal";
		
		
		
		
		// Create a User object with the provided user data
		User user = new User(userFname, userLname, userMobile, userEmail, userPassword, userType);
		
		
		
		
		// Create an instance of the UserDAO
		UserDAO userDAO = new UserDAO();
		
		
		
		
		try {
			// Check registration Successful or not
			boolean registrationSuccessful = userDAO.addUser(user);
			
			
			
			// if registration Successful it will give registerSuccess 
			if(registrationSuccessful) {
				session.setAttribute("statusMsgreg", "registerSuccess");
				response.sendRedirect("index.jsp");
			}
			
			
			
			// else it will give registerFailed
			else {
				session.setAttribute("statusMsgreg", "registerFailed");
				response.sendRedirect("login.jsp");
			}
		}
		
		
				
		// if any exception is occurred during login it will give registerFailed
		catch(Exception e) {
			e.printStackTrace();
			session.setAttribute("statusMsgreg", "registerFailed");
			response.sendRedirect("login.jsp");
		}	
	}
}






