<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib  uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
  <title><spring:message code="home"/></title>
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
      <a class="navbar-brand" href="../"><spring:message code="name"/></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="admin"><spring:message code="home"/></a></li>
        <li><a href="tools/data"><spring:message code="about"/></a></li>
        <li><a href="tools/edu"><spring:message code="edu"/></a></li>
        <li><a href="tools/work"><spring:message code="work"/></a></li>
        <li><a href="tools/skills"><spring:message code="skill"/></a></li>
        <li><a href="tools/languages"><spring:message code="lang"/></a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span><sec:authentication property="principal.username"/></a></li>
		<li><a href="../logout"><span class="glyphicon glyphicon-log-in"></span><spring:message code="logout"/></a>      
      </ul>
    </div>
  </div>
</nav>


  
<div class="container text-center">    
  <h1>CV</h1><br>
  
  <div class="row">
    <div id="d_data" class="col-sm-4" >
      <h2><a href="tools/data"><spring:message code="about"/></a></h2>
     
    </div>
    <div id="d_edu" class="col-sm-4" > 
      <h2><a href="tools/edu"><spring:message code="edu"/></a></h2>
      
    </div>
    <div id="d_work" class="col-sm-4" >
      <h2><a href="tools/work"><spring:message code="work"/></a></h2>
    </div>
  </div>
  
  <div class="row" >
    <div id="d_skill"class="col-sm-4" href="skills">
      <h2><a href="tools/skills"><spring:message code="skill"/></a></h2>
     
    </div>
    <div id ="d_lang" class="col-sm-4" > 
      <h2><a href="tools/languages"><spring:message code="lang"/></a></h2>
      
    </div>
    
  </div>
 
  
</div><br>

<footer class="container-fluid text-center">
  <p>Copyright &copy; Suvi Laukkanen 2016</p>
</footer>

</body>
</html>