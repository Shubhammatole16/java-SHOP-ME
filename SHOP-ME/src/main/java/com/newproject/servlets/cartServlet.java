package com.newproject.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.newproject.dao.*;

import com.newproject.entity.Product;

@WebServlet(name = "cartServlet", urlPatterns = {"/cartServlet"})
public class cartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  PrintWriter out = response.getWriter();
	  HttpSession session = request.getSession();
	  RequestDispatcher rd = null;
	  
	  
	  //retrive product id through url
	  String pid = request.getParameter("productId"); 
	  
	  
	  //retrive user id through session
	  Integer userid = (Integer) session.getAttribute("userId");
	  
		if(userid == null) {
			  response.sendRedirect("login.jsp");
			  return;
		  }
	  
	  int proid = Integer.parseInt(pid);
	
	  CartDAO cartDAO = new CartDAO();
	  
	  

		try {
			 boolean cartAddStatus = cartDAO.addCart(userid, proid);

			 if(cartAddStatus){
				 session.setAttribute("statusMsgreg", "cartAddSuccess");
				 response.sendRedirect("index.jsp");
			 }

			 else {
				 session.setAttribute("statusMsgreg", "cartAddFailed");
				 response.sendRedirect("index.jsp");
			 }
			 
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
			session.setAttribute("statusMsgreg", "cartAddFailed");
			response.sendRedirect("index.jsp");
		}
	}
}

