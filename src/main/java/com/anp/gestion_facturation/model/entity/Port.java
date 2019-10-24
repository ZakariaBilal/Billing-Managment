package com.anp.gestion_facturation.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Port
 */
@Entity
public class Port {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String location;
    private double taxeRegionale;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Port() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTaxeRegionale() {
        return taxeRegionale;
    }

    public void setTaxeRegionale(double taxeRegionale) {
        this.taxeRegionale = taxeRegionale;
    }

    public Port(String location, double taxeRegionale) {
        this.location = location;
        this.taxeRegionale = taxeRegionale;
    }

    @Override
    public String toString() {
        return "Port [id=" + id + ", location=" + location + ", taxeRegionale=" + taxeRegionale + "]";
    }

}