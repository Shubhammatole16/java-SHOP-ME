<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REGISTER</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<body>
	
<%@include file="components/popupMsg.jsp" %>
	
<section class="vh-100 bg-image" style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
  <div class="mask d-flex align-items-center h-100 gradient-custom-3">
    <div class="container h-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
          <div class="card" style="border-radius: 15px;">
            <div class="card-body p-5">
              <h2 class="text-uppercase text-center mb-5">Create an account</h2>

              <form action=registerServlet method=post onsubmit="return checkPasswords()">

                <div class="form-outline mb-4">
                  <input type="text" autocomplete="off" placeholder="First Name" id="userFname" class="form-control form-control-Default" name="userFname" required>
                </div>
                
                <div class="form-outline mb-4">
                  <input type="text" autocomplete="off" placeholder="Last Name" id="userLname" class="form-control form-control-Default" name="userLname" required>
                </div>
                
                <div class="form-outline mb-4">
                  <input type="tel" autocomplete="off" placeholder="Mobile Number" id="userMobile" class="form-control form-control-Default" name="userMobile" required>
                </div>
				
                <div class="form-outline mb-4">
                  <input type="email" autocomplete="off"
                   placeholder="Your Email" id="userEmail" class="form-control form-control-Default" name="userEmail" required>
                </div>             

                <div class="form-outline mb-4">
                  <input type="password" placeholder="Password" id="userPassword" class="form-control form-control-Default" name="userPassword" required>
                </div>

                <div class="form-outline mb-4">
                  <input type="password" placeholder="Repeat your password" id="userPassword2" class="form-control form-control-Default" name="userPassword2" required>
                </div>
				
                <div class="form-check d-flex justify-content-center mb-5">
                  <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3cg" required>
                  <label class="form-check-label" for="form2Example3g">
                    I agree all Terms and Conditions
                  </label>
                </div>

                <div class="d-flex justify-content-center">
                  <button type="submit"
                    class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Register</button>
                </div>

                <p class="text-center text-muted mt-5 mb-0">Have already an account? <a href="login.jsp"
                    class="fw-bold text-body">Login here</a></p>

              </form>

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<script>
        // Function to check passwords before form submission
        function checkPasswords() {
            const password1 = document.getElementById('userPassword').value;
            const password2 = document.getElementById('userPassword2').value;

            if (password1 !== password2) {
               
                Swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: 'Passwords do not match!',
                });
                return false; // Prevent form submission
            }

            return true; // Allow form submission
        }
    </script>
</body>
</html>



 
 