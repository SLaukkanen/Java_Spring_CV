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
    <form:form modelAttribute="skill" action="/skills/save_new" method="post">
	<fieldset>
		<legend><spring:message code="skill.legend" /></legend>
				
				<spring:hasBindErrors name="data">
					<p class="ErrorTitle"><spring:message code="data.errors" />:</p>
					<div class="ErrorBlock"><form:errors path="*"/></div>
				</spring:hasBindErrors>
				
				<p>
					<form:label	path="id"><spring:message code="id.skill" /></form:label>
					<form:input path="id" cssErrorClass="ErrorInput"/> <form:errors path="id" cssClass="ErrorTxt"/>		
				</p>
				
				<p>
					<form:label	path="skill"><spring:message code="skill.skill" /></form:label>
					<form:input path="skill" cssErrorClass="ErrorInput"/> <form:errors path="skill" cssClass="ErrorTxt"/>		
				</p>
				<p>	
					<form:label path="description"><spring:message code="skill.description" /></form:label>
					<form:input path="description" cssErrorClass="ErrorInput"/> <form:errors path="description" cssClass="ErrorTxt"/>	
				</p>
				
				<p><button type="submit" name="action">Submit</button></p>
	</fieldset>
	</form:form>
    </div>
     
</div>

<footer class="container-fluid text-center">
  <p>Copyright &copy; Suvi Laukkanen 2016</p>
</footer>

</body>
</html>