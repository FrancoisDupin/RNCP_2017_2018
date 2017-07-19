<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Super calculator</title>
</head>
<body>
	<h2>finit les clacul a la main!</h2>
	<form action="Calculator" method="post" novalidate="novalidate">
		<label for="op1">operande1: </label>
		<input type="number" name="op1" id="op1">
		<label for="operateur">operation: </label>
		<select name="operateur" id="operateur">
			<option value="+" selected>+</option>
			<option value="-">-</option>
			<option value="*">*</option>
			<option value="/">/</option>
		</select>
		<label for="op2">operande2: </label>
		<input type="number" name="op2" id="op2">
		<input type="submit" value="calculer" />		
	</form>
	<%-- ici on utilise la jstl core qu'on importe  --%>
	<c:if test="${requestScope['message'] != null}">
		<p>
			message: <%= request.getAttribute("message") %>
		</p>
	</c:if>
	
	
</body>
</html>