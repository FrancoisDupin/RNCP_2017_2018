<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Triangle!</title>
<jsp:include page="/vues/StyleFigure.jsp" />
</head>
<body>
	<a href="Figure">revenir au formulaire</a><br />
	<table>
		<% 
		int taille = (int)request.getAttribute("taillefigure");
		for (int ligne = 0; ligne < taille; ligne++) {
		%>
			<tr>
			<%
			for (int colonne = 0; colonne < taille - ligne; colonne++) {
				%>
				<% if (ligne == 0 || colonne == 0 || colonne == taille - ligne - 1) { %>
					<td class="bord">*</td>
				<%  } else { %>
					<td class="centre"> </td>
				<% } %>
			<%  } %>
			</tr>
		<% } %>
	</table>
</body>
</html>