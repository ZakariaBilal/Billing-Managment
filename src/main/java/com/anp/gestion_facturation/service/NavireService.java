package com.anp.gestion_facturation.service;

import java.util.List;

import com.anp.gestion_facturation.model.entity.Navire;

/**
 * NavireService
 */
public interface NavireService {

    public List<Navire> findAll();

    public Navire findById(int id);

    public void save(Navire navire);

    public void deleteById(int id);
}