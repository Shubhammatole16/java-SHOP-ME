<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

</head>
<body>



<%@include file="components/popupMsg.jsp" %> 



<section class="vh-100 bg-image" style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
  <div class="mask d-flex align-items-center h-100 gradient-custom-3">
    <div class="container h-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
          <div class="card" style="border-radius: 15px;">
            <div class="card-body p-5">
              <h2 class="text-uppercase text-center mb-5">Login</h2>
              <p class="text-black-50 text-center mb-5">Please enter your email and password!</p>
		
				
		
              <form action=loginServlet method=post>
				<input type="hidden" >
                <div class="form-outline mb-4">
                  <input type="email" placeholder="Your Email" id="userEmail" class="form-control form-control-Default" name="userEmail" required>
                </div>

                <div class="form-outline mb-4">
                  <input type="password" placeholder="Password" id="userPassword" class="form-control form-control-Default" name="userPassword" required>
                </div>

                <div class="form-check d-flex justify-content-center mb-5">
                  <input class="form-check-input me-2" type="checkbox"  id="form2Example3cg" />
                  <label class="form-check-label" for="form2Example3g">
                    Remember Password
                  </label>
                </div>

                <div class="d-flex justify-content-center">
                  <button type="submit"
                    class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Log In</button>
                </div>

              
				<p class="text-center text-muted mt-5 mb-0">Don't have an account?<a href="register.jsp"
                    class="fw-bold text-body">Sign Up</a></p>
              </form>

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>



</body>
</html>