package com.anp.gestion_facturation.model.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

/**
 * Reglement
 */

@Entity
@Table(name = "reglement")
public class Reglement {

	public Reglement() {

	}

	public Reglement(Date dateReglement, String modeReglement, int numCheque) {

		this.dateReglement = dateReglement;
		this.modeReglement = modeReglement;
		this.numCheque = numCheque;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code_reglement")
	private int codeReglement;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "code_facture")
	private Facture facture;

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "date_reglement")
	private Date dateReglement;

	@Column(name = "mode_reglement")
	private String modeReglement;

	@Column(name = "numero_cheque")
	private int numCheque;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "code_banque")
	private Banque banque;

	public int getCodeReglement() {
		return codeReglement;
	}

	public void setCodeReglement(int codeReglement) {
		this.codeReglement = codeReglement;
	}

	public Date getDateReglement() {
		return dateReglement;
	}

	public void setDateReglement(Date dateReglement) {
		this.dateReglement = dateReglement;
	}

	public String getModeReglement() {
		return modeReglement;
	}

	public void setModeReglement(String modeReglement) {
		this.modeReglement = modeReglement;
	}

	public int getNumCheque() {
		return numCheque;
	}

	public void setNumCheque(int numCheque) {
		this.numCheque = numCheque;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	@Override
	public String toString() {
		return "Reglement [banque=" + banque + ", codeReglement=" + codeReglement + ", dateReglement=" + dateReglement
				+ ", facture=" + facture + ", modeReglement=" + modeReglement + ", numCheque=" + numCheque + "]";
	}

}