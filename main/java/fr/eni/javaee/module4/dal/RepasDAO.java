package fr.eni.javaee.module4.dal;

import java.util.List;

import fr.eni.javaee.module4.BusinessException;
import fr.eni.javaee.module4.bo.Repas;

public interface RepasDAO {

	public void insertRepas(Repas repas) throws BusinessException;
	public List<Repas> selectAll();
	
}
