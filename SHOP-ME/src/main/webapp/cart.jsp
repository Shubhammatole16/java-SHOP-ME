<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
   		 Integer uid1 = (Integer) session.getAttribute("userId");
   		 
   		 
    		if(uid1 == null){
    			response.sendRedirect("login.jsp");
    			return;
    		}
    		%>
    
<%@page import="java.util.List" %>
<%@page import="com.newproject.dao.*" %>
<%@page import="com.newproject.entity.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="components/css_js_all.jsp" %>



</head>
<body>
<%@include file="components/popupMsg.jsp" %>
<%@include file="components/navbar.jsp" %>

		<% 
		
			
			
			CartDAO cartDAO = new CartDAO();
			
			List<Cart> cartitems = cartDAO.getallcartitems(uid1);
			
			int allItems = cartDAO.getproductcount(uid1);
			
			double totalPrice = cartDAO.totalCartPrice(cartitems);
			
		%> 



<% if (cartitems == null || cartitems.size() == 0) { %>
<h1 class="text-center mt-4 font-italic"><kbd class="btn-secondary">SHOPPING  CART</kbd></h1>
    <div class="container text-center border border-dark rounded mt-4">
        <img src="images/empty-cart.png" style="max-width: 80vw; max-height: 60vw;" class="mt-4"><br>
        <button type="button" class="btn btn-outline-success btn-lg m-4 font-weight-bold" onclick="window.location.href='index.jsp'">SHOP NOW</button>
    </div>
<% } 


else { %>




    <div class="container mt-5">
       <h1 class="text-center mt-4 font-italic"><kbd class="btn-secondary">SHOPPING  CART</kbd></h1>
        <div class="row">
            <div class="col-md-8">
                <div class="card mb-3">
                  <% for(Cart cart : cartitems){ %>
                    <div class="row no-gutters">
                        <div class="col-md-4">
                            <img src="productImg/<%= cart.getproductImageURL() %>" class="card-img" alt="Product Image">
                            
                        </div>
                        <div class="col-md-8">
                            <div class="card-body border-bottom">
                                <h5 class="card-title"><%= cart.getproductName() %></h5>
                             
                                <h5 class="card-text font-itallic"><strong>Price:&#8377; <%= cart.getprice() * cart.getquantity() %></strong></h5>
                                <div class="input-group">
                                
	                                <form action="removeoneproductServlet" method="post">
									    <span class="input-group-btn">
									        <!-- Hidden input field with product ID to identify the product -->
									        <input type="hidden" name="removeone" value="<%= cart.getproductId() %>">
									        
									        <!-- Disable the "-" button if quantity is 1 -->
									        <button type="submit" class="btn btn-danger" <%= cart.getquantity() == 1 ? "disabled" : "" %>>-</button>
									    </span>
									</form>
	                                
                                    <input type="text" class="form-control text-center" value="<%= cart.getquantity() %>">
                                    
	                                    <form action="addoneproductServlet" method="post">
		                                    <span class="input-group-btn">
		                                    <input type="hidden" name="addone" value="<%= cart.getproductId()%>">
		                                        <button type="submit" class="btn btn-success">+</button>
		                                    </span>
	                                    </form>
	                                    
                                </div>
                                
                                <form action="cartdeleteServlet" method="post">
                                	<input type="hidden" name="removeproduct" value="<%= cart.getproductId()%>">
                                	<button class="btn btn-danger mt-2">Remove</button>
                                </form>
                            </div>
                        </div>
                    </div>
                     <% } %>
                </div>
                <!-- here  products add dynamically -->
            </div>
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Cart Summary</h5>
                        <p>Total Items: <%= allItems %></p>
                        <p>Total Price: &#8377; <%= totalPrice %></p>
                        <a href="#" class="btn btn-primary">Proceed to Checkout</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <% } %>
</body>
</html>

