<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");%>
<%@ page import="com.newproject.dao.*" %>
<%@ page import="com.newproject.Helper.*" %>
<%@ page import="com.newproject.entity.*" %>
<%@ page import="java.util.*" %>
    
 <!DOCTYPE html>  

    

<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME</title>


<%-- In this all the  javascript and css links are located --%>
<%@include file="components/css_js_all.jsp" %>
</head>
<body>




<%@include file="components/popupMsg.jsp" %>



<%-- Here I include navbar.jsp file from components folder --%> 
<%@include file="components/navbar.jsp" %>


<div class="container-fluid">
	<div class="row mt-3 mx-2">
	
	
	
	<%	 
			//we get the category string using url when user click on specific category
			String catid = request.getParameter("category");
			
	
			ProductDAO productDAO = new ProductDAO();
			List<Product> allProducts = null;
			
			
			//if catid is null or equls to "all" then display all products
			if(catid == null || catid.trim().equals("all")){
				allProducts = productDAO.getAllProducts();
				
			
			//else we display catid which is eqaul to selected category
			}else{
				int cid = Integer.parseInt(catid.trim());
				allProducts = productDAO.getAllProductsById(cid);
			}
			
			
		
			CategoryDAO categoryDAO = new CategoryDAO();
			List<Category> allCategories = categoryDAO.getAllCategories();
    %>
	
	
	
	<%-- Start of Category Part --%>
		<div class="col-md-2">
			<div class="row mt-4">
			<div class="list-group">
				<a href="index.jsp?category=all" class="list-group-item  list-group-item-action <%= (catid == null || catid.equals("all")) ? "active" : "" %>">
				    All Categories
				</a>
				
				
			<%-- Using for-each loop shoe categories --%>
				<% for(Category cat : allCategories){%>
					
					
					<%-- Determine the active class for category links --%>
					<a href="index.jsp?category=<%=cat.getcategoryId() %>"
		                   class="list-group-item list-group-item-action <%= (catid != null && catid.equals(String.valueOf(cat.getcategoryId()))) ? "active" : "" %>">
		                    <%= cat.getcategoryName() %>
                	</a>
				<% } %>
				
			</div>
			</div>
		</div>
		<%-- End of Category Part --%>
		
		
		
		
		<%-- Start of Product Part --%>
		<div class="col-md-10">
			<div class="row mt-4">
				<div class="col-md-12">
					<div class="card-columns">
					
					
					<%-- For each loop for show the all products --%>
						<% for(Product pro : allProducts) { %>
							
							
							<%-- This is start of product card --%>
							<div class="card">
							<div class="card product-card">
								<div class="container text-center">
									
									
									<%-- Display the product image --%>
									<img src="productImg/<%=pro.getproductImageURL()%>" class="card-img-top m-2" style="max-heigth:270px !important;  width:auto !important; max-width:100% !important; "  alt=""/>
								</div>
								<div class="card-body">
								
								
									<%-- Display product name --%>
									<h5 class="card-title"> <%= pro.getproductName() %></h5>
									
									
									<%-- Display product description --%>
									<p class="card-text"> <%= descHelper.get10words(pro.getdescription()) %></p>
								</div>
								<div class="card-footer text-center">
								
								
									<%-- This is add to cart button till now not created cart --%>
									<form action="cartServlet" method="post">
									    <input type="hidden" name="productId" value="<%=pro.getproductId()%>">
									    <button class="btn btn-success" >Add To Cart</button>
									
									
										<%--Display product price --%>
										<button class="btn btn-outline-primary"> &#8377 <%= pro.getprice() %></button>
									</form>	
								</div>
							</div>
							</div>
							<%-- End of product card --%>
						 <% } 
						
						
							//if product is not found in specific category hen display msg
						 	if(allProducts.size() == 0){
						 		out.println("<h2 style='font-color: royalblue'>Products are not available in this Category!!</h2>");	
						 	}
						 %>											
					</div>
				</div>
			</div>
		</div>
		<%-- End of Product Part --%>
		
		
		
	</div> 
</div> 

	
	<%@include file="components/comman_modals.jsp" %> 
<script>
function addCartSuccess() {
    Swal.fire({
        icon: 'success',
        title: 'Added to Cart',
        timer: 1000, // Set the timer to 1000 milliseconds (1 second)
        showConfirmButton: false
    });
}
</script>
</body>
</html>