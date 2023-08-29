package com.newproject.servlets;

import com.newproject.dao.CategoryDAO;

import com.newproject.entity.Category;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "categoryServlet", urlPatterns = { "/categoryServlet" })
public class categoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = null;
        HttpSession session = request.getSession();
        

        
        	// Retrieve Admin input from the form of add category
            String categoryName = request.getParameter("categoryName");

            
            
            // Create a category object with the provided category data
            Category category = new Category(categoryName);
            
            
            
            // Created an instance of the CategoryDAO
            CategoryDAO categoryDAO = new CategoryDAO();
            
            
            
            try {
            	
            	
	            // Check if category add or not
	            boolean categoryAddSuccessful = categoryDAO.addCategory(category);
	         
  
	            
	            // if category add successful it will give categoryAddSuccess and update category count
	            if (categoryAddSuccessful) {
	                session.setAttribute("statusMsgreg", "addCategorySuccess");
	                response.sendRedirect("admin.jsp");
	            }
	            
	            
	            // else it will give categoryAddFailed
	            else {  
	            	session.setAttribute("statusMsgreg", "addCategoryFailed");
	                response.sendRedirect("admin.jsp");
	            }      
            }
            
            
            // if any exception is occurred during login it will give loginFailed
            catch(Exception e) {
            	e.printStackTrace();
            	session.setAttribute("statusMsgreg", "addCategoryFailed");
                response.sendRedirect("admin.jsp");
            	
            }
    	}    
}
