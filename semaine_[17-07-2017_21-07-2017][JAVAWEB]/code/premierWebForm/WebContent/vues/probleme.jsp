<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>probleme</title>
</head>
<body>
	<h2>un probleme est survenu</h2>
	<p>
		
		nous n'avons malheureusement pas pu enregistrer votre commentaire
		cela ne marchera probablement pas si vous reesayez, <%= request.getAttribute("nom") %>
		cliquez ici pour aller <a href="http://www.google.com">ailleurs</a> 
	</p>
</body>
</html>