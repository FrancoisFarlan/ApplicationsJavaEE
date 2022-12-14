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
 * Servlet implementation class NouvelleListe
 */
@WebServlet(
		urlPatterns= {
						"/nouvelle",
						"/supprimer"
		})
public class NouvelleListe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getServletPath().equals("/nouvelle"))
		{
			//Je lis les paramètres
			int idListeCourse=0;
			List<Integer> listeCodesErreur=new ArrayList<>();
			
			idListeCourse = lireParametreId(request, listeCodesErreur);
				
			if(listeCodesErreur.size()>0)
			{
				request.setAttribute("listeCodesErreur",listeCodesErreur);
			}
			else if(idListeCourse>0)
			{
				//J'ai un id au bon format, je récupère la liste associée eventuelle
				ListeCourseManager listeCourseManager = new ListeCourseManager();
				chargerListeCourse(request, listeCourseManager);
				
			}
		}
		else if(request.getServletPath().equals("/supprimer"))
		{
			ListeCourseManager listeCourseManager=new ListeCourseManager();
			//parametre id : id de la liste course
			//parametre id_article : id de l'article à supprimer
			List<Integer> listeCodesErreur=new ArrayList<>();
			int idArticle = this.lireParametreIdArticle(request, listeCodesErreur);
			if(listeCodesErreur.size()>0)
			{
				request.setAttribute("listeCodesErreur",listeCodesErreur);
			}
			else
			{
				try {
					listeCourseManager.supprimerArticle(idArticle);
				} catch (BusinessException ex) {
					ex.printStackTrace();
					request.setAttribute("listeCodesErreur", ex.getListeCodesErreur());
				}
			}
			chargerListeCourse(request, listeCourseManager);
		}
		
		request.getRequestDispatcher("/WEB-INF/modules/module6/nouvelle_liste.jsp").forward(request, response);
	}

	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//Je vais faire le traitement pour 
		//ajouter une nouvelle liste (avec son article)
		//ou ajouter un nouvel article à une liste existante
		if(request.getParameter("id")!=null)
		{
			ajouterArticleAListeExistante(request,response);
		}
		else
		{
			ajouterNouvelleListeAvecSonPremierArticle(request, response);
		}
		
		request.getRequestDispatcher("/WEB-INF/modules/module6/nouvelle_liste.jsp").forward(request, response);
	}
	
	private void ajouterArticleAListeExistante(HttpServletRequest request, HttpServletResponse response) {
		//Je lis les paramètres
		int idListeCourse=0;
		String nomArticle=null;
		List<Integer> listeCodesErreur=new ArrayList<>();
		
		ListeCourseManager listeCourseManager = new ListeCourseManager();
		
		idListeCourse=lireParametreId(request, listeCodesErreur);
		nomArticle = lireParametreNomArticle(request, listeCodesErreur);
		
		if(listeCodesErreur.size()>0)
		{
			request.setAttribute("listeCodesErreur",listeCodesErreur);
		}
		else
		{
			try {
				listeCourseManager.ajouterArticle(idListeCourse,nomArticle);
			} catch (BusinessException ex) {
				ex.printStackTrace();
				request.setAttribute("listeCodesErreur",ex.getListeCodesErreur());
			}
		}
		//J'ai un id au bon format, je récupère la liste associée eventuelle
		chargerListeCourse(request, listeCourseManager);
	}
	
	private void ajouterNouvelleListeAvecSonPremierArticle(HttpServletRequest request, HttpServletResponse response) {
		//Je lis les paramètres
		String nomListe=null;
		String nomArticle=null;
		List<Integer> listeCodesErreur=new ArrayList<>();

		nomListe=lireParametreNomListe(request, listeCodesErreur);
		nomArticle = lireParametreNomArticle(request, listeCodesErreur);
		
		if(listeCodesErreur.size()>0)
		{
			request.setAttribute("listeCodesErreur",listeCodesErreur);
		}
		else
		{
			ListeCourseManager listeCourseManager = new ListeCourseManager();
			try {
				ListeCourse listeCourse = listeCourseManager.ajouterListeEtArticle(nomListe,nomArticle);
				listeCourse = listeCourseManager.selectionnerListe(listeCourse.getId());
				request.setAttribute("listeCourse", listeCourse);
			} catch (BusinessException ex) {
				ex.printStackTrace();
				request.setAttribute("listeCodesErreur",ex.getListeCodesErreur());
			}
		}
	}
	
	
	private int lireParametreId(HttpServletRequest request, List<Integer> listeCodesErreur) {
		int idListeCourse=0;
		try
		{
			if(request.getParameter("id")!=null)
			{
				idListeCourse = Integer.parseInt(request.getParameter("id"));
			}
		}
		catch(NumberFormatException ex)
		{
			ex.printStackTrace();
			listeCodesErreur.add(CodesResultatServlets.FORMAT_ID_LISTE_ERREUR);
		}
		return idListeCourse;
	}
	
	private int lireParametreIdArticle(HttpServletRequest request, List<Integer> listeCodesErreur) {
		int idListeCourse=0;
		try
		{
			if(request.getParameter("id_article")!=null)
			{
				idListeCourse = Integer.parseInt(request.getParameter("id_article"));
			}
		}
		catch(NumberFormatException ex)
		{
			ex.printStackTrace();
			listeCodesErreur.add(CodesResultatServlets.FORMAT_ID_ARTICLE_ERREUR);
		}
		return idListeCourse;
	}
	
	private String lireParametreNomArticle(HttpServletRequest request, List<Integer> listeCodesErreur) {
		String nomArticle;
		nomArticle = request.getParameter("nom_article");
		if(nomArticle==null || nomArticle.trim().equals(""))
		{
			listeCodesErreur.add(CodesResultatServlets.NOM_ARTICLE_OBLIGATOIRE);
		}
		return nomArticle;
	}
	
	private String lireParametreNomListe(HttpServletRequest request, List<Integer> listeCodesErreur) {
		String nomListe;
		nomListe = request.getParameter("nom_liste");
		if(nomListe==null || nomListe.trim().equals(""))
		{
			listeCodesErreur.add(CodesResultatServlets.NOM_LISTE_OBLIGATOIRE);
		}
		return nomListe;
	}
	
	private void chargerListeCourse(HttpServletRequest request, ListeCourseManager listeCourseManager) {
		ListeCourse listeCourse;
		try {
			int idListeCourse = lireParametreId(request, null);
			listeCourse = listeCourseManager.selectionnerListe(idListeCourse);
			request.setAttribute("listeCourse", listeCourse);
		} catch (BusinessException ex) {
			ex.printStackTrace();
			request.setAttribute("listeCodesErreur", ex.getListeCodesErreur());
		}
	}

}
