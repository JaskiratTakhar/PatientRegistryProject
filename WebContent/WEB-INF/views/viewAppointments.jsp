<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Appointments</title>
<link href="resources/css/loginstyle.css" rel="stylesheet" type="text/css">
</head>
<body>
                                           <!-- this page is displayed by the ViewAppointmentServlet -->
                                           
                                           
 
<div class="toptop">
<h1 class="toptop-1"><a href="LandingPageRedirect" class="toptop-1">Booking<span class="text-primary">.</span> </a></h1>

</div>





<div class="nav">
	<div class="navigationbar">
				<ul class="topnav">
				
				 <li><a class="login" href="LogoutServlet">Logout</a></li> 
				
				
				<!-- <li><a class="Register" href="UserRegisterServlet">Register</a></li> -->
				<!-- <li><a class="Clinic" href ="#Clinic">Services</a></li> 
				<li class="right"><a href="#about">AboutUs</a></li> -->
				<li><a class="login" href="LandingPageRedirect">Home</a></li>
				</ul>
			</div>
	
	</div>
                                           
                                           
                                           
                                          
	<div class="login-page1" >
		<div class="form-viewAppointment">	
		<!-- these came from ViewAppointmentServlet  -->
					
		<h4 class="viewAppointment">You have one ${statusMsg} appointment with ${doctorMsg} on ${dateMsg} at ${timeMsg}</h4>				
		</div>
	</div>
	
	
	
	<footer class="footer-distributed">

			<div class="footer-left">

				<h3>We the best<span>Clinic</span></h3>

				<p class="footer-links">
					<a href="#">Home</a>
					�
					<a href="#">Blog</a>
					�
					<a href="#">Pricing</a>
					�
					<a href="#">About</a>
					�
					<a href="#">Faq</a>
					�
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
					<p>+1 438 9210001</p>
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