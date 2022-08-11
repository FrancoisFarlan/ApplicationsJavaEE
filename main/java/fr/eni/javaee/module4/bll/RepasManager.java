package fr.eni.javaee.module4.bll;

import java.util.List;

import fr.eni.javaee.module4.BusinessException;
import fr.eni.javaee.module4.bo.Repas;
import fr.eni.javaee.module4.dal.DAOFactory;
import fr.eni.javaee.module4.dal.RepasDAO;

public class RepasManager {

	
	private RepasDAO daoRepas;
	
	

	/**
	 * @param daoRepas
	 */
	public RepasManager() {
		this.daoRepas = DAOFactory.getRepasDAO(); 
	}
	
	public Repas ajouterRepas(Repas r) throws BusinessException{
		
		BusinessException exception = new BusinessException(); 
		
		
		this.validerRepas(r, exception);
		
		if(exception.hasErreurs()) {
			throw exception;
		} else {
		this.daoRepas.insertRepas(r);
		}
		return r;
		
		
	}
	
	public List<Repas> selectRepas() {
		return this.daoRepas.selectAll();
	}
	
	public void validerRepas(Repas r, BusinessException businessException) {
		if(r.getDate() == null) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_REPAS_DATE_ERREUR);
		}
		
		if(r.getTime() == null) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_REPAS_TIME_ERREUR);
		}
		
		if(r.getAliments().isEmpty() || r.getAliments().size() == 0) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_REPAS_ALIMENTS_ERREUR);
		}
	}
}
