package com.anp.gestion_facturation.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * PenaliteTest
 */
@Entity
public class Penalite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;
    private int jourPenalite;
    private double montantPenalite;
    private String libellePenalite;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getJourPenalite() {
        return jourPenalite;
    }

    public void setJourPenalite(int jourPenalite) {
        this.jourPenalite = jourPenalite;
    }

    public double getMontantPenalite() {
        return montantPenalite;
    }

    public void setMontantPenalite(double montantPenalite) {
        this.montantPenalite = montantPenalite;
    }

    public Penalite() {
    }

    public String getLibellePenalite() {
        return libellePenalite;
    }

    public void setLibellePenalite(String libellePenalite) {
        this.libellePenalite = libellePenalite;
    }

    public Penalite(int jourPenalite, double montantPenalite, String libellePenalite) {
        this.jourPenalite = jourPenalite;
        this.montantPenalite = montantPenalite;
        this.libellePenalite = libellePenalite;
    }

}