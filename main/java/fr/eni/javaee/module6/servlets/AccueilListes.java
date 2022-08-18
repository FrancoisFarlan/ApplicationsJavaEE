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
 * Servlet implementation class AccueilListes
 */
@WebServlet("/tps/listeCourses/AccueilListes")
public class AccueilListes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<ListeCourse> listesCourses = new ArrayList<>();
		ListeCourseManager manager = new ListeCourseManager();
		List<Integer> listeCodesErreur=new ArrayList<>();
		
		int idListeCourse=0;
		if(request.getParameter("supprimer")!=null)
		{
			idListeCourse = this.lireParametreSupprimer(request, listeCodesErreur);
		}
		if(listeCodesErreur.size()>0)
		{
			request.setAttribute("listeCodesErreur",listeCodesErreur);
		}
		else
		{
			try {
				manager.supprimerListeCourse(idListeCourse);
			} catch (BusinessException e) {
				request.setAttribute("listeCodesErreur",e.getListeCodesErreur());
				e.printStackTrace();
			}
		}
		
		try {
			listesCourses = manager.selectionnerListes();
			request.setAttribute("listesCourses", listesCourses);
		} catch (BusinessException ex) {
			ex.printStackTrace();
			request.setAttribute("listeCodesErreur",ex.getListeCodesErreur());
		}
		
		request.setAttribute("listesCourses", listesCourses);
		request.getRequestDispatcher("/WEB-INF/modules/module6/accueil.jsp").forward(request, response);
	
	}
	
	private int lireParametreSupprimer(HttpServletRequest request, List<Integer> listeCodesErreur) {
		int idListeCourse=0;
		try
		{
			if(request.getParameter("supprimer")!=null)
			{
				idListeCourse = Integer.parseInt(request.getParameter("supprimer"));
			}
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
			listeCodesErreur.add(CodesResultatServlets.FORMAT_ID_LISTE_ERREUR);
		}
		return idListeCourse;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		doGet(request, response);
	
	}

}
