package com.anp.gestion_facturation.model.dao;

import com.anp.gestion_facturation.model.entity.Facture;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * FactureRepo
 */
public interface FactureRepo extends JpaRepository<Facture,Integer> {

    
}