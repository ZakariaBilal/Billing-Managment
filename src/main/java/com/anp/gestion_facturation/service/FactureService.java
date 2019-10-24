package com.anp.gestion_facturation.service;

import java.util.List;

import com.anp.gestion_facturation.model.entity.Facture;

/**
 * FactureService
 */
public interface FactureService {

    
    public List<Facture> findAll();

    public Facture findById(int id);

    public void save(Facture facture);

    public void deleteById(int id);
}