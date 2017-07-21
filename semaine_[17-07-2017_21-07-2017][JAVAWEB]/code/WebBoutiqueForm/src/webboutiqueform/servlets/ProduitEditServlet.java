package webboutiqueform.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webboutiqueform.dao.ProduitDAO;
import webboutiqueform.metier.Produit;


@WebServlet("/ProduitEdit")
public class ProduitEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ProduitDAO produitDAO;
	
    public ProduitEditServlet() {
        super();
    }
    
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.produitDAO = (ProduitDAO)getServletContext().getAttribute("produitDAO");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// si pas d'id passé en parametre, c'est une demande de formulaire de création
		if (request.getParameter("produitId") == null ) {
			// produit avec valeur par defaut
			Produit p = new Produit(0, "produit...", 0.01, 0.01);
			request.setAttribute("produit", p);
			// titre dans la page
			request.setAttribute("titre", "creation produit");
		}
		else {
			// on edite un produit existant
			Produit p = produitDAO.findOne(Integer.parseInt(request.getParameter("produitId")));
			if (p == null) {
				// produit inconnu, impossible d'editer, on revient a la liste
				response.sendRedirect("Produit");
				return;
			}
			request.setAttribute("produit", p);
			request.setAttribute("titre", "edition produit");
		}
		
		getServletContext().getRequestDispatcher("/vues/produit/form.jsp")
						   .forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("id") == null) {
			// pas de formulaire, on retourne a la liste
			response.sendRedirect("Produit");
			return;
		}
		// instancier un produit a partir du formulaire soumis
		Produit p = new Produit(Integer.parseInt(request.getParameter("id")),
					request.getParameter("nom"),
					Double.parseDouble(request.getParameter("prix")),
					Double.parseDouble(request.getParameter("poids")));
		//sauver le produit en base
		produitDAO.saveProduit(p);
		
		// retourner a la liste
		response.sendRedirect("Produit");
	}

}
