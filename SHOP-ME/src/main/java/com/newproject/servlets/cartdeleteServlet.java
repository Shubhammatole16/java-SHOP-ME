package com.newproject.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;

import com.newproject.dao.CartDAO;


@WebServlet(name = "cartdeleteServlet", urlPatterns= {"/cartdeleteServlet"})
public class cartdeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		
		String removeproduct = request.getParameter("removeproduct");
		
		Integer uid = (Integer) session.getAttribute("userId");
		int deletepro = Integer.parseInt(removeproduct);
	
		CartDAO cartDAO = new CartDAO();
		
		try {
			boolean removeStatus = cartDAO.getremoveStatus(uid, deletepro);
			
			if(removeStatus) {
				session.setAttribute("statusMsgreg", "removeproduct");
				response.sendRedirect("cart.jsp");
			}else {
				session.setAttribute("statusMsgreg", "removeproductFailed");
				response.sendRedirect("cart.jsp");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			session.setAttribute("statusMsgreg", "removeproductFailed");
			response.sendRedirect("cart.jsp");
		}
	}

}
