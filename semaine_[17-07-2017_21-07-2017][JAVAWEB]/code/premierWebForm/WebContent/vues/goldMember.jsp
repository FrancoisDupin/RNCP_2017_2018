<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>merci beaucoup</title>
</head>
<body>
	<h2>merci infiniment de votre commentaire <%= request.getAttribute("nom") %></h2>
	<p>
		nous avons bien enregistré votre magnifique commentaire
		<p style="border: 2px dashed blue;">
			<%= request.getAttribute("commentaire") %>
		<p>
		sachez qu'au bout de 5 commentaires saisie, vous avez
		une chance de gagner un lot!!
		<a href="Aiguillage">essayer!</a> 
	</p>
</body>
</html>