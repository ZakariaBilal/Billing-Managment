package com.anp.gestion_facturation.model.entity;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.anp.gestion_facturation.model.dao.JourFerieeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * LigneBulletin
 */

@Entity
@Table(name = "ligne_bulletin")
public class LigneBulletin {

	public LigneBulletin() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code_ligne_bulletin")
	private int codeLigneBulletin;

	@ManyToOne
	@JoinColumn(name = "code_bulletin")
	private Bulletin bulletin;

	@Column(name = "quantite")
	private int quantite = 1;

	@Column(name = "reduction")
	private double reduction = 0;

	@ManyToOne
	@JoinColumn(name = "code_prestation")
	private Prestation prestation;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime dateDebut;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime dateFin;

	@Autowired
	@Transient
	private JourFerieeRepo jourFerieeRepo;

	/**
	 * @return the bulletin
	 */
	public Bulletin getBulletin() {
		return bulletin;
	}

	/**
	 * @return the prestation
	 */
	public Prestation getPrestation() {
		return prestation;
	}

	/**
	 * @param prestation the prestation to set
	 */
	public void setPrestation(Prestation prestation) {
		this.prestation = prestation;
	}

	/**
	 * @param bulletin the bulletin to set
	 */
	public void setBulletin(Bulletin bulletin) {
		this.bulletin = bulletin;
	}

	/**
	 * @return the codeLigneBulletin
	 */
	public int getCodeLigneBulletin() {
		return codeLigneBulletin;
	}

	/**
	 * @param codeLigneBulletin the codeLigneBulletin to set
	 */
	public void setCodeLigneBulletin(int codeLigneBulletin) {
		this.codeLigneBulletin = codeLigneBulletin;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getReduction() {
		return reduction;
	}

	public void setReduction(double reduction) {
		this.reduction = reduction;
	}

	public int getJours() {
		long millis = Duration.between(dateDebut, dateFin).toMillis();
		double jours = (double) millis / (1000 * 60 * 60 * 24);
		return (int) Math.ceil(jours);
	}

	public double getHours() {

		double minutes = Duration.between(dateDebut, dateFin).toMinutes();
		if (minutes > 60) {
			return Math.ceil(minutes / 60);
		} else {
			return minutes / 60;
		}
	}

	public boolean insideFeriee() {
		if (dateDebut.getDayOfWeek() == DayOfWeek.SATURDAY || dateDebut.getDayOfWeek() == DayOfWeek.SUNDAY) { // or
			// sunday
			System.out.println("WEEKEND");
			return true;
		} else {
			System.out.println("WEEKDAY");
			return false;
		}
	}

	public boolean isHorsHoraire() {
		LocalDateTime debut = dateDebut.withHour(8);

		LocalDateTime fin = dateDebut.withHour(18);
		if (getJours() == 1 && !insideFeriee()) {
			if (dateDebut.isAfter(debut) && dateFin.isBefore(fin)) {
				return false;
			}
		}

		return true;
	}

	public LigneBulletin(int quantite, double reduction, LocalDateTime dateDebut, LocalDateTime dateFin) {
		this.quantite = quantite;
		this.reduction = reduction;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public LocalDateTime getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDateTime dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDateTime getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDateTime dateFin) {
		this.dateFin = dateFin;
	}

	@Override
	public String toString() {
		return "LigneBulletin [codeLigneBulletin=" + codeLigneBulletin + ", dateDebut=" + dateDebut + ", dateFin="
				+ dateFin + ", prestation=" + prestation + ", quantite=" + quantite + ", reduction=" + reduction + "]";
	}
}