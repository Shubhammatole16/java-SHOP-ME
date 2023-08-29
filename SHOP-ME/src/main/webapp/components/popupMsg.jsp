

<%-- statusMsg take getAttrribute from servlets and store it in String statusMsg for given check --%>
<%



String statusMsgreg = (String) session.getAttribute("statusMsgreg");
			
			
	 
			
	 
		
//Check add category Status if addCategoryFailed then display Add-Category Failed!    
if("addCategoryFailed".equals(statusMsgreg)){    %>
	<script>
		Swal.fire({
			icon: 'error',
			title: 'Failed to add Category!',
			timer: 1000,
			showConfirmButton: false
		});
	</script>
<% }	
				

			 
	    
	    
	    
//Check add category Status if addCategorySuccess then display Add-Category Success!    
if("addCategorySuccess".equals(statusMsgreg)){ %>
	<script>
		Swal.fire({
			icon: 'success',
			title: 'New Category Added!',
			timer: 1000,
			showConfirmButton: false
		});
	</script>
<% }			
			





			
//Check add Product Status if addProductSuccess then display Add-Product Success!    
if("addProductSuccess".equals(statusMsgreg)){ %>
	<script>
		Swal.fire({
			icon: 'success',
			title: 'New Product Added!',
			timer: 1000,
			showConfirmButton: false
		});
	</script>
<% }	

			
	



//Check add Product Status if addProductFailed then display Add-Product Failed! 
if("addProductFailed".equals(statusMsgreg)) { %>
	<script>
		Swal.fire({
			icon: 'error',
			title: 'Failed to add Product!',
			timer: 1000,
			showConfirmButton: false
		});
	</script>
<% }
			
			
			
			


//Check Registration Status if registerFailed then display Registration Failed 
if("registerFailed".equals(statusMsgreg)){ %>
	<script>
		Swal.fire({
			icon: 'error',
			title: 'Registration Failed!',
			timer: 1000,
			showConfirmButton: false
		});
	</script>
<% }
		
			
	



			
//Check Registration Status if registerSuccess then display Registrtion Success! 
if("registerSuccess".equals(statusMsgreg)){ %>
	<script>
		Swal.fire({
			icon: 'success',
			title: 'Registration Success!',
	  		timer: 1000,
			showConfirmButton: false
		});
	</script>
<% } 
			
			
	




//Check Login Status if loginSuccess then display Login Success! 
if("loginSuccess".equals(statusMsgreg)) { %>
	<script>
		Swal.fire({
			icon: 'success',
			title: 'Login Success!',
			timer: 1000,
			showConfirmButton: false
		});
	</script>
<% }  
			
			




//Check Login Status if loginFailed then display Login Failed!  
if("loginFailed".equals(statusMsgreg)) { %>
	<script>
		Swal.fire({
			icon: 'error',
			title: 'Login Failed!',
			timer: 1000,
			showConfirmButton: false
		});
	</script>
<% }






//Check Logout Status if logoutSuccess then display Logout Success!
if("logoutSuccess".equals(statusMsgreg)) { %>
	<script>
		Swal.fire({
			icon: 'success',
			title: 'Logout Success!',
			timer: 1000,
			showConfirmButton: false
		});
	</script>
<% }







//Check cart add if cartAddSuccess then display Product Added Success!
if("cartAddSuccess".equals(statusMsgreg)) { %>
	<script>
		Swal.fire({
			icon: 'success',
			title: 'Item Added!',
			timer: 1000,
			showConfirmButton: false
		});
	</script>
<% }









//Check cart add Status if cartAddFailed then display Failed to add product! 
if("cartAddFailed".equals(statusMsgreg)) { %>
	<script>
		Swal.fire({
			icon: 'error',
			title: 'Failed to add Product!',
			timer: 1000,
			showConfirmButton: false
		});
	</script>
<% }





//Check remove product from cart if not removed then display server is not reponding!
if("removeproductFailed".equals(statusMsgreg)) { %>
	<script>
		Swal.fire({
			icon: 'error',
			title: 'server is not reponding!',
			text:'Please try again'
			timer: 1500,
			showConfirmButton: false
		});
	</script>
<% }






//Check remove product from cart if removed then display 'Product Removed!
if("removeproduct".equals(statusMsgreg)) { %>
	<script>
		Swal.fire({
			icon: 'success',
			title: 'Product Removed!',
			timer: 1000,
			showConfirmButton: false
		});
	</script>
<% }







		
			
			
			session.removeAttribute("statusMsgreg");

 %>









