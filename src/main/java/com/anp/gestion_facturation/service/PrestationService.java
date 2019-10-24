package com.anp.gestion_facturation.service;

import java.util.List;

import com.anp.gestion_facturation.model.entity.Prestation;

/**
 * PrestationService
 */
public interface PrestationService {

    public List<Prestation> findAll();

    public Prestation findById(int id);

    public void save(Prestation prestation);

    public void deleteById(int id);

    public List<Prestation> findByPortId(Integer portId);
}