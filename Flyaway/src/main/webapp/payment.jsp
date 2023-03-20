
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Pragma", "0");

String email = (String)session.getAttribute("email");
if(email==null)
{
	response.sendRedirect("index.jsp?error=You are not logged in! Please log in");
	System.out.println("You are not logged in! Please log in");
}
else
{
	System.out.println("You are logged in");	
}
	
%>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"

	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	
	crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="dashboard.jsp">FlyAway</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    
  </div>
</nav>
<div class="container-fluid">
<br><br>
<h2>Confirm your flight details and enter your payment information to book your ticket. </h2>
<br>
<form action="Confirmation" method="post">

<h4>Confirm Your Flight Details Below </h4>


<h6>Flight ID: ${requestScope.flightid}</h6>
<input type="hidden" name="flightid" value="${requestScope.flightid}">

<h6>Airline: ${requestScope.airline}</h6>
<input type="hidden" name="airline" value="${requestScope.airline}">

<h6>Flight Date: ${requestScope.flightdate}</h6>
<input type="hidden" name="flightdate" value="${requestScope.flightdate}">


<h6>Destination: ${requestScope.destination}</h6>
<input type="hidden" name="destination" value="${requestScope.destination}">

<h6>Price(USD): ${requestScope.price}</h6><br>
<input type="hidden" name="price" value="${requestScope.price}">

<input type="hidden" id="email" name="email" value="${sessionScope.email}">

<label for="name">Enter passenger name:</label><br>
<input type="text" id="name" name="name"><br><br>



<h4>Enter Your Payment Details Below </h4>

<label for="cardnumber">Enter the card number:</label><br>
<input type="text" id="cardnumber" name="cardnumber"><br><br>

<label for="cardname">Enter the name on the card:</label><br>
<input type="text" id="cardname" name="cardname"><br><br>

 <label for="address">Enter the address linked to card:</label><br>
<input type="text" id="address" name="address"><br><br>

  <label for="cvv">Enter the CVV:</label><br>
<input type="text" id="cvv" name="cvv"><br><br>


<input type="submit" value="Submit">
</form>
 </div>

</body>
</html>
