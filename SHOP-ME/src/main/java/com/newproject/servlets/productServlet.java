package com.newproject.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.IOException;
import com.newproject.dao.*;
import com.newproject.entity.Product;

@WebServlet(name= "productServlet", urlPatterns= {"/productServlet"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class productServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		HttpSession session = request.getSession();
		
		
		
		// Retrieve admin input from the form of add products
		String productName = request.getParameter("productName");
    	String description = request.getParameter("description");
    	double price = Double.parseDouble(request.getParameter("price"));
    	int stockQuantity = Integer.parseInt(request.getParameter("stockQuantity"));
    	int categoryId = Integer.parseInt(request.getParameter("categoryId"));
    	Part filePart = request.getPart("productImageURL");
    	
    	
    	
    	
    	//get submitted file name
    	String productImageURL = filePart.getSubmittedFileName();
    	
    	String ImageURL = "C:/Users/TUF GAMING/eclipse2-workspace/newProject/src/main/webapp/productImg/";
    	
    	
    	
    	// upload a product image in productImageURL path
    	filePart.write(ImageURL+productImageURL);
    	
    	
    	
    	// Create a product object with the provided product data
    	Product product = new Product( productName, description, price, stockQuantity, productImageURL, categoryId);
    	
    	
    	
    	// Created an instance of the ProductDAO
    	ProductDAO productDAO = new ProductDAO();
    	
    	
    	 
    	try {
    		// Check product add or not 
	    	boolean productAddSuccessful = productDAO.addProduct(product);
	    	
	    	
	    	
	    	
	    	
	    	
	    	// if product add successful it will give productAddSuccess and update product count
	    	if(productAddSuccessful) {
	    		session.setAttribute("statusMsgreg", "addProductSuccess");
	    		response.sendRedirect("admin.jsp");
	    	}
	    	
	    	
	    	
	    	// else it will give productAddFailed
	    	else {
	    		session.setAttribute("statusMsgreg", "addProductFailed");
	    		response.sendRedirect("admin.jsp");
	    	}
    	}
    	
    	
    	    	
    	// if any exception is occurred it will give productAddFailed
    	catch(Exception e) {
    		e.printStackTrace();
    		session.setAttribute("statusMsgreg", "addProductFailed");
    		response.sendRedirect("admin.jsp");
    	}
    	
	}

}
