package fr.eni.javaee.module4.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.module4.BusinessException;
import fr.eni.javaee.module4.bll.RepasManager;
import fr.eni.javaee.module4.bo.Aliment;
import fr.eni.javaee.module4.bo.Repas;

/**
 * Servlet implementation class ServletAjoutRepas
 */
@WebServlet("/tps/suiviRepas/ServletAjoutRepas")
public class ServletAjoutRepas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modules/module4/ajout.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		LocalDate date = null;
		LocalTime time = null;

		try {
			try {
				date = LocalDate.parse(request.getParameter("date")); // DateTimeParseException

			} catch (DateTimeParseException ex) {
				List<Integer> listeCodesErreur = new ArrayList<>();
				listeCodesErreur.add(CodesResultatServlets.FORMAT_DATE_REPAS_ERREUR);
				request.setAttribute("listeErreurs", listeCodesErreur);
				// this.doGet(request, response);
			}

			try {
				time = LocalTime.parse(request.getParameter("heure"));
			} catch (DateTimeParseException ex) {
				List<Integer> listeCodesErreur = new ArrayList<>();
				listeCodesErreur.add(CodesResultatServlets.FORMAT_HEURE_REPAS_ERREUR);
				request.setAttribute("listeErreurs", listeCodesErreur);
				//this.doGet(request, response);
			}

			String aliments[] = request.getParameter("repas").split(",");

			Repas repas = new Repas(date, time);

			for (int i = 0; i < aliments.length; i++) {
				if (!aliments[i].isBlank()) {
					Aliment a = new Aliment(aliments[i]);
					repas.addAliment(a);
				}

			}

			RepasManager repasManager = new RepasManager();
			Repas repasAjoute = null;

			repasAjoute = repasManager.ajouterRepas(repas);

			RequestDispatcher rd = request.getRequestDispatcher("/tps/suiviRepas/ServletVisualiserRepas");
			rd.forward(request, response);

		} catch (BusinessException ex) {
			request.setAttribute("listeErreurs", ex.getListeCodesErreur());
			this.doGet(request, response);
		}

	}

}
