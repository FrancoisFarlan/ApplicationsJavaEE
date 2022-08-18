package fr.eni.javaee.module6.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.module6.BusinessException;
import fr.eni.javaee.module6.bll.ListeCourseManager;
import fr.eni.javaee.module6.bo.ListeCourse;

/**
 * Servlet implementation class Panier
 */
@WebServlet("/tps/listeCourses/Panier")
public class Panier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Je lis les paramètres
		cocherDecocher(request, response);
		
		int idListeCourse=0;
		List<Integer> listeCodesErreur=new ArrayList<>();
		try
		{
			idListeCourse = Integer.parseInt(request.getParameter("id"));
		}
		catch(NumberFormatException ex)
		{
			ex.printStackTrace();
			listeCodesErreur.add(CodesResultatServlets.FORMAT_ID_LISTE_ERREUR);
		}
			
		if(listeCodesErreur.size()>0)
		{
			request.setAttribute("listeCodesErreur",listeCodesErreur);
		}
		else
		{
			//J'ai un id au bon format, je récupère la liste associée eventuelle
			ListeCourseManager listeCourseManager = new ListeCourseManager();
			ListeCourse listeCourse;
			try {
				listeCourse = listeCourseManager.selectionnerListe(idListeCourse);
				request.setAttribute("listeCourse", listeCourse);
			} catch (BusinessException ex) {
				ex.printStackTrace();
				request.setAttribute("listeCodesErreur", ex.getListeCodesErreur());
			}
			
		}
		request.getRequestDispatcher("/WEB-INF/modules/module6/panier.jsp").forward(request, response);
	}

	private void cocherDecocher(HttpServletRequest request, HttpServletResponse response) {
		ListeCourseManager listeCourseManager = new ListeCourseManager();
		if(request.getParameter("id_article")!=null)
		{
			try
			{
				int idArticle = Integer.parseInt(request.getParameter("id_article"));
				if(request.getParameter("coche")!=null)
				{
					listeCourseManager.cocherArticle(idArticle);
				}
				else
				{
					listeCourseManager.decocherArticle(idArticle);
				}
			}
			catch(BusinessException ex)
			{
				ex.printStackTrace();
				request.setAttribute("listeCodesErreur", ex.getListeCodesErreur());
			}
		}
		else if(request.getParameter("clear")!=null)
		{
			try
			{
				int idListeCourse = Integer.parseInt(request.getParameter("id"));
				listeCourseManager.decocherListe(idListeCourse);
			}
			catch(BusinessException ex)
			{
				ex.printStackTrace();
				request.setAttribute("listeCodesErreur", ex.getListeCodesErreur());
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
