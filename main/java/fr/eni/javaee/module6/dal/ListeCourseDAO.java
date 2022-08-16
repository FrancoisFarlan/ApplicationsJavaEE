package fr.eni.javaee.module6.dal;

import java.util.List;

import fr.eni.javaee.module6.BusinessException;
import fr.eni.javaee.module6.bo.ListeCourse;

public interface ListeCourseDAO {
	public void insert(ListeCourse listeCourse) throws BusinessException;
	public void delete(int id) throws BusinessException;
	public List<ListeCourse> selectAll() throws BusinessException;
	public ListeCourse selectById(int id) throws BusinessException;
	public void deleteArticle(int idArticle) throws BusinessException;
	public void cocherArticle(int idArticle) throws BusinessException;
	public void decocherArticle(int idArticle) throws BusinessException;
	public void decocherListeCourse(int listeCourse) throws BusinessException;
}
