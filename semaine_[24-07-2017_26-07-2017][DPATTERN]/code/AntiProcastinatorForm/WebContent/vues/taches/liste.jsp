<%@page import="antiProcastinator.dao.TacheDAO.TypeTri"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Procastinator killer</title>
<link rel="stylesheet" type="text/css" href="vendors/bootstrap/css/bootstrap.css" />
</head>
<body>
	<div class="container">
		<h2>DO IT!!!</h2>
		<span class="label label-info">
			tri: <c:out value="${tri}" />
		</span>
		<br />
		<c:if test="${filtre != null}" >
			<span class="label label-info">
				filtre: <c:out value="${filtre}" />
			</span>
		</c:if>
		<br />
		<a href="Tache?clearFilterAndTri=true" class="btn btn-default btn-xs">enlever filtre et tri</a>		
		<table class="table table-stripped">
			<thead>
				<tr>
					<th>
						<a href="Tache?tri=<%= TypeTri.AUCUN %>">ID</a>
					</th>
					<th>
						<a href="Tache?tri=<%= TypeTri.DESCRIPTION %>">DESCRIPTION</a>
					</th>
					<th>
						<a href="Tache?tri=<%= TypeTri.PRIORITE %>">PRIORITE</a>
					</th>
					<th>CONTEXTE</th>
					<th>STATUS</th>
					<th>DATE</th>
					<th>ACTIONS</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${taches}" var="t">
					<tr>
						<td><c:out value="${t.id}" /></td>
						<td><c:out value="${t.description}" /></td>
						<td><c:out value="${t.priorite}" /></td>
						<td>
							<a href="Tache?filtre=<c:out value='${t.contexte}' />"><c:out value="${t.contexte}" /></a>
						</td>
						<td><c:out value="${t.finished}" /></td>
						<td><c:out value="${t.dateCreation}" /></td>
						<td>
							<a href="TacheEdit?tacheId=<c:out value='${t.id}' />"
							   class="btn btn-primary">edition</a>
							<form method="post" action="Tache" style="display: inline-block;">
								<input type="hidden"
									   name="tacheId"
									   id="tacheId"
									   value="<c:out value='${t.id}' />">
								<button type="submit" class="btn btn-danger">supprimer</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="TacheEdit" class="btn btn-success">creer tache</a>
	</div>
</body>
</html>