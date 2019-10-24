package com.anp.gestion_facturation.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Banque
 */

@Entity
@Table(name = "banque")
public class Banque {

	public Banque() {

	}

	public Banque(String nomBanque) {
		this.nomBanque = nomBanque;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code_banque")
	private int codeBanque;

	@Column(name = "nom_banque")
	private String nomBanque;

	public int getCodeBanque() {
		return codeBanque;
	}

	public void setCodeBanque(int codeBanque) {
		this.codeBanque = codeBanque;
	}

	public String getNomBanque() {
		return nomBanque;
	}

	public void setNomBanque(String nomBanque) {
		this.nomBanque = nomBanque;
	}

	@Override
	public String toString() {
		return "Banque [codeBanque=" + codeBanque + ", nomBanque=" + nomBanque + "]";
	}

}