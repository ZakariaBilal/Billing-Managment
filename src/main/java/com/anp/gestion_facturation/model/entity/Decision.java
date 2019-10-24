package com.anp.gestion_facturation.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Decision
 */

@Entity
@Table(name = "decision")
public class Decision {

	public Decision() {

	}

	public Decision(Date dateDecision, int codeFacture, int codeTypeDecision) {

		this.dateDecision = dateDecision;
		this.codeFacture = codeFacture;
		this.codeTypeDecision = codeTypeDecision;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code_decision")
	private int codeDecision;

	@Column(name = "date_decision")
	private Date dateDecision;

	@Column(name = "code_facture")
	private int codeFacture;

	@Column(name = "code_type_decision")
	private int codeTypeDecision;

	public int getCodeDecision() {
		return codeDecision;
	}

	public void setCodeDecision(int codeDecision) {
		this.codeDecision = codeDecision;
	}

	public Date getDateDecision() {
		return dateDecision;
	}

	public void setDateDecision(Date dateDecision) {
		this.dateDecision = dateDecision;
	}

	public int getCodeFacture() {
		return codeFacture;
	}

	public void setCodeFacture(int codeFacture) {
		this.codeFacture = codeFacture;
	}

	public int getCodeTypeDecision() {
		return codeTypeDecision;
	}

	public void setCodeTypeDecision(int codeTypeDecision) {
		this.codeTypeDecision = codeTypeDecision;
	}

	@Override
	public String toString() {
		return "Decision [codeDecision=" + codeDecision + ", dateDecision=" + dateDecision + ", codeFacture="
				+ codeFacture + ", codeTypeDecision=" + codeTypeDecision + "]";
	}

}