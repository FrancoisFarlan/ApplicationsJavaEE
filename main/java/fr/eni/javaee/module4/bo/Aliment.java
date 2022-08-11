package fr.eni.javaee.module4.bo;

public class Aliment {
	
	private Integer idRepas;
	private String nomAliment;
	
	
	
	
	/**
	 * @param idRepas
	 * @param nomAliment
	 */
	public Aliment(int idRepas, String nomAliment) {
		this.idRepas = idRepas;
		this.nomAliment = nomAliment;
	}
	

	/**
	 * @param nomAliment
	 */
	public Aliment(String nomAliment) {
		this.nomAliment = nomAliment;
	}


	public int getIdRepas() {
		return this.idRepas;
	}


	public void setIdRepas(int idRepas) {
		this.idRepas = idRepas;
	}


	public String getNomAliment() {
		return this.nomAliment;
	}


	public void setNomAliment(String nomAliment) {
		this.nomAliment = nomAliment;
	}


	@Override
	public String toString() {
		return "Aliment [identifiant=" + idRepas + ", nom=" + nomAliment + "]";
	}
	
}
