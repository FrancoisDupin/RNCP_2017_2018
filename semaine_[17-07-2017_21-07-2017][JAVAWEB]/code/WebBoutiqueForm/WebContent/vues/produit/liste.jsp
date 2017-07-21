<%@page import="webboutiqueform.metier.Produit"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des produits</title>
<link rel="stylesheet" type="text/css" href="vendors/bootstrap/css/bootstrap.css" />
</head>
<body>
	<div class="container">
		<h2>liste des produits</h2>
		<table class="table table-stripped">
			<thead>
				<tr><th>ID</th><th>NOM</th><th>PRIX</th><th>POIDS</th><th>ACTIONS</th></tr>
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
						<td>
							<a href="ProduitEdit?produitId=<%= p.getId() %>"
							   class="btn btn-primary">edition</a>
							<form method="post" action="Produit" style="display: inline-block;">
								<input type="hidden"
									   name="produitId"
									   id="produitId"
									   value="<%= p.getId() %>">
								<button type="submit" class="btn btn-danger">supprimer</button>
							</form>
						</td>
					</tr>
				<%}	%>
			</tbody>
		</table>
		<a href="ProduitEdit" class="btn btn-success">creer produit</a>
	</div>
</body>
</html>