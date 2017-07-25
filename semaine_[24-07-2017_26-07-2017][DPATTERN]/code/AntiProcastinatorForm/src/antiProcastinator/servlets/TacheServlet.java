package antiProcastinator.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import antiProcastinator.dao.TacheDAO;
import antiProcastinator.dao.TacheDAO.TypeTri;


@WebServlet("/Tache")
public class TacheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private TacheDAO tacheDAO;
 
    public TacheServlet() {
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



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (request.getParameter("clearFilterAndTri") != null) {
			System.out.println("effacement tri et filtre");
			session.removeAttribute("tri");
			session.removeAttribute("filtre");
		}
		/*
		 * 
		 * gestion du tri
		 * 
		 */
		TypeTri tri = TypeTri.AUCUN;
		// recuperer le tri mémorisé s'il existe
		if (session.getAttribute("tri") == null) {
			System.out.println("pas de recuperation tri dans session");
			session.setAttribute("tri", TypeTri.AUCUN);
		}
		else {
			System.out.println("recuperation tri dans session");
			tri = (TypeTri)session.getAttribute("tri");
		}
		// priorite a un nouveau chois de tri s'il y en a un
		if (request.getParameter("tri") != null)
			tri = TypeTri.valueOf(request.getParameter("tri"));
		
		session.setAttribute("tri", tri);
		/*
		 * 
		 * gestion du filtre 
		 * 
		 */
		String filtre = null;
		// recuperer le tri mémorisé s'il existe
		if (session.getAttribute("filtre") == null) {
			System.out.println("pas de recuperation filtre dans session");
			session.setAttribute("filtre", null);
		}
		else {
			System.out.println("recuperation filtre dans session");
			filtre = (String)session.getAttribute("filtre");
		}
		// priorite a un nouveau choix de filtre s'il y en a un
		if (request.getParameter("filtre") != null)
			filtre = request.getParameter("filtre");

		// on memorise le filtre choisi pour la prochaine fois
		session.setAttribute("filtre", filtre);
		
		
		request.setAttribute("taches", tacheDAO.findAll(tri, filtre));
		getServletContext().getRequestDispatcher("/vues/taches/liste.jsp")
							.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
