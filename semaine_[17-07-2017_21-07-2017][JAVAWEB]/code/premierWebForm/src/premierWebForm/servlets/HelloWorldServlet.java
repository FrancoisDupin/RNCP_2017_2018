package premierWebForm.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.parser.MediaType;

// deux maniere de declarer une servlet dans votre webapp
// soit par annotation @WebServlet
// soit via le fichier web.xml
// les servlets doivent obligatoirement hériter directement ou non
// de la classe HttpServlet
@WebServlet("/HelloWorld")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloWorldServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request,
						HttpServletResponse response) throws ServletException, IOException {
		// request contient toutes les informations sur la requette HTTP entrante
		// l'objet response sert a construire la reponse HTML (ou autre) a renvoyer
		// au navigateur
		response.setContentType("text/html");
		// recuperer un writer pour ecrire le contenu du html renvoyé
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<head><title>je suis la servlet</title></head>");
		pw.println("<body><h1>" + LocalDateTime.now() + "</h1></body>"); 
		pw.println("</html>");
		
		// ne pas oublier de fermer le printwriter
		pw.close();
	}

	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("nom") == null)
			response.sendRedirect("index.html");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<head><title>bienvenue!</title></head>");
		pw.println("<body><p>");
		pw.println("bonjour " + nom + " " + prenom + "<br />");
		pw.println("nous vous souhaitons la bienvenue sur notre mailing liste<br />");
		pw.println("les amis des chatons (cat facts)<br />");
		pw.println("vous recevrez notre spam sur " + email + "<br />");
		pw.println("<a href='index.html'>revenir au formulaire</a>");
		pw.println("</p></body>");
		pw.println("</html>");
		pw.close();
	}

}
