package fr.eni.javaee.module3;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTP2
 */
@WebServlet("/tps/shifumi/ServletTP2")
public class ServletTP2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Random rand = new Random();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int choixOpposant = rand.nextInt(3) + 1;
		String choix = request.getParameter("choix");
		request.setAttribute("choix", choix);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modules/module3/resultat.jsp");
		String resultat = "";
		String message = ""; 
		String choixOpp ="";
		
		if (choixOpposant == 1) {
			choixOpp += "PIERRE";
		} else if (choixOpposant == 2) {
			choixOpp += "FEUILLE";
		} else {
			choixOpp += "CISEAUX";
		}
		
		request.setAttribute("choixOpp", choixOpp);
		
		switch (choix) {
		case "PIERRE":
			if (choixOpposant == 1) {
				resultat += "EGALITE";
				message += "Vous avez choisi la Pierre tous les deux"; 
			} else if (choixOpposant == 2) {
				resultat += "PERDU";
				message += "La feuille recouvre la pierre";
			} else {
				resultat += "VICTOIRE";
				message += "La pierre brise les ciseaux";
			}
			break;
		case "FEUILLE":
			if (choixOpposant == 1) {
				resultat += "VICTOIRE";
				message += "La feuille recouvre la pierre";
			} else if (choixOpposant == 2) {
				resultat += "EGALITE";
				message += "Vous avez choisi la feuille tous les deux";
			} else {
				resultat += "PERDU";
				message += "Les ciseaux coupent la feuille";
			}
			break;
		case "CISEAUX":
			if(choixOpposant == 1) {
				resultat += "PERDU";
				message += "La pierre brise les ciseaux";
			} else if(choixOpposant == 2) {
				resultat += "VICTOIRE";
				message += "Les ciseaux coupent la feuille";
			} else {
				resultat += "EGALITE";
				message += "Vous avez tous les deux choisi les ciseaux"; 
			}
			break;
		}

		request.setAttribute("resultat", resultat);
		request.setAttribute("message", message);
		rd.forward(request, response);
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
