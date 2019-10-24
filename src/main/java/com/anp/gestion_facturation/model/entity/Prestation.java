package com.anp.gestion_facturation.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Prestation
 */

@Entity
@Table(name = "prestation")
public class Prestation {

	public Prestation() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code_prestation")
	private int codePrestation;

	@Column(name = "libelle_prestation")
	private String libellePrestation;

	private String type;

	private boolean majorationFeriee;
	private boolean majorationHoraire;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "penalite")
	private Penalite penalite;

	@ManyToOne
	@JoinColumn(name = "port")
	private Port port;

	@JsonIgnore
	@OneToMany(mappedBy = "prestation", cascade = CascadeType.ALL)
	@OrderBy("minCondition DESC,minJour DESC")
	private List<TrancheTarif> tranches;

	@ManyToOne
	@JoinColumn(name = "code_tva")
	private TVA tva;

	public int getCodePrestation() {
		return codePrestation;
	}

	public void setCodePrestation(int codePrestation) {
		this.codePrestation = codePrestation;
	}

	public String getLibellePrestation() {
		return libellePrestation;
	}

	public void setLibellePrestation(String libellePrestation) {
		this.libellePrestation = libellePrestation;
	}

	/**
	 * @return the tva
	 */
	public TVA getTva() {
		return tva;
	}

	/**
	 * @param tva the tva to set
	 */
	public void setTva(TVA tva) {
		this.tva = tva;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isMajorationFeriee() {
		return majorationFeriee;
	}

	public void setMajorationFeriee(boolean majorationFeriee) {
		this.majorationFeriee = majorationFeriee;
	}

	public boolean isMajorationHoraire() {
		return majorationHoraire;
	}

	public void setMajorationHoraire(boolean majorationHoraire) {
		this.majorationHoraire = majorationHoraire;
	}

	public Penalite getPenalite() {
		return penalite;
	}

	public void setPenalite(Penalite penalite) {
		this.penalite = penalite;
	}

	public List<TrancheTarif> getTranches() {
		return tranches;
	}

	public void setTranches(List<TrancheTarif> tranches) {
		this.tranches = tranches;
	}

	public Prestation(String libellePrestation, String type, boolean majorationFeriee, boolean majorationHoraire) {
		this.libellePrestation = libellePrestation;
		this.type = type;
		this.majorationFeriee = majorationFeriee;
		this.majorationHoraire = majorationHoraire;

	}

	public TrancheTarif getTarifByCondition(double condition) {

		if (tranches.size() == 1) {
			return tranches.get(0);
		}
		for (TrancheTarif tranche : tranches) {
			if (tranche.getMinCondition() < condition && tranche.getMaxCondition() >= condition) {
				return tranche;
			}

		}

		return tranches.get(0);
	}

	public List<TrancheTarif> getTarifJourByCondition(double condition) {
		ArrayList<TrancheTarif> trancheTarifs = new ArrayList<>();

		for (TrancheTarif tranche : tranches) {
			if (tranche.getMinCondition() < condition && tranche.getMaxCondition() >= condition) {
				trancheTarifs.add(tranche);
			}

		}

		return trancheTarifs;
	}

	@Override
	public String toString() {
		return "Prestation [codePrestation=" + codePrestation + ", libellePrestation=" + libellePrestation
				+ ", majorationFeriee=" + majorationFeriee + ", majorationHoraire=" + majorationHoraire + ", penalite="
				+ penalite + ", tranches=" + tranches + ", tva=" + tva + ", type=" + type + "]";
	}

	public Port getPort() {
		return port;
	}

	public void setPort(Port port) {
		this.port = port;
	}

}