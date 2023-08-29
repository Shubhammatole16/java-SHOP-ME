<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.newproject.entity.*" %> 
<%@ page import="com.newproject.dao.*" %>


    <%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");	
    

    
	    String userName1 = (String) session.getAttribute("userName");
		String userType = (String) session.getAttribute("userType");
	
		
		
		
		// If username is null then it will redirect the login page
		if(userName1 == null){
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			return;
		}
		
		
		
		// If usertype is normal then it will redirect the login page
		else if("normal".equals(userType)){
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			return;
		}
		
		
	    CategoryDAO categoryDAO = new CategoryDAO();
		ProductDAO productDAO = new ProductDAO();
		UserDAO userDAO = new UserDAO();
		
		List<Category> allCategories = categoryDAO.getAllCategories();
		
		int categoryCount = categoryDAO.getcategoryCount();
		int productCount = productDAO.getproductCount();
		int userCount = userDAO.getuserCount();
	    
	 	
		
    %>
       
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>ADMIN</title>

<%@include file="components/css_js_all.jsp" %>

</head>
<body>

<%@include file="components/popupMsg.jsp" %>

<%@include file="components/navbar.jsp" %>
	
	
	<div class="container admin">
	
		<%-- First Row --%>
		<div class="row mt-3">
			<%-- BOX 1 --%>
			<div class="col-md-4">
				<div class="card">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width: 130px" class="img-fluid rounded-circle" src="images/users.png" alt="">
						</div>
						<h1><%= userCount %></h1>
						<h1>USERS</h1>
					</div>
				</div>
			</div>
			
			<%-- BOX 2 --%>
			<div class="col-md-4">
				<div class="card">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width: 130px" class="img-fluid" src="images/categories.png" alt="">
						</div>
						<h1><%= categoryCount %></h1>
						<h1>CATEGORIES</h1>
					</div>
				</div>
			</div>
			
			<%-- BOX 3 --%>
			<div class="col-md-4">
				<div class="card">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width: 130px" class="img-fluid" src="images/products.png" alt="">
						</div>
						<h1><%= productCount %></h1>
						<h1>PRODUCTS</h1>
					</div>
				</div>
			</div>
		</div>
		
		<%-- Second Row --%>
		<div class="row mt-3">
		
			<%-- BOX 4 --%>
			<div class="col-md-6">
				<div class="card" data-toggle="modal" data-target="#add-category-modal">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width: 130px" class="img-fluid" src="images/add-categories.png" alt="">
						</div>
						<p class="mt-2">Click Here to Add New Category</p>
						<h1>ADD CATEGORIES</h1>
					</div>
				</div>
			</div>
			
			
			<%-- BOX 5 --%>
			<div class="col-md-6">
				<div class="card" data-toggle="modal" data-target="#add-product-modal">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width: 130px" class="img-fluid" src="images/add-products.png" alt="">
						</div>
						<p class="mt-2">Click Here to Add New Product</p>
						<h1>ADD PRODUCTS</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	
	
	<%-- Add-Category Modal --%>

		<!-- Modal -->
		<div class="modal fade" id="add-category-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-lg" role="document">
		    <div class="modal-content">
		      <div class="modal-header custom-bg text-white">
		        <h5 class="modal-title" id="exampleModalLabel">Fill Category Details</h5>
		        <button type="button" class="close text-white" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		      
		      	<form action="categoryServlet" method="post">
		      		
		      		<div class="form-group">
		      			<input type="text" style="width: 48rem; border-color :#e2e2e2;" class="from-control form-control-lg" name="categoryName" placeholder="Enter Category Name" required>
		      		</div>
		      		
		      		<div class="container text-center">
		      			<button type="submit" class="btn btn-outline-success">Add Category</button>
		      			<button class="btn btn-outline-danger" data-dismiss="modal">Close</button>
		      		</div>
		      	</form>
		        
		      </div>
		      
		    </div>
		  </div>
		</div>
		
	<%-- End-Category Modal --%>
	
	
	
	
	<%-- Add-Product Modal --%>

		<!-- Modal -->
			<div class="modal fade" id="add-product-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-lg" role="document">
		    <div class="modal-content">
		      <div class="modal-header custom-bg text-white">
		        <h5 class="modal-title" id="exampleModalLabel">Fill Product Details</h5>
		        <button type="button" class="close text-white" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		      
		      	<form action="productServlet" method="post" enctype="multipart/form-data">
		      		
		      		<div class="form-outline mb-4">
		      			<input type="text" style="width: 48rem; border-color :#e2e2e2;" class="from-control form-control-lg" name="productName" placeholder="Enter Product Name" required>
		      		</div>
		      		
		      		<div class="form-outline mb-4">
		      			<input type="text" style="width: 48rem; border-color :#e2e2e2;" class="from-control form-control-lg" name="description" placeholder="Describe Product" required>
		      		</div>
		      		
		      		<div class="form-outline mb-4">
		      			<input type="text" style="width: 48rem; border-color :#e2e2e2;" class="from-control form-control-lg" name="price" placeholder="Enter Price of Product" required>
		      		</div>
		      		
		      		<div class="form-outline mb-4">
		      			<input type="text" style="width: 48rem; border-color :#e2e2e2;" class="from-control form-control-lg" name="stockQuantity" placeholder="Enter Quantity of Product" required>
		      		</div>
		      				      	
					<div class="form-outline mb-4">
		      			<select style="width: 48rem; border-color :#e2e2e2;" class="custom-select form-control-lg avtive" name="categoryId" required>
			      			<option value="" selected disabled>Select type of category</option>
			      			<%  
							   for (Category cat : allCategories) { 
							%>
							   <option value="<%= cat.getcategoryId() %>"><%= cat.getcategoryName() %></option>
							<% } %>
		      			</select>
		      		</div>
		      		
		      		<div class="form-group mb-4">
		      			<input type="file" style="width: 48rem; border-color :#e2e2e2;" class="form-control form-control-default" name="productImageURL" required>
		      			<small>Select Product Image(JPG, PNG, JPEG)</small>
		      		</div>
		      		
		      		<div class="container text-center">
		      			<button type="submit" class="btn btn-outline-success">Add Product</button>
		      			<button class="btn btn-outline-danger" data-dismiss="modal">Close</button>
		      		</div>
		      	</form>
		        
		      </div>
		      
		    </div>
		  </div>
		</div>
		
	<%-- End-Product Modal --%>
	

	
	
</body>
</html>