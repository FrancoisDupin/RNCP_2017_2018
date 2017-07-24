<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edition Tache</title>
<link rel="stylesheet" type="text/css" href="vendors/bootstrap/css/bootstrap.css" />
</head>
<body>
	<div class="container">
		<h2><c:out value="${titre}" /></h2>
		<form method="post" action="TacheEdit" novalidate>
			<div class="form-group">
				<label for="description">description tache</label>
				<input type="text"
					   class="form-control"
					   id="description"
					   name="description"
					   value="<c:out value='${tache.description}' />" />
			</div>
			<div class="form-group">
				<label for="priorite">priorite tache</label>
				<select name="priorite" id="priorite">
					<c:forEach begin="1" end="5" step="1" var="pri">
						<c:if test="${pri == tache.priorite}" >
							<option selected="selected"><c:out value='${pri}' /></option>
						</c:if>
						<c:if test="${pri != tache.priorite}" >
							<option><c:out value='${pri}' /></option>
						</c:if>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="contexte">contexte tache</label>
				<input type="text"
					   class="form-control"
					   id="contexte"
					   name="contexte"
					   value="<c:out value='${tache.contexte}' />" />
			</div>
			<div class="form-group">
				<label for="finished">statut (finie ou pas)</label>
				<c:if test="${tache.finished == true}">
					<input type="checkbox"
						   class="form-control"
						   id="finished"
						   name="finished"
						   checked="checked"/>
				</c:if>
				<c:if test="${tache.finished == false}">
					<input type="checkbox"
						   class="form-control"
						   id="finished"
						   name="finished"/>
				</c:if>
			</div>
			<input type="hidden" name="id" id="id" value="<c:out value='${tache.id}' />" />
			<button type="submit" class="btn btn-primary">Sauver</button>
		</form>
	</div>
</body>
</html>