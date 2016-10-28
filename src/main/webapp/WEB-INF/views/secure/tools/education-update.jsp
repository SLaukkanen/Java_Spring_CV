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
  <title><spring:message code="edu.update"/></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="resources/styles/style.css">
  <link rel="stylesheet" type="text/css" href="resources/styles/form.css"/>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
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
      <a class="navbar-brand" href="../../../../"><spring:message code="name"/></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="../../../admin"><spring:message code="home"/></a></li>
        <li><a href="../../data"><spring:message code="about"/></a></li>
        <li><a href="../../edu"><spring:message code="edu"/></a></li>
        <li><a href="../../work"><spring:message code="work"/></a></li>
        <li><a href="../../skills"><spring:message code="skill"/></a></li>
        <li><a href="../../languages"><spring:message code="lang"/></a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span><sec:authentication property="principal.username"/></a></li>
		<li><a href="../../../../logout"><span class="glyphicon glyphicon-log-in"></span><spring:message code="logout"/></a>      
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
      
    </div>
      
    <div class="col-sm-8 text-left"> 
    <form:form modelAttribute="education" action="../save_update" method="post">
	<fieldset>
		<legend><spring:message code="changeinfo" /></legend>
				
				<spring:hasBindErrors name="education">
					<p class="ErrorTitle"><spring:message code="edu.errors" />:</p>
					<div class="ErrorBlock"><form:errors path="*"/></div>
				</spring:hasBindErrors>
				
				<p>
					<form:label	path="school"><spring:message code="edu.school" /></form:label>
					<form:input value="${education.school}" path="school" cssErrorClass="ErrorInput"/> <form:errors path="school" cssClass="ErrorTxt"/>		
				</p>
				<p>	
					<form:label path="degree"><spring:message code="edu.degree" /></form:label>
					<form:input value="${education.degree}" path="degree" cssErrorClass="ErrorInput"/> <form:errors path="degree" cssClass="ErrorTxt"/>	
				</p>
				<p>
					<form:label	path="major"><spring:message code="edu.major" /></form:label>
					<form:input value="${education.major}" path="major" cssErrorClass="ErrorInput"/> <form:errors path="major" cssClass="ErrorTxt"/>		
				</p>
				<p>	
					<form:label path="minors"><spring:message code="edu.minors" /></form:label>
					<form:input value="${education.minors}" path="minors" cssErrorClass="ErrorInput"/> <form:errors path="minors" cssClass="ErrorTxt"/>	
				</p>
				<p>	
					<form:label path="startYear"><spring:message code="edu.startyear" /></form:label>
					<form:input value="${education.startYear}" path="startYear" cssErrorClass="ErrorInput"/> <form:errors path="startYear" cssClass="ErrorTxt"/>	
				</p>
				<p>	
					<form:label path="finishYear"><spring:message code="edu.finishyear" /></form:label>
					<form:input value="${education.finishYear}" path="finishYear" cssErrorClass="ErrorInput"/> <form:errors path="finishYear" cssClass="ErrorTxt"/>	
				</p>
				<p>	
					<form:label path="dateGraduation"><spring:message code="edu.dategraduation" /></form:label><br/>
					<form:input value="${education.dateGraduation}" path="dateGraduation" cssErrorClass="ErrorInput"/> <form:errors path="dateGraduation" cssClass="ErrorTxt"/>	
				</p>
				<p>	
					<form:label path="description"><spring:message code="description" /></form:label><br/>
					<form:input value="${education.description}" path="description" cssErrorClass="ErrorInput"/> <form:errors path="description" cssClass="ErrorTxt"/>	
				</p>	
				
				<p><button type="submit"><spring:message code="submit" /></button></p>
	</fieldset>
	</form:form>
    </div>
   </div>
   <div class="col-sm-2 sidenav">
    </div>
     
</div>

<footer class="container-fluid text-center">
  <p>Copyright &copy; Suvi Laukkanen 2016</p>
</footer>

</body>
</html>