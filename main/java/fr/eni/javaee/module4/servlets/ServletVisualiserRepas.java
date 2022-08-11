package fr.eni.javaee.module4.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.module4.bll.RepasManager;
import fr.eni.javaee.module4.bo.Repas;
import fr.eni.javaee.module4.dal.ConnectionProvider;

/**
 * Servlet implementation class ServletVisualiserRepas
 */
@WebServlet("/tps/suiviRepas/ServletVisualiserRepas")
public class ServletVisualiserRepas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Repas> listeRepas = new ArrayList<>();
		RepasManager repasManager = new RepasManager();
		listeRepas = repasManager.selectRepas();
		request.setAttribute("listeRepas", listeRepas);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modules/module4/visualiser.jsp");
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
