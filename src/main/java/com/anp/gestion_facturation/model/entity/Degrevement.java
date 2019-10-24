package com.anp.gestion_facturation.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Degrevement
 */

@Entity
@Table(name = "degrevement")
public class Degrevement {

	public Degrevement() {

	}

	public Degrevement(double tauxDegrevement, double montantHTCDegrevement) {
		// this.codeDecision = codeDecision;
		this.tauxDegrevement = tauxDegrevement;
		this.montantHTCDegrevement = montantHTCDegrevement;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code_degrevement")
	private int codeDegrevement;

	// @Column(name = "code_decision")
	// private int codeDecision;

	@Column(name = "taux_degrevement")
	private double tauxDegrevement;

	@Column(name = "montant_htc_degrevement")
	private double montantHTCDegrevement;

	@Column(name = "montant_tva_degrevement")
	private double montantTVADegrevement;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "code_decision")
	private Decision decision;

	// public int getCodeDecision() {
	// return codeDecision;
	// }

	/**
	 * @return the codeDegrevement
	 */
	public int getCodeDegrevement() {
		return codeDegrevement;
	}

	/**
	 * @return the decision
	 */
	public Decision getDecision() {
		return decision;
	}

	/**
	 * @param decision the decision to set
	 */
	public void setDecision(Decision decision) {
		this.decision = decision;
	}

	/**
	 * @return the montantTVADegrevement
	 */
	public double getMontantTVADegrevement() {
		return montantTVADegrevement;
	}

	/**
	 * @param montantTVADegrevement the montantTVADegrevement to set
	 */
	public void setMontantTVADegrevement(double montantTVADegrevement) {
		this.montantTVADegrevement = montantTVADegrevement;
	}

	/**
	 * @param codeDegrevement the codeDegrevement to set
	 */
	public void setCodeDegrevement(int codeDegrevement) {
		this.codeDegrevement = codeDegrevement;
	}

	// public void setCodeDecision(int codeDecision) {
	// this.codeDecision = codeDecision;
	// }

	public double getTauxDegrevement() {
		return tauxDegrevement;
	}

	public void setTauxDegrevement(double tauxDegrevement) {
		this.tauxDegrevement = tauxDegrevement;
	}

	public double getMontantHTCDegrevement() {
		return montantHTCDegrevement;
	}

	public void setMontantHTCDegrevement(double montantHTCDegrevement) {
		this.montantHTCDegrevement = montantHTCDegrevement;
	}

	@Override
	public String toString() {
		return "Degrevement, tauxDegrevement=" + tauxDegrevement + ", montantHTCDegrevement=" + montantHTCDegrevement
				+ "]";
	}

}