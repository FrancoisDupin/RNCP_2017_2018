<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>merci</title>
</head>
<body>
	<h2>merci de votre commentaire <%= request.getAttribute("nom") %></h2>
	<p>
		nous avons bien enregistré votre commentaire
		vous etes inscrit sur notre mailing liste a l'adresse <%= request.getAttribute("email") %>
		continuez la navigation sur notre site ou saisissez
		un nouveau commentaire <a href="Aiguillage">ici</a>
	</p>
</body>
</html>