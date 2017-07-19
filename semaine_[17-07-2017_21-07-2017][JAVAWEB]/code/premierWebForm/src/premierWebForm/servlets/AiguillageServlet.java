package premierWebForm.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AiguillageServlet
 */
@WebServlet("/Aiguillage")
public class AiguillageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AiguillageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext()
			.getRequestDispatcher("/vues/formulaire.jsp")
			.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("nom") == null)
			response.sendRedirect("Aiguillage"); // nous renvoie vers le get
		
		// preparer les données
		String nom = request.getParameter("nom");
		String email = request.getParameter("email");
		String commentaire = request.getParameter("commentaire");
		int note = Integer.parseInt(request.getParameter("note"));

		// setAttribute permet d'attacher n'importe objet donnée sous un nom choisi
		// a la requette, pour que par exemple la page jsp puisse en faire usage
		
		request.setAttribute("nom", nom);
		request.setAttribute("email", email);
		request.setAttribute("commentaire", commentaire.replaceAll("\n", "<br />"));
		// choisir la vue
		if (note <= 0) {
			getServletContext().getRequestDispatcher("/vues/probleme.jsp")
							   .forward(request, response);
		}
		else if (note <= 2  ) {
			getServletContext().getRequestDispatcher("/vues/merci.jsp")
			   .forward(request, response);
		}
		else {
			getServletContext().getRequestDispatcher("/vues/goldMember.jsp")
			   .forward(request, response);			
		}
	}

}
