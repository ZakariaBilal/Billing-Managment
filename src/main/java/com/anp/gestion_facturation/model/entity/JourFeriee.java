package com.anp.gestion_facturation.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * JourFeriee
 */
@Entity
public class JourFeriee {

    @Id
    private int id;
    private Date dateFeriee;
    private String libelle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateFeriee() {
        return dateFeriee;
    }

    public void setDateFeriee(Date dateFeriee) {
        this.dateFeriee = dateFeriee;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public JourFeriee() {
    }

    public JourFeriee(Date dateFeriee, String libelle) {
        this.dateFeriee = dateFeriee;
        this.libelle = libelle;
    }

}