<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib  uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>About</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="resources/styles/style.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="index">Suvi Laukkanen</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="admin">Home</a></li>
        <li><a href="data">About</a></li>
        <li><a href="edu">Education</a></li>
        <li><a href="work">Work Experience</a></li>
        <li><a href="skills">Skills</a></li>
        <li><a href="languages">Languages</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span><sec:authentication property="principal.username"/></a></li>
		<li><a href="loginpage"><span class="glyphicon glyphicon-log-in"></span> Logout</a>      
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
      
    <div class="col-sm-8 text-left"> 
       <c:forEach items="${data}" var="d">
 	 
      	<h2>${d.heading}</h2>
     
      	<p>${d.summary}</p>
      	<p>${d.firstName} ${d.lastName}</p>
       	<p>${d.birthDay}</p>
       	<p>${d.address}</p>
       	<p>${d.areaCode}</p>
       	<p>${d.city}</p>
       	<p>${d.email}</p>
       	<p>${d.phone}</p>
       	<form:form modelAttribute="data" action="update/${d.firstName}" method="get">
       		<button type="submit" name="action">Update</button>
       	</form:form>
       	<form:form modelAttribute="data" action="new" method="get">
       		<button type="submit" name="action">New</button>
       	</form:form>
       	<form:form modelAttribute="data" action="delete/${d.firstName}" method="get">
       		<button type="submit" name="action">Delete</button>
       	</form:form>
      </c:forEach>
    </div>
     
</div>

<footer class="container-fluid text-center">
  <p>Copyright &copy; Suvi Laukkanen 2016</p>
</footer>

</body>
</html>