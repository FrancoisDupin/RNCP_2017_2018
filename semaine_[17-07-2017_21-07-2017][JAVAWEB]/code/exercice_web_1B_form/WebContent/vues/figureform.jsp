<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Figures!</title>
</head>
<body>
	<h2>choisissez la figure a dessiner</h2>
	<form action="Figure" method="post" novalidate>
		<table>
			<tr>
				<td><label for="choixfigure">choisissez votre figure</label></td>
				<td>
					<select name="choixfigure" id="choixfigure">
						<option value="0" selected>triangle</option>
						<option value="1">carré</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><label for="taillefigure">choisissez la taille</label></td>
				<td>
					<input type="number" name="taillefigure" id="taillefigure" value="5"/>
				</td>
			</tr>
			<tr>
				<td><label for="couleurBord">choisissez couleur bord</label></td>
				<td>
					<input type="color"
						   name="couleurBord"
						   id="couleurBord"
						   value="<%= request.getAttribute("couleurBord") %>"/>
				</td>
			</tr>
			<tr>
				<td><label for="couleurCentre">choisissez couleur centre</label></td>
				<td>
					<input type="color"
						   name="couleurCentre"
						   id="couleurCentre"
						   value="<%= request.getAttribute("couleurCentre") %>"/>
						   
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="dessiner"></td>
			</tr>
		</table>
	</form>
</body>
</html>