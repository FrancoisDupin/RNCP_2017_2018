package premierWebForm.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TraditionalServlet extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest request,
						HttpServletResponse response) throws ServletException, IOException {
		// request contient toutes les informations sur la requette HTTP entrante
		// l'objet response sert a construire la reponse HTML (ou autre) a renvoyer
		// au navigateur
		response.setContentType("text/html");
		// recuperer un writer pour ecrire le contenu du html renvoyé
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<head><title>je suis la servlet traditionalle</title></head>");
		pw.println("<body><h1> tradition, mais java 8! " + LocalDateTime.now() + "</h1></body>"); 
		pw.println("</html>");
		
		// ne pas oublier de fermer le printwriter
		pw.close();
	}
	
}
