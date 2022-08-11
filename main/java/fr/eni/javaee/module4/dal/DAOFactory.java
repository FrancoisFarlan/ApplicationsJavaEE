package fr.eni.javaee.module4.dal;

public abstract class DAOFactory {

	public static RepasDAO getRepasDAO() {
		return new RepasDAOJdbcImpl(); 
	}
}
