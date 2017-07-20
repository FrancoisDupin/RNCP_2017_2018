<%@page import="webboutiqueform.metier.Produit"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des produits</title>
</head>
<body>
	<h2>liste des produits</h2>
	<table border="1">
		<thead>
			<tr><th>ID</th><th>NOM</th><th>PRIX</th><th>POIDS</th></tr>
		</thead>
		<tbody>
			<%
			List<Produit> produits = (List<Produit>)request.getAttribute("produits");
			for(Produit p : produits) {
				%>
				<tr>
					<td><%= p.getId() %></td>
					<td><%= p.getNom() %></td>
					<td><%= p.getPrix() %></td>
					<td><%= p.getPoids() %></td>
				</tr>
			<%}	%>
		</tbody>
	</table>
</body>
</html>