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
	System.out.println("You are logged in and at the dashboard");	
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
    <a class="navbar-brand" href="dashboard.jsp">Fly Away</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="Upcoming">Upcoming trips</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="password.jsp">Change password</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="Logout">Logout</a>
        </li>
        
        
      </ul>
      
    </div>
  </div>
</nav>
<div class="container-fluid">
<br><br>
<h3>Search for a flight below </h3>
<br>
<form action="Dashboard" method="get">

<label for="destination">Where do you want to go?:</label><br>
<select name="destination">
  
    <option value="Dubai">Dubai</option>
    <option value="London">London</option>
    <option value="New York">New York</option>
    <option value="Amsterdam">Amsterdam</option>
    <option value="Paris">Paris</option>
  </select><br><br>
  
  <label for="flightdate">Where do you want to go?:</label><br>
  <select name="flightdate">

    <option value="2022-02-23">2022-02-23</option>
    <option value="2023-02-23">2023-02-23</option>
    <option value="2024-02-23">2024-02-23</option>
    <option value="2025-02-23">2025-02-23</option>
    <option value="2026-02-23">2026-02-23</option>
  </select><br><br>

  <input type="submit" value="Submit">





</form>
 </div>

</body>
</html>
