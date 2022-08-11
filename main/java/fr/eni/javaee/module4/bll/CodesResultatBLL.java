package fr.eni.javaee.module4.bll;

/**
 * Les codes disponibles sont entre 20000 et 29999
 */
public abstract class CodesResultatBLL {
	
	/**
	 * Echec quand la description du repas ne repsecte pas les règles définies
	 */
	public static final int REGLE_REPAS_DATE_ERREUR=20000;
	/**
	 * Echec quand la description du repas ne repsecte pas les règles définies
	 */
	public static final int REGLE_REPAS_TIME_ERREUR=20001;
	
	public static final int REGLE_REPAS_ALIMENTS_ERREUR = 20002;
	
	
}
