package fr.eni.javaee.module2;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTP1
 */
@WebServlet(urlPatterns = "/tps/nbTireAuSort/ServletTP1", initParams = {
		@WebInitParam(description = "borne inférieure tirage au sort", name = "BORNE_INF", value = "1"),	
		@WebInitParam(description = "borne supérieure tirage au sort", name = "BORNE_SUP", value = "10")
	})
public class ServletTP1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Random rand = new Random();

	
	private String borneInf; 
    private String borneSup;
    
	
	@Override
	public void init() throws ServletException {
		this.borneInf = this.getInitParameter("BORNE_INF");
		this.borneSup = this.getInitParameter("BORNE_SUP");
		super.init();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int value = rand.nextInt((Integer.parseInt(this.borneSup) - Integer.parseInt(this.borneInf)) + 1) + Integer.parseInt(this.borneInf);
		System.out.println(value);
		int nombre = Integer.parseInt(request.getParameter("nombre"));
		System.out.println(nombre);

		if (nombre == value) {
			response.sendRedirect("/PresentationApplis/tps/nbTireAuSort/victoire.html");
		} else {
			response.sendRedirect("/PresentationApplis/tps/nbTireAuSort/echec.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
