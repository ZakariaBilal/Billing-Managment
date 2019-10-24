package com.anp.gestion_facturation.service;

import java.util.List;

import com.anp.gestion_facturation.model.entity.Pavillon;

/**
 * PavillonService
 */
public interface PavillonService {

    public List<Pavillon> findAll();

    public Pavillon findById(int id);

    public void save(Pavillon pavillon);

    public void deleteById(int id);
}