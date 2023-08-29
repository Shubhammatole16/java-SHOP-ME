package com.newproject.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.newproject.dao.CartDAO;

@WebServlet(name = "removeoneproductServlet", urlPatterns={"/removeoneproductServlet"})
public class removeoneproductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        String proid = request.getParameter("removeone");
        
        int productId = Integer.parseInt(proid);
        
        CartDAO cartDAO = new CartDAO();
        
        try {
        	
        	boolean removed = cartDAO.removeoneProduct(productId, userId);
        	
        	if(removed) {
        		session.setAttribute("statusMsgreg","removeproduct");
        		response.sendRedirect("cart.jsp");
        	}else {
        		session.setAttribute("statusMsgreg","removeproductFailed");
        		response.sendRedirect("cart.jsp");
        	}
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        
    }
}