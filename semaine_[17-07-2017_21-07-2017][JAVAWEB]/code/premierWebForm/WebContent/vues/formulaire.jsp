<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>laissez nous votre commentaire</title>
</head>
<body>
	<h2>votre commentaire</h2>
	<form action="Aiguillage" method="post">
		<table>
			<tr>
				<td><label for="nom">votre nom</label></td>
				<td><input type="text" name="nom" id="nom" /></td>
			</tr>
			<tr>
				<td><label for="email">votre email</label></td>
				<td><input type="text" name="email" id="email" /></td>
			</tr>
			<tr>
				<td><label for="commentaire">votre commentaire</label></td>
				<td>
					<textarea name="commentaire" id="commentaire" cols="50" rows="5"></textarea>
				</td>
			</tr>
			<tr>
				<td><label for="note">votre appreciation</label></td>
				<td>
					<select name="note" id="note">
						<option value="0">pas content</option>
						<option value="1">ca va</option>
						<option value="2">tres bien</option>
						<option value="3" selected>parfait</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="envoyer" /></td>
			</tr>
		</table>
	
	</form>
</body>
</html>