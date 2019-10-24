package com.anp.gestion_facturation.model.entity;

import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

/**
 * Client
 */

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code_client")
	private int codeClient;

	@JsonManagedReference
	@OneToMany(mappedBy = "client", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private List<Navire> navires;

	@Column(name = "nom_client")
	private String nomClient;

	@Column(name = "adresse")
	private String adresse;

	@Column(name = "complement_adresse")
	private String complementAdresse;

	@Column(name = "numero_patente")
	private String numeroPatente;

	@Column(name = "numero_tel")
	private String numeroTel;

	@Column(name = "ice")
	private String ice;

	public Client() {

	}

	public Client(String nomClient, String adresse, String complementAdresse, String numeroPatente, String numeroTel) {
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.complementAdresse = complementAdresse;
		this.numeroPatente = numeroPatente;
		this.numeroTel = numeroTel;
	}

	public int getCodeClient() {
		return codeClient;
	}

	public void setCodeClient(int codeClient) {
		this.codeClient = codeClient;
	}

	/**
	 * @return the navires
	 */
	public List<Navire> getNavires() {
		return navires;
	}

	/**
	 * @param navires the navires to set
	 */
	public void setNavires(List<Navire> navires) {
		this.navires = navires;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getComplementAdresse() {
		return complementAdresse;
	}

	public void setComplementAdresse(String complementAdresse) {
		this.complementAdresse = complementAdresse;
	}

	public String getNumeroPatente() {
		return numeroPatente;
	}

	public void setNumeroPatente(String numeroPatente) {
		this.numeroPatente = numeroPatente;
	}

	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	/**
	 * @param ice the ice to set
	 */
	public void setIce(String ice) {
		this.ice = ice;
	}

	/**
	 * @return the ice
	 */
	public String getIce() {
		return ice;
	}

	@Override
	public String toString() {
		return "Client [codeClient=" + codeClient + ", nomClient=" + nomClient + ", adresse=" + adresse
				+ ", complementAdresse=" + complementAdresse + ", numeroPatente=" + numeroPatente + ", numeroTel="
				+ numeroTel + "]";
	}

}