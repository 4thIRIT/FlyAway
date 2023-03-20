
<%@page import="entity.Flight"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
    <a class="navbar-brand" href="#">Fly Away</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Upcoming trips</a>
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
		
		<h2>No flights available. </h2><br><br>
		
		<a class="btn btn-primary" href="dashboard.jsp" role="button">Search again</a>
 </div>

</body>
</html>
