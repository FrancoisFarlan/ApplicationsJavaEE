package fr.eni.javaee.module4.bo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Repas {

	private Integer id_repas;
	private LocalDate date;
	private LocalTime time;
	private List<Aliment> aliments = new ArrayList<>();
	/**
	 * @param date
	 * @param time
	 */
	public Repas(LocalDate date, LocalTime time) {
		this.date = date;
		this.time = time;
	}
	/**
	 * @param id_repas
	 * @param date
	 * @param time
	 */
	public Repas(Integer id_repas, LocalDate date, LocalTime time) {
		this.id_repas = id_repas;
		this.date = date;
		this.time = time;
	}
	/**
	 * @param date
	 * @param time
	 * @param aliments
	 */
	public Repas(LocalDate date, LocalTime time, List<Aliment> aliments) {
		this.date = date;
		this.time = time;
		this.aliments = aliments;
	}
	public Integer getId_repas() {
		return this.id_repas;
	}
	public void setId_repas(Integer id_repas) {
		this.id_repas = id_repas;
	}
	public LocalDate getDate() {
		return this.date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return this.time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public List<Aliment> getAliments() {
		return this.aliments;
	}
	
	public void addAliment(Aliment a) {
		this.aliments.add(a);
	}
	
	public void setAliments(List<Aliment> aliments) {
		this.aliments = aliments;
	}
	
	@Override
	public String toString() {
		return "Repas [identifiant=" + id_repas + ", date=" + date + ", heure=" + time + ", listeAliments="
				+ aliments + "]";
	}
}
