package exercice_web_1B_form;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// l'annotation ici est equivalente au xml dans web.xml
// urlPattern --> servletMapping (url a laquelle repond la servlet)
// initParams --> parametre cusom de configuration de notre servlet
/*@WebServlet(
		urlPatterns = { "/Figure" }, 
		initParams = { 
				@WebInitParam(name = "couleurBordDefaut", value = "#0000FF"), 
				@WebInitParam(name = "couleurCentreDefaut", value = "#FF0000")
		})*/
public class FigureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private String couleurBordDefaut;
	private String couleurCentreDefaut;

    public FigureServlet() {
        super();
    }
    
    

    // cette fonction (init) sera appelé automatiquement
    // a l'initialisation de la servlet par TOMCAT
    // 
    // la premiere fois qu'une requette arrive a destination d'une servlet
    // tomcat regarde s'il a déjà l'instance de cette servlet (non)
    // il instancie la servlet (constructeur)
    // puis il appel sa methode init pour lui passer les information de configuration
    // 	l'instance de servlet est prete a l'emploie
    //  
    //  il appele doGet ou doPost dessus pour gerer la requette HTTP
    //
    //  TOMCAT reutilise la même instance de servlet sur toute la durée de vie de la webapp
    // 
    // cela veut dire:
    //			eviter de stocker de "l'etat" dans des attributs
    //			tomcat est multithread, il peut gerer plusieurs requette HTTP en parallele
    //		cela veut dire que plusieurs thread peuvent executer les methode de votre instance
    //		de servlet EN MEME TEMPS
    //
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.couleurBordDefaut = config.getInitParameter("couleurBordDefaut");
		this.couleurCentreDefaut = config.getInitParameter("couleurCentreDefaut");
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("couleurBord", this.couleurBordDefaut);
		request.setAttribute("couleurCentre", this.couleurCentreDefaut);
		getServletContext().getRequestDispatcher("/vues/figureform.jsp")
							.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("choixfigure") == null) {
			response.sendRedirect("Figure");
			return;
		}
		int taillefigure = 0;
		int choixfigure = 0;
		String couleurBord = this.couleurBordDefaut;
		String couleurCentre = this.couleurCentreDefaut;
		try {
			taillefigure = Integer.parseInt(request.getParameter("taillefigure"));
			choixfigure = Integer.parseInt(request.getParameter("choixfigure"));
			couleurCentre = (request.getParameter("couleurCentre") == null)?
								this.couleurCentreDefaut: request.getParameter("couleurCentre");
			couleurBord = (request.getParameter("couleurBord") == null)?
					this.couleurBordDefaut: request.getParameter("couleurBord");

			String jspurl = "";
			switch(choixfigure) {
				case 0: jspurl = "/vues/triangle.jsp"; break;
				case 1: jspurl = "/vues/carre.jsp"; break;
				default: jspurl = "/vues/error.jsp"; break;
			}
			request.setAttribute("taillefigure", taillefigure);
			request.setAttribute("couleurBord", couleurBord);
			request.setAttribute("couleurCentre", couleurCentre);
			getServletContext().getRequestDispatcher(jspurl)
								.forward(request, response);
		} catch (Exception e) {
			getServletContext().getRequestDispatcher("/vues/error.jsp")
								.forward(request, response);			
		}
		
	}

}
