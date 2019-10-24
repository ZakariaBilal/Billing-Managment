package com.anp.gestion_facturation.service;

import java.util.List;

import com.anp.gestion_facturation.model.entity.Reglement;

/**
 * ReglementService
 */
public interface ReglementService {

    
    public List<Reglement> findAll();

    public Reglement findById(int id);

    public void save(Reglement reglement);

    public void deleteById(int id);
}