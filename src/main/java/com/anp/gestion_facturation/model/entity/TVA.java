package com.anp.gestion_facturation.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TVA
 */

@Entity
@Table(name = "tva")
public class TVA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_tva")
    private int codeTva;

    @Column(name = "taux_tva")
    private double tauxTva;

    /**
     * @return the codeTva
     */
    public int getCodeTva() {
        return codeTva;
    }

    /**
     * @return the tauxTva
     */
    public double getTauxTva() {
        return tauxTva;
    }

    /**
     * @param codeTva the codeTva to set
     */
    public void setCodeTva(int codeTva) {
        this.codeTva = codeTva;
    }

    /**
     * @param tauxTva the tauxTva to set
     */
    public void setTauxTva(double tauxTva) {
        this.tauxTva = tauxTva;
    }

    @Override
    public String toString() {
        return "TVA : codeTva = " + codeTva + " tauxTva = " + tauxTva;
    }

}