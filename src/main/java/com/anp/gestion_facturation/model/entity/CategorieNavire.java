package com.anp.gestion_facturation.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CategorieNavire
 */

@Entity
@Table(name = "categorie_navire")
public class CategorieNavire {

	public CategorieNavire() {

	}

	public CategorieNavire(String libelleCategorieNavire) {

		this.libelleCategorieNavire = libelleCategorieNavire;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code_categorie_navire")
	private int codeCategorieNavire;

	@Column(name = "libelle_categorie_navire")
	private String libelleCategorieNavire;

	public int getCodeCategorieNavire() {
		return codeCategorieNavire;
	}

	public void setCodeCategorieNavire(int codeCategorieNavire) {
		this.codeCategorieNavire = codeCategorieNavire;
	}

	public String getLibelleCategorieNavire() {
		return libelleCategorieNavire;
	}

	public void setLibelleCategorieNavire(String libelleCategorieNavire) {
		this.libelleCategorieNavire = libelleCategorieNavire;
	}

	@Override
	public String toString() {
		return "CategorieNavire [codeCategorieNavire=" + codeCategorieNavire + ", libelleCategorieNavire="
				+ libelleCategorieNavire + "]";
	}

}