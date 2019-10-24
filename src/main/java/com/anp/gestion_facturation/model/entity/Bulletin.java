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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Bulletin
 */

@Entity
@Table(name = "bulletin")
public class Bulletin {

	public Bulletin() {

	}

	public Bulletin(Date dateEntree, Date dateSortie, Date dateBulletin, boolean factured) {

		this.dateEntree = dateEntree;
		this.dateSortie = dateSortie;

		this.dateBulletin = dateBulletin;
		this.factured = factured;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code_bulletin")
	private int codeBulletin;

	@OneToMany(mappedBy = "bulletin", cascade = CascadeType.ALL)
	private List<LigneBulletin> ligneBulletins;

	@ManyToOne
	@JoinColumn(name = "code_client")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "code_navire")
	private Navire navire;

	@Column(name = "date_entree")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateEntree;

	@ManyToOne
	@JoinColumn(name = "port")
	private Port port;

	@Column(name = "date_sortie")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateSortie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "code_type_bulletin")
	private TypeBulletin typeBulletin;

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "date_bulletin")
	private Date dateBulletin;

	private boolean factured = false;

	/**
	 * @return the ligneBulletins
	 */
	public List<LigneBulletin> getLigneBulletins() {
		return ligneBulletins;
	}

	/**
	 * @return the typeBulletin
	 */
	public TypeBulletin getTypeBulletin() {
		return typeBulletin;
	}

	/**
	 * @param typeBulletin the typeBulletin to set
	 */
	public void setTypeBulletin(TypeBulletin typeBulletin) {
		this.typeBulletin = typeBulletin;
	}

	/**
	 * @param ligneBulletins the ligneBulletins to set
	 */
	public void setLigneBulletins(List<LigneBulletin> ligneBulletins) {
		this.ligneBulletins = ligneBulletins;
	}

	/**
	 * @param factured the factured to set
	 */
	public void setFactured(boolean factured) {
		this.factured = factured;
	}

	public boolean getFactured() {
		return this.factured;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @return the navire
	 */
	public Navire getNavire() {
		return navire;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @param navire the navire to set
	 */
	public void setNavire(Navire navire) {
		this.navire = navire;
	}

	public int getCodeBulletin() {
		return codeBulletin;
	}

	public void setCodeBulletin(int codeBulletin) {
		this.codeBulletin = codeBulletin;
	}

	// public int getCodeClient() {
	// return codeClient;
	// }

	// public void setCodeClient(int codeClient) {
	// this.codeClient = codeClient;
	// }

	// public int getCodeNavire() {
	// return codeNavire;
	// }

	// public void setCodeNavire(int codeNavire) {
	// this.codeNavire = codeNavire;
	// }

	public Date getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	// public int getCodeTypeBulletin() {
	// return codeTypeBulletin;
	// }

	// public void setCodeTypeBulletin(int codeTypeBulletin) {
	// this.codeTypeBulletin = codeTypeBulletin;
	// }

	public Date getDateBulletin() {
		return dateBulletin;
	}

	public void setDateBulletin(Date dateBulletin) {
		this.dateBulletin = dateBulletin;
	}

	@Override
	public String toString() {
		return "Bulletin [client=" + client + ", codeBulletin=" + codeBulletin + ", dateBulletin=" + dateBulletin
				+ ", dateEntree=" + dateEntree + ", dateSortie=" + dateSortie + ", factured=" + factured
				+ ", ligneBulletins=" + ligneBulletins + ", navire=" + navire + ", typeBulletin=" + typeBulletin + "]";
	}

	public Port getPort() {
		return port;
	}

	public void setPort(Port port) {
		this.port = port;
	}

}