package fr.eni.javaee.module6.dal;

public abstract class DAOFactory {
	
	public static ListeCourseDAO getListeCourseDAO()
	{
		return new ListeCourseDAOJdbcImpl();
	}
}
	