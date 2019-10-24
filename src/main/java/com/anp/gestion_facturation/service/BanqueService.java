package com.anp.gestion_facturation.service;

import java.util.List;

import com.anp.gestion_facturation.model.entity.Banque;

/**
 * BanqueService
 */
public interface BanqueService {

    public List<Banque> findAll();

    public Banque findById(int id);

    public void save(Banque banque);

    public void deleteById(int id);
}