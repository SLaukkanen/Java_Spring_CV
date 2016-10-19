<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title>CV</title>
<link rel="stylesheet" type="text/css" href="../resources/styles/common.css">
</head>	
<body>
	 
	<h1>
			<spring:message code="cv.heading"/>
	</h1>
	<table>
	<tr>		
		<c:out value="${data.firstName}" default="-----"/> 
			<c:out value="${data.lastName}" default="-----"/>	</tr>
		<tr>
			<td>Testaa</td>
			<td><fmt:formatDate pattern="dd.MM.yyyy" value="${data.birthDay}"/>
			</td>
		</tr>
		<tr>
			<td>Lisää</td>
			<td><c:out value="${data.email}" default="-----"/></td>
		</tr>
		
	</table>
	
</body>
</html>