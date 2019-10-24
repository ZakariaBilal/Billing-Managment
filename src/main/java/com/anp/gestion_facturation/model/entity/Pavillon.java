package com.anp.gestion_facturation.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Pavillon
 */

@Entity
@Table(name = "pavillon")
public class Pavillon {

	public Pavillon() {

	}

	public Pavillon(String libellePavillon) {
		this.libellePavillon = libellePavillon;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code_pavillon")
	private int codePavillon;

	@Column(name = "libelle_pavillon")
	private String libellePavillon;

	public int getCodePavillon() {
		return codePavillon;
	}

	public void setCodePavillon(int codePavillon) {
		this.codePavillon = codePavillon;
	}

	public String getLibellePavillon() {
		return libellePavillon;
	}

	public void setLibellePavillon(String libellePavillon) {
		this.libellePavillon = libellePavillon;
	}

	@Override
	public String toString() {
		return "Pavillon [codePavillon=" + codePavillon + ", libellePavillon=" + libellePavillon + "]";
	}

}