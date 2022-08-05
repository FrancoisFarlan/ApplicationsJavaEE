package fr.eni.javaee.module2;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTP1
 */
@WebServlet("/tps/nbTireAuSort/ServletTP1")
public class ServletTP1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Random rand = new Random();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int value = rand.nextInt(10) + 1;
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
