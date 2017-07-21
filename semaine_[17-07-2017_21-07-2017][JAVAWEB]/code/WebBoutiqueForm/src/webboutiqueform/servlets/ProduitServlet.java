package webboutiqueform.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webboutiqueform.dao.ProduitDAO;
import webboutiqueform.metier.Produit;

@WebServlet("/Produit")
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// le dao des produits
	private ProduitDAO produitDAO;
	
    public ProduitServlet() {
        super();
        System.out.println("servlet produit construite");
        // TODO Auto-generated constructor stub
    }

    
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("init de servlet produit");
		// recupération du dao initialisé par le BDDListener
		this.produitDAO = (ProduitDAO)getServletContext().getAttribute("produitDAO");
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet de servlet produit");
		// fournir les produits a la page jsp
		request.setAttribute("produits", produitDAO.findAll());
		// passer le controle a la page jsp
		getServletContext().getRequestDispatcher("/vues/produit/liste.jsp")
							.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// gestion de la suppression
		if (request.getParameter("produitId") == null) {
			System.out.println("pas d'id, pas de suppression...");
			response.sendRedirect("Produit");
			return;
		}
		// appeler la suppression via le DAO
		produitDAO.deleteProduit(Integer.parseInt(request.getParameter("produitId")));
		// retourner a la liste des produits
		response.sendRedirect("Produit");
	}

}
