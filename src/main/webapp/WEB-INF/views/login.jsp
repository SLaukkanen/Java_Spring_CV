<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
  <title><spring:message code="login"/></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="resources/styles/style.css">
  <link rel="stylesheet" type="text/css" href="resources/styles/form.css"/>
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
      <a class="navbar-brand" href="../"><spring:message code="name"/></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
     
      <ul class="nav navbar-nav navbar-right">
        <li><a href="login"><span class="glyphicon glyphicon-log-in"></span><spring:message code="login"/></a></li>
      </ul>
    </div>
  </div>
</nav>

<div id="heading" class="jumbotron text-center">
  <h1><spring:message code="name"/></h1>
  <p><spring:message code="cv"/></p> 
</div>
  
<div class="container-fluid text-center">    
  <div class="row content">
    
    
 	<div class="col-sm-8 text-left"> 
 	
 	<h1><spring:message code="login"/></h1>

	<c:if test="${not empty loginerror}">
		<p class="Error"><spring:message code="login.fail"/></p>
	</c:if>

	<c:if test="${not empty loggedout}">
		<p class="Info"><spring:message code="login.out"/></p>
	</c:if>
	
	<form action="j_spring_security_check" method="post">
	<fieldset>
		<table>
		<tr><td><spring:message code="login.usrname"/></td><td><input type="text" name="j_username" value=""></td></tr>
		<tr><td><spring:message code="login.psw"/></td><td><input type="password" name="j_password" /></td></tr>
		<tr><td>&nbsp;</td><td><button type="submit"><spring:message code="submit"/></button></td></tr>
		</table>
	</fieldset>
	</form>
 	 
    </div>
    
     
    
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Copyright &copy; Suvi Laukkanen 2016</p>
</footer>

</body>
</html>