<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
  <title>Suvi Laukkanen</title>
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
      <a class="navbar-brand" href="#">Suvi Laukkanen</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>

<div id="heading" class="jumbotron text-center">
  <h1>Suvi Laukkanen</h1>
  <p>Curriculum Vitae</p> 
</div>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <img class="img-responsive" style="width:100%" id="pic_me" alt="me" src="resources/images/kuva.jpg">
    </div>
    
 	<div class="col-sm-8 text-left"> 
      <h2>About</h2>
      <p>Lorem ipsum...</p>
      <hr>
      <h2>Education</h2>
      <p>Lorem ipsum...</p>
      <hr>
      <h2>Work Experience</h2>
      <p>Lorem ipsum...</p>
      <hr>
      <h2>IT Skills</h2>
      <p>Lorem ipsum...</p>
      <hr>
      <h2>Languages</h2>
      <p>Lorem ipsum...</p>
    </div>
    
     <div class="col-sm-2 sidenav">
     <p><a href="https://github.com/SLaukkanen">My GitHub</a></p>
    </div>
    
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Copyright &copy; Suvi Laukkanen 2016</p>
</footer>

</body>
</html>