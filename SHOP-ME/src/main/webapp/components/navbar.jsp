<%@ page import="com.newproject.dao.*" %>
<style>
.logo {
    font-size: 2rem;
    font-weight: bolder;
    text-transform: uppercase;
    background-image: linear-gradient(-225deg,
            #231557 0%,
            #6917c2 100%);
    background-size: 200% auto;
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    animation: textclip 2s linear infinite;
 }
 .custom-bg{
	background-color: #6917c2 !important;                 
}
 
</style>


	
<nav class="navbar navbar-expand-lg navbar-dark custom-bg">

	<div class="container-fluid">
		 <a class="navbar-brand logo" href="#">SHOP NEW</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		
		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item active">
		        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
		      </li>
		      
		      
		     
		    </ul>
		    <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
		    <div class="btn-group mr-2" role="group" aria-label="First group">
		    <%  String userName = (String) session.getAttribute("userName"); 
		    	
		    
				if(userName == null){ %>
				      <button class="btn btn-outline-success"><a class="text-white" href="register.jsp">REGISTER</a></button>
				      <button class="btn btn-outline-success"><a class="text-white" href="login.jsp">LOGIN</a></button>
			      <% } 
					else { %> 
						<div class="transparent" style="font-size:30px;" onclick="window.location.href = 'cart.jsp';">
						<% 
						
						
						String userTypead = (String) session.getAttribute("userType");
						int useridnav = (Integer) session.getAttribute("userId");
						CartDAO cartDAO = new CartDAO();
						int productCountnav = cartDAO.getproductcount(useridnav);
						
						
							if(userTypead.equals("normal")) { %>
							
							
							<button type="button" class="btn btn-primary-transparent mr-2" style="font-size:25px; border-radius:30px" >
							 	 <i class="fa fa-shopping-cart text-white mr-1" aria-hidden="true"></i><span class="badge badge-transparent"><%= productCountnav %></span>
							</button>
						<% } %></div>
					
					<button class="btn btn-primary-transparent text-white" style="font-size:25px; font-weight:bold"><%= session.getAttribute("userName") %></button>
				      <button class="btn btn-outline-danger text-white" onclick="logoutReq()">LOGOUT</button>
				      <% } %>
					</div>
		    </div>
		  </div>
	</div>
 
</nav>
<!-- Navbar -->


<script>
	function logoutReq(){
		Swal.fire({
			title: "Are you sure you want to do this?",
		    icon: "warning",
		    showCancelButton: true,
		    confirmButtonColor: "#3085d6",
		    cancelButtonColor: "#d33",
		    confirmButtonText: '<a href="logoutServlet" style="color: white; text-decoration: none;">LOGOUT</a>',
		    cancelButtonText: "Cancel",
		});
	}
</script>
