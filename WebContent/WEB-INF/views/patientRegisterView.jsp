<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link href="resources/css/loginstyle.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="toptop">
<h1 class="toptop-1"><a href="LandingPageRedirect" class="toptop-1">Booking<span class="text-primary">.</span> </a></h1>

</div>





<div class="nav">
	<div class="navigationbar">
				<ul class="topnav">
				
				 <li><a class="login" href="LoginRedirectServlet">Login</a></li>
				
				
				<!-- <li><a class="Register" href="#register">Register</a></li> -->
				<!-- <li><a class="Clinic" href ="#Clinic">Services</a></li>
				<li class="right"><a href="#about">AboutUs</a></li> -->
				<li><a class="login" href="LandingPageRedirect">Home</a></li>
				</ul>
			</div>
	
	</div>





	<div class="login-page">
		<div class="form">
			<h5 class="error">${errorMsg}</h5>
			<form class ="login-form" action="RegisterServlet" method="post">
			<input type="text" placeholder="Example@company.domain" name="userName" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required/>
			<input type="text" placeholder="FirstName" name="firstName" required/>
			<input type="text" placeholder="LastName" name="lastName" required/>
			
			<select  name="healthIssue" required style="-webkit-appearance: none;-o-appearance: none;display: block;padding: 15px 111px 15px 12px !important; margin-bottom: 15px;font: 16px background-color: #f2f2f2 !important;
    margin-bottom: 15px;">
    			<option value=" healthIssue" disabled selected>-- Select Health Issue -- </option>
    			<option value="Regular check up">Regular check up</option>
    			<option value="Injury">Injury</option>
    			<option value="Substance Abuse"  >Substance Abuse</option>
   				 <option value="Immunization">Immunization</option>
  			</select>
			<input type="password" placeholder="Password" name="pwd" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required/>
					
			<button>Register</button>
			
			<p class="message">Already registered?<a href="login">Sign In</a></p>
			</form>		
		</div>
	</div>
	
	
	<footer class="footer-distributed">

			<div class="footer-left">

				<h3>We the best<span>Clinic</span></h3>

				<p class="footer-links">
					<a href="#">Home</a>
					·
					<a href="#">Blog</a>
					·
					<a href="#">Pricing</a>
					·
					<a href="#">About</a>
					·
					<a href="#">Faq</a>
					·
					<a href="#">Contact</a>
				</p>

				<p class="footer-company-name">Wethebestclinic &copy; 2019</p>
			</div>

			<div class="footer-center">

				<div>
					<i class="fa fa-map-marker"></i>
					<p><span>21 King Street</span> Toronto, ON Canada </p>
				</div>

				<div>
					<i class="fa fa-phone"></i>
					<p>+1 438 921 0001</p>
				</div>

				<div>
					<i class="fa fa-envelope"></i>
					<p><a href="mailto:support@company.com">support@wethebestclinic.com</a></p>
				</div>

			</div>

			<div class="footer-right">

				<p class="footer-company-about">
					<span>About the clinic</span>
					Since 1947 we are providing best treatment in all of toronto with 94% satisfaction rate.
					
				</p>

				

			</div>

		</footer>
</body>
</html>