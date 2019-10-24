package com.anp.gestion_facturation.service;

import java.util.List;

import com.anp.gestion_facturation.model.entity.TVA;

/**
 * TVAService
 */
public interface TVAService {

    public List<TVA> findAll();

    public TVA findById(int id);

    public void save(TVA tva);

    public void deleteById(int id);
}