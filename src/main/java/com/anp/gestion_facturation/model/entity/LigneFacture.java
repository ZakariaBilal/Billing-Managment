package com.anp.gestion_facturation.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * LigneFacture
 */
@Entity
public class LigneFacture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;

    @OneToOne
    @JoinColumn(name = "ligneBulletin")
    private LigneBulletin ligneBulletin;

    private double montantHTC;
    private double montantTVA;
    private double montantTTC;

    @ManyToOne
    @JoinColumn(name = "code_facture")
    private Facture facture;

    /**
     * @return the facture
     */
    public Facture getFacture() {
        return facture;
    }

    /**
     * @param facture the facture to set
     */
    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public LigneFacture() {
    }

    public LigneBulletin getLigneBulletin() {
        return ligneBulletin;
    }

    public void setLigneBulletin(LigneBulletin ligneBulletin) {
        this.ligneBulletin = ligneBulletin;
    }

    public double getMontantHTC() {
        return montantHTC;
    }

    public void setMontantHTC(double montantHTC) {
        this.montantHTC = montantHTC;
    }

    public double getMontantTVA() {
        return montantTVA;
    }

    public void setMontantTVA(double montantTVA) {
        this.montantTVA = montantTVA;
    }

    public double getMontantTTC() {
        return montantTTC;
    }

    public void setMontantTTC(double montantTTC) {
        this.montantTTC = montantTTC;
    }

    @Override
    public String toString() {
        return "montantHTC=" + montantHTC + ", montantTTC=" + montantTTC + ", montantTVA=" + montantTVA + "]";
    }

    public LigneFacture(LigneBulletin ligneBulletin, double montantHTC, double montantTVA, double montantTTC) {
        this.ligneBulletin = ligneBulletin;
        this.montantHTC = montantHTC;
        this.montantTVA = montantTVA;
        this.montantTTC = montantTTC;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}