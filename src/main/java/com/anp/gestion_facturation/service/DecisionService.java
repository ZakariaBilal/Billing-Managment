package com.anp.gestion_facturation.service;

import java.util.List;

import com.anp.gestion_facturation.model.entity.Decision;

/**
 * DecisionService
 */
public interface DecisionService {

    
    public List<Decision> findAll();

    public Decision findById(int id);

    public void save(Decision decision);

    public void deleteById(int id);
}