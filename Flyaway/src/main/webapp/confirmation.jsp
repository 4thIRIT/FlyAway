
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

<h2>Congratulations, you have successfully booked the ${requestScope.flightid} from Ghana to ${requestScope.destination}.</h2>
<h3>Your itinerary and boarding pass will be sent to you account email. We look forward to flying with you.</h3>

</body>
</html>