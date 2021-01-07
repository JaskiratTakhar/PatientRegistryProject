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
				
				 <li><a class="login" href="LogoutServlet">Logout</a></li> 
				
				
				<!-- <li><a class="Register" href="UserRegisterServlet">Register</a></li> -->
				<li><a class="Clinic" href ="#Clinic">Services</a></li> 
				<li class="right"><a href="#about">AboutUs</a></li>
				<li><a class="login" href="LandingPageRedirect">Home</a></li>
				</ul>
			</div>
	
	</div>








	<div class="login-page">
		<div class="form">
			<h4 class="error">${errorMsg}</h4>  <!-- this message is displayed by  -->
			<form class ="login-form" action="BookingServlet" method="post">
			<select  name="doctor" required style="-webkit-appearance: none;-o-appearance: none;display: block;padding: 18px 127px 18px 13px !important; margin-bottom: 15px;font: 16px;">
    			<option value="" disabled selected >-- Select Doctor --</option>
    			<option value="Dr.Vinay Kakkar">Dr.Vinay Kakkar</option>
    			<option value="Dr.Samandeep Sidhu">Dr.Samandeep Sidhu</option>
    			<option value="Dr.Madhu Mangat"  >Dr.Madhu Mangat</option>
   				 <option value="Dr.Kuldeep Brar">Dr.Kuldeep Brar</option>
  			</select>
			
			<!-- <input type="text" placeholder="Doctor" name="doctor" required/> -->
			<input type="date" placeholder="Select date" name="date" min='2019-05-17'max='2019-12-31' required />
			
			<select  name="time" required style="-webkit-appearance: none;-o-appearance: none;display: block;padding: 18px 160px 18px 11px!important; margin-bottom: 15px;font: 16px;">
    			<option value="" disabled selected >-- Select time --</option>
    			<option value="09:00">09:00</option>
    			<option value="09:30">09:30</option>
    			<option value="10:00">10:00</option>
    			<option value="10:30">10:30</option>
    			<option value="11:00">11:00</option>
    			<option value="11:30">11:30</option>
    			<option value="13:00">13:00</option>
    			<option value="13:30">13:30</option>
    			<option value="14:00">14:00</option>
    			<option value="14:30">14:30</option>
    			<option value="15:00">15:00</option>
    			<option value="15:30">15:30</option>
    			<option value="16:00">16:00</option>
    			<option value="16:30">16:30</option>
    			<option value="17:00">17:00</option>
    			
  			</select>
			<select  name="healthIssue" required style="-webkit-appearance: none;-o-appearance: none;display: block;padding: 18px 111px 18px 13px !important; margin-bottom: 15px;font: 16px;">
    			<option value=" healthIssue" disabled selected>-- Select Health Issue -- </option>
    			<option value="Regular check up">Regular check up</option>
    			<option value="Injury">Injury</option>
    			<option value="Substance Abuse"  >Substance Abuse</option>
   				 <option value="Immunization">Immunization</option>
  			</select>
			
			
			
			<button>Confirm Appointment</button>
			<p class="message">Got Appointment? <a href="ViewAppointmentServlet"><strong>Check?</strong></a></p>
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