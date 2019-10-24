package com.anp.gestion_facturation.model.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Avoir
 */

@Entity
@Table(name = "avoir")
public class Avoir {

	public Avoir() {
	}

	public Avoir(double tauxAvoir, double montantHTCAvoir, double montantTVAAvoir) {
		this.tauxAvoir = tauxAvoir;
		this.montantHTCAvoir = montantHTCAvoir;
		this.montantTVAAvoir = montantTVAAvoir;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code_avoir")
	private int codeAvoir;

	// @Column(name = "code_decision")
	// private int codeDecision;

	@Column(name = "taux_avoir")
	private double tauxAvoir;

	@Column(name = "montant_htc_avoir")
	private double montantHTCAvoir;

	@Column(name = "montont_tva_avoir")
	private double montantTVAAvoir;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "code_decision")
	private Decision decision;

	/**
	 * @return the codeAvoir
	 */
	public int getCodeAvoir() {
		return codeAvoir;
	}

	/**
	 * @param codeAvoir the codeAvoir to set
	 */
	public void setCodeAvoir(int codeAvoir) {
		this.codeAvoir = codeAvoir;
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

	// public int getCodeDecision() {
	// return codeDecision;
	// }

	// public void setCodeDecision(int codeDecision) {
	// this.codeDecision = codeDecision;
	// }

	public double getTauxAvoir() {
		return tauxAvoir;
	}

	public void setTauxAvoir(double tauxAvoir) {
		this.tauxAvoir = tauxAvoir;
	}

	public double getMontantHTCAvoir() {
		return montantHTCAvoir;
	}

	public void setMontantHTCAvoir(double montantHTCAvoir) {
		this.montantHTCAvoir = montantHTCAvoir;
	}

	public double getMontantTVAAvoir() {
		return montantTVAAvoir;
	}

	public void setMontantTVAAvoir(double montantTVAAvoir) {
		this.montantTVAAvoir = montantTVAAvoir;
	}

	@Override
	public String toString() {
		return "Avoir [TauxAvoir=" + tauxAvoir + ", montantHTCAvoir=" + montantHTCAvoir + ", montantTVAAvoir="
				+ montantTVAAvoir + "]";
	}

}