
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
	System.out.println("You are logged in and at the password");	
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
<h3>Change your account password. </h3>
<br>
<form action="Password" method="post">

<input type="hidden" id="email" name="email" value="${sessionScope.email}">

  <label for="password">Enter your current password:</label><br>
  <input type="password" id="password" name="password"><br><br>
  
  <label for="newpassword">Enter your new password:</label><br>
  <input type="password" id="newpassword" name="newpassword"><br><br>
  
  
  <input type="submit" value="Submit">





</form>
 </div>

</body>
</html>
