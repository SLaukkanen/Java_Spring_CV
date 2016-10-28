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
    <form:form modelAttribute="education" action="/edu/save_new" method="post">
	<fieldset>
		<legend><spring:message code="edu.legend" /></legend>
				
				<spring:hasBindErrors name="education">
					<p class="ErrorTitle"><spring:message code="edu.errors" />:</p>
					<div class="ErrorBlock"><form:errors path="*"/></div>
				</spring:hasBindErrors>
				
				<p>
					<form:label	path="firstName"><spring:message code="data.firstname" /></form:label>
					<form:input path="firstName" cssErrorClass="ErrorInput"/> <form:errors path="firstName" cssClass="ErrorTxt"/>		
				</p>
				<p>	
					<form:label path="lastName"><spring:message code="data.lastname" /></form:label>
					<form:input path="lastName" cssErrorClass="ErrorInput"/> <form:errors path="lastName" cssClass="ErrorTxt"/>	
				</p>
				<p>
					<form:label	path="birthDay"><spring:message code="data.birthday" /></form:label>
					<form:input path="birthDay" cssErrorClass="ErrorInput"/> <form:errors path="birthDay" cssClass="ErrorTxt"/>		
				</p>
				<p>	
					<form:label path="email"><spring:message code="data.email" /></form:label>
					<form:input path="email" cssErrorClass="ErrorInput"/> <form:errors path="email" cssClass="ErrorTxt"/>	
				</p>
				<p>	
					<form:label path="address"><spring:message code="data.address" /></form:label>
					<form:input path="address" cssErrorClass="ErrorInput"/> <form:errors path="address" cssClass="ErrorTxt"/>	
				</p>
				<p>	
					<form:label path="areaCode"><spring:message code="data.areacode" /></form:label>
					<form:input path="areaCode" cssErrorClass="ErrorInput"/> <form:errors path="areaCode" cssClass="ErrorTxt"/>	
				</p>
				<p>	
					<form:label path="city"><spring:message code="data.city" /></form:label><br/>
					<form:input path="city" cssErrorClass="ErrorInput"/> <form:errors path="city" cssClass="ErrorTxt"/>	
				</p>
				<p>	
					<form:label path="phone"><spring:message code="data.phone" /></form:label><br/>
					<form:input path="phone" cssErrorClass="ErrorInput"/> <form:errors path="phone" cssClass="ErrorTxt"/>	
				</p>
				<p>	
					<form:label path="heading"><spring:message code="data.heading" /></form:label><br/>
					<form:input path="heading" cssErrorClass="ErrorInput"/> <form:errors path="heading" cssClass="ErrorTxt"/>	
				</p>
				<p>	
					<form:label path="summary"><spring:message code="data.summary" /></form:label><br/>
					<form:input path="summary" cssErrorClass="ErrorInput"/> <form:errors path="summary" cssClass="ErrorTxt"/>	
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