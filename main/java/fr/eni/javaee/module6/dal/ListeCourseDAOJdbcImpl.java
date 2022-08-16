package fr.eni.javaee.module6.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.javaee.module6.BusinessException;
import fr.eni.javaee.module6.bo.Article;
import fr.eni.javaee.module6.bo.ListeCourse;

public class ListeCourseDAOJdbcImpl implements ListeCourseDAO {


	private static final String INSERT_LISTE ="INSERT INTO LISTES(nom) VALUES(?)";
	private static final String INSERT_ARTICLE ="INSERT INTO ARTICLES(nom, id_liste) VALUES(?,?)"; 
	private static final String SELECT_ALL="SELECT id, nom FROM LISTES";
	private static final String SELECT_BY_ID ="SELECT l.id, l.nom, a.id, a.nom, a.coche FROM LISTES l "
			+ "LEFT JOIN ARTICLES a ON l.id = a.id_liste WHERE l.id = ?"; 
	private static final String DELETE_ARTICLE ="DELETE FROM ARTICLES WHERE id = ?";
	private static final String DELETE_LISTE ="DELETE FROM LISTES WHERE id = ?";
	private static final String COCHER_ARTICLE ="UPDATE ARTICLES SET coche = 1 WHERE id = ?";
	private static final String DECOCHER_ARTICLE ="UPDATE ARTICLES SET coche = 0 WHERE id = ?";
	private static final String DECOCHER_ARTICLES ="UPDATE ARTICLES SET coche = 0 WHERE id_liste = ?";
	
	@Override
	public void insert(ListeCourse listeCourse) throws BusinessException {
	
		if(listeCourse==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				PreparedStatement pstmt;
				ResultSet rs;
				if(listeCourse.getId()==0)
				{
					pstmt = cnx.prepareStatement(INSERT_LISTE, PreparedStatement.RETURN_GENERATED_KEYS);
					pstmt.setString(1, listeCourse.getNom());
					pstmt.executeUpdate();
					rs = pstmt.getGeneratedKeys();
					if(rs.next())
					{
						listeCourse.setId(rs.getInt(1));
					}
					rs.close();
					pstmt.close();
				}
				if(listeCourse.getArticles().size()==1)
				{
					pstmt = cnx.prepareStatement(INSERT_ARTICLE);
					pstmt.setString(1, listeCourse.getArticles().get(0).getNom());
					pstmt.setInt(2, listeCourse.getId());
					pstmt.executeUpdate();
					pstmt.close();
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw ex;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}
	
	}

	@Override
	public void delete(int id) throws BusinessException {
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(DELETE_LISTE);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SUPPRESSION_LISTE_ERREUR);
			throw businessException;
		}
		
	}

	@Override
	public List<ListeCourse> selectAll() throws BusinessException {
		return null;
		
	}

	@Override
	public ListeCourse selectById(int id) throws BusinessException {
		return null;
	
		
	}

	@Override
	public void deleteArticle(int idArticle) throws BusinessException {
		
	}

	@Override
	public void cocherArticle(int idArticle) throws BusinessException {
		
		
	}

	@Override
	public void decocherArticle(int idArticle) throws BusinessException {
		
		
	}

	@Override
	public void decocherListeCourse(int idListeCourse) throws BusinessException {
		
		
	}

}











