package exercice_web_1A_form.servlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalaculatorServlet
 */
@WebServlet("/Calculator")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/vues/calcform.jsp")
						   .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("operateur") == null)
		{
			response.sendRedirect("Calculator");
			return;
		}
		double op1 = 0.0;
		double op2 = 0.0;
		String operateur = request.getParameter("operateur");
		String message = "";
		try {
			op1 = Double.parseDouble(request.getParameter("op1"));
			op2 = Double.parseDouble(request.getParameter("op2"));
			switch(operateur) {
				case "+":
					message = "addition de " + op1 + " et " + op2 + " = " + (op1 + op2);
					break;
				case "-":
					message = "soustraction de " + op2 + " de " + op1 + " = " + (op1 - op2);
					break;
				case "*":
					message = "multiplication de " + op1 + " par " + op2 + " = " + (op1 * op2);
					break;
				case "/":
					message = "division de " + op1 + " par " + op2 + " = " + (op1 / op2);
					break;
			}
			request.setAttribute("message", message);
		} catch (Exception e) {
			request.setAttribute("message", "probleme lors du calcul " + e.getMessage());
		}
		getServletContext().getRequestDispatcher("/vues/calcform.jsp")
		.forward(request, response);
		
	}

}
