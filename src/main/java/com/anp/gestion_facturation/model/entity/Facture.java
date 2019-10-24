package com.anp.gestion_facturation.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

/**
 * Facture
 */

@Entity
@Table(name = "facture")
public class Facture {

	public Facture() {

	}

	public Facture(boolean factureReglee, Date dateFacture, double montantTVA, double montantHTC, double montantTTC) {
		// this.codeBulletin = codeBulletin;
		this.factureReglee = factureReglee;
		this.dateFacture = dateFacture;
		this.montantHTC = montantHTC;
		this.montantTTC = montantTTC;
		this.montantTVA = montantTVA;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "facture")
	private int codeFacture;

	// @Column(name = "code_bulletin")
	// private int codeBulletin;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "code_decision")
	private Bulletin bulletin;

	@Column(name = "facture_reglee")
	private boolean factureReglee = false;

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "date_facture")
	private Date dateFacture;

	@Column(name = "montant_tva")
	private double montantTVA;

	@Column(name = "montant_htc")
	private double montantHTC;

	@Column(name = "montantTTC")
	private double montantTTC;

	private double montantTaxeRegionale;

	@OneToMany(mappedBy = "facture", cascade = CascadeType.ALL)
	private List<LigneFacture> ligneFactures;

	/**
	 * @return the ligneFactures
	 */
	public List<LigneFacture> getLigneFactures() {
		return ligneFactures;
	}

	/**
	 * @param ligneFactures the ligneFactures to set
	 */
	public void setLigneFactures(List<LigneFacture> ligneFactures) {
		this.ligneFactures = ligneFactures;
	}

	public int getCodeFacture() {
		return codeFacture;
	}

	public void setCodeFacture(int codeFacture) {
		this.codeFacture = codeFacture;
	}

	/**
	 * @return the montantHTC
	 */
	public double getMontantHTC() {
		return montantHTC;
	}

	/**
	 * @return the montantTTC
	 */
	public double getMontantTTC() {
		return montantTTC;
	}

	/**
	 * @return the montantTVA
	 */
	public double getMontantTVA() {
		return montantTVA;
	}

	/**
	 * @param montantHTC the montantHTC to set
	 */
	public void setMontantHTC(double montantHTC) {
		this.montantHTC = montantHTC;
	}

	/**
	 * @param montantTTC the montantTTC to set
	 */
	public void setMontantTTC(double montantTTC) {
		this.montantTTC = montantTTC;
	}

	/**
	 * @return the bulletin
	 */
	public Bulletin getBulletin() {
		return bulletin;
	}

	/**
	 * @param bulletin the bulletin to set
	 */
	public void setBulletin(Bulletin bulletin) {
		this.bulletin = bulletin;
	}

	/**
	 * @param montantTVA the montantTVA to set
	 */
	public void setMontantTVA(double montantTVA) {
		this.montantTVA = montantTVA;
	}

	// public int getCodeBulletin() {
	// return codeBulletin;
	// }

	// public void setCodeBulletin(int codeBulletin) {
	// this.codeBulletin = codeBulletin;
	// }

	public boolean isFactureReglee() {
		return factureReglee;
	}

	public void setFactureReglee(boolean factureReglee) {
		this.factureReglee = factureReglee;
	}

	public Date getDateFacture() {
		return dateFacture;
	}

	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}

	@Override
	public String toString() {
		return "Facture [codeFacture=" + codeFacture + ", factureReglee=" + factureReglee + ", dateFacture="
				+ dateFacture + ", montant=" + montantTTC + "]";
	}

	public double getMontantTaxeRegionale() {
		return montantTaxeRegionale;
	}

	public void setMontantTaxeRegionale(double montantTaxeRegionale) {
		this.montantTaxeRegionale = montantTaxeRegionale;
	}

}