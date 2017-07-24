package antiProcastinator.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import antiProcastinator.dao.TacheDAO;
import antiProcastinator.metier.Tache;

/**
 * Servlet implementation class TacheEditServlet
 */
@WebServlet("/TacheEdit")
public class TacheEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TacheDAO tacheDAO;
   
    public TacheEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		this.tacheDAO = (TacheDAO)getServletContext()
						.getAttribute(TacheDAO.DAO_CONTEXT_KEY);
	}
    // affichage formulaire
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("tacheId") == null) {
			request.setAttribute("titre", "creation tache");
			request.setAttribute("tache", new Tache());
		}
		else {
			int tid = Integer.parseInt(request.getParameter("tacheId"));
			Tache t = tacheDAO.findById(tid);
			if (t == null) {
				response.sendRedirect("Tache");
				return;
			}
			request.setAttribute("titre", "edition tache");
			request.setAttribute("tache", t);
		}
		getServletContext().getRequestDispatcher("/vues/taches/form.jsp")
						   .forward(request, response);
			
	}

	//traitement de la sauvegarde
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("id") == null) {
			response.sendRedirect("Tache");
			return;
		}
		// attention, gestion particuliere de finished
		// car une checkbox en html ne transmet rien quand non
		// cochée, et "on" quand cochée
		Tache t = new Tache(Integer.parseInt(request.getParameter("id")),
							request.getParameter("description"),
							Integer.parseInt(request.getParameter("priorite")),
							request.getParameter("contexte"),
							"on".equals(request.getParameter("finished")),
							null);
		tacheDAO.saveTache(t);
		response.sendRedirect("Tache");
	}

}
