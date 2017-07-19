<%@ page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bienvenue sous jsp</title>
</head>
<body>
<%-- 
	les balises <%= %> contienne une expression java
	ce que cette expression renvoie sera automatiquement inserer
	a la place de la balise dans le html résultant 
 --%>
<h2>nous somme le <%= LocalDateTime.now() %> </h2>
<p>
	fantastique (enfin je pense, peut etre...) 2 + 2 = <%= 2+2 %>
</p>
<%--
	les balises <%   %> contienne un ensemble d'instruction java (du code)
	celui-ci sera executé et si, dans ce code java, on ecris dans la page jsp
	cela remplacera la balise dans le html généré
 --%>
<p>
	<%
		// dans ce code, on a acces a des objets implicites
		// entre autre out -> un pintwriter dans la page jsp
		out.println("je suis généré par le code java");
		out.println("<ul>");
		for (int i = 1; i < 5; i++) {
			out.println("<li> i = " + i + "</li>");
		}
		out.println("</ul>");
	%>
</p>
<p>
	<ul>
		<% for(int i = 1; i < 10; i++) { %>
		<li>i = <%= i %></li>
		<% } %>
	</ul>
</p>

</body>
</html>