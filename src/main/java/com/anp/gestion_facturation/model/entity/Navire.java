package com.anp.gestion_facturation.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Navire
 */

@Entity
@Table(name = "navire")
public class Navire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_navire")
    private int codeNavire;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_client")
    private Client client;

    @Column(name = "nom_navire")
    private String nomNavire;

    // @Column(name = "code_pavillon")
    // private int codePavillon;

    @ManyToOne
    @JoinColumn(name = "code_pavillon")
    private Pavillon pavillon;

    @ManyToOne
    @JoinColumn(name = "categorie_navire")
    private CategorieNavire categorieNavire;
    // @Column(name = "categorie_navire")
    // private int categorieNavire;

    @Column(name = "longueur_navire")
    private double longueurNavire;

    @Column(name = "jauge_brute")
    private int jaugeBrute;

    public Navire() {

    }

    public Navire(String nomNavire, double longueurNavire, int jaugeBrute) {
        this.nomNavire = nomNavire;
        this.longueurNavire = longueurNavire;
        this.jaugeBrute = jaugeBrute;

    }

    /**
     * @return the codeNavire
     */
    public int getCodeNavire() {
        return codeNavire;
    }

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @return the pavillon
     */
    public Pavillon getPavillon() {
        return pavillon;
    }

    /**
     * @param pavillon the pavillon to set
     */
    public void setPavillon(Pavillon pavillon) {
        this.pavillon = pavillon;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * @return the categorieNavire
     */
    public CategorieNavire getCategorieNavire() {
        return categorieNavire;
    }

    /**
     * @param categorieNavire the categorieNavire to set
     */
    public void setCategorieNavire(CategorieNavire categorieNavire) {
        this.categorieNavire = categorieNavire;
    }

    /**
     * @param codeNavire the codeNavire to set
     */
    public void setCodeNavire(int codeNavire) {
        this.codeNavire = codeNavire;
    }

    // /**
    // * @param codePavillon the codePavillon to set
    // */
    // public void setCodePavillon(int codePavillon) {
    // this.codePavillon = codePavillon;
    // }

    /**
     * @param jaugeBrute the jaugeBrute to set
     */
    public void setJaugeBrute(int jaugeBrute) {
        this.jaugeBrute = jaugeBrute;
    }

    /**
     * @param longueurNavire the longueurNavire to set
     */
    public void setLongueurNavire(double longueurNavire) {
        this.longueurNavire = longueurNavire;
    }

    /**
     * @param nomNavire the nomNavire to set
     */
    public void setNomNavire(String nomNavire) {
        this.nomNavire = nomNavire;
    }

    // /**
    // * @return the codePavillon
    // */
    // public int getCodePavillon() {
    // return codePavillon;
    // }

    /**
     * @return the jaugeBrute
     */
    public int getJaugeBrute() {
        return jaugeBrute;
    }

    /**
     * @return the longueurNavire
     */
    public double getLongueurNavire() {
        return longueurNavire;
    }

    /**
     * @return the nomNavire
     */
    public String getNomNavire() {
        return nomNavire;
    }

    @Override
    public String toString() {
        return "Navire [codeNavire=" + codeNavire + ", nomNavire=" + nomNavire + ", codePavillon="
                + pavillon.getCodePavillon() + ", categorieNavire=" + categorieNavire + ", longueurNavire="
                + longueurNavire + ", jaugeBrute=" + jaugeBrute + "]";
    }

}