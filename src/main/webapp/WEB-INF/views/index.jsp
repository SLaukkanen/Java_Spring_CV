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
  <title><spring:message code="name"/></title>
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
      <a class="navbar-brand" href="index"><spring:message code="name"/></a>
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
    <div class="col-sm-2 sidenav">
      <img class="img-responsive" style="width:100%" id="pic_me" alt="Suvi Laukkanen" src="resources/images/kuva.jpg">
    </div>
    
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
      </c:forEach>
      <hr>
      <h2><spring:message code="edu"/></h2>
      <c:forEach items="${education}" var="edu">
      	<p>${edu.school}</p>
      	<p>${edu.degree}</p>
      	<p>${edu.major}</p>
      	<p>${edu.minors}</p>
      	<p>${edu.startYear}</p>
      	<p>${edu.finishYear}</p>
      	<p>${edu.dateGraduation}</p>
      	<p>${edu.description}</p>
      </c:forEach>
      <hr>
      <h2><spring:message code="work"/></h2>
      <c:forEach items="${workexperience}" var="workexp">
      	<p>${workexp.workplace}</p>
      	<p>${workexp.position}</p>
      	<p>${workexp.startDate}</p>
      	<p>${workexp.finishDate}</p>
      	<p>${workexp.description}</p>
      </c:forEach>
      <hr>
      <h2><spring:message code="skill"/></h2>
      <c:forEach items="${skills}" var="skill">
      	<p>${skill.skill}</p>
      	<p>${skill.description}</p>
      </c:forEach>
      <hr>
      <h2><spring:message code="lang"/></h2>
      <c:forEach items="${languages}" var="lang">
      	<p>${lang.lang}</p>
      	<p>${lamg.level}</p>
      </c:forEach>
    </div>
    
     <div class="col-sm-2 sidenav">
     <p><a href="https://github.com/SLaukkanen">GitHub</a></p>
    </div>
    
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Copyright &copy; Suvi Laukkanen 2016</p>
</footer>

</body>
</html>