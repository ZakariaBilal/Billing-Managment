package com.anp.gestion_facturation.service;

import java.util.List;

import com.anp.gestion_facturation.model.entity.CategorieNavire;

/**
 * CategorieNavireService
 */
public interface CategorieNavireService {

    
    public List<CategorieNavire> findAll();

    public CategorieNavire findById(int id);

    public void save(CategorieNavire categorieNavire);

    public void deleteById(int id);
}