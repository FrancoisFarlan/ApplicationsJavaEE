package fr.eni.javaee.module6.bo;

import java.io.Serializable;

public class Article implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String nom;
	private boolean coche;
	
	public Article() {
		
	}
	
	public Article(int id, String nom, boolean coche) {
		this(id,nom);
		this.coche = coche;
	}
	public Article(int id, String nom) {
		this(nom);
		this.id = id;
	}
	public Article(String nom) {
		super();
		this.nom = nom;
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return this.nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public boolean isCoche() {
		return this.coche;
	}
	public void setCoche(boolean coche) {
		this.coche = coche;
	}
	
	
}