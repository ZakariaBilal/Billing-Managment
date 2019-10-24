package com.anp.gestion_facturation.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * TrancheTarif
 */
@Entity
public class TrancheTarif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codeTranche;

    @ManyToOne
    @JoinColumn(name = "codePrestation")
    private Prestation prestation;

    private int minCondition = 0;
    private int maxCondition = 0;

    private int minJour = 0;
    private int maxJour = 0;

    private double montant;

    private double montantMinimum=0;

    public TrancheTarif() {
    }

    public Prestation getPrestation() {
        return prestation;
    }

    public void setPrestation(Prestation prestation) {
        this.prestation = prestation;
    }

    public int getMinCondition() {
        return minCondition;
    }

    public void setMinCondition(int minCondition) {
        this.minCondition = minCondition;
    }

    public int getMinJour() {
        return minJour;
    }

    public void setMinJour(int minJour) {
        this.minJour = minJour;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public int getCodeTranche() {
        return codeTranche;
    }

    public void setCodeTranche(int codeTranche) {
        this.codeTranche = codeTranche;
    }

    public int getMaxCondition() {
        return maxCondition;
    }

    public void setMaxCondition(int maxCondition) {
        this.maxCondition = maxCondition;
    }

    public int getMaxJour() {
        return maxJour;
    }

    public void setMaxJour(int maxJour) {
        this.maxJour = maxJour;
    }

    public TrancheTarif(int minCondition, int maxCondition, int minJour, int maxJour, double montant) {
        this.minCondition = minCondition;
        this.maxCondition = maxCondition;
        this.minJour = minJour;
        this.maxJour = maxJour;
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "TrancheTarif [codeTranche=" + codeTranche + ", maxCondition=" + maxCondition + ", maxJour=" + maxJour
                + ", minCondition=" + minCondition + ", minJour=" + minJour + ", montant=" + montant + "]";
    }

    public double getMontantMinimum() {
        return montantMinimum;
    }

    public void setMontantMinimum(double montantMinimum) {
        this.montantMinimum = montantMinimum;
    }

}