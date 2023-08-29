package com.newproject.servlets;

import java.io.IOException;

import com.newproject.dao.CartDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(name = "addoneproductServlet", urlPatterns= {"/addoneproductServlet"})
public class addoneproductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        String proid = request.getParameter("addone");
       
        int productId = Integer.parseInt(proid);
       
        
        CartDAO cartDAO = new CartDAO();
		
		try {
			
			boolean added = cartDAO.addoneProduct(productId, userId);
			
			if(added) {
				session.setAttribute("statusMsgreg", "cartAddSuccess");
				response.sendRedirect("cart.jsp");
			}else {
				session.setAttribute("statusMsgreg", "cartAddFailed");
				response.sendRedirect("cart.jsp");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
 