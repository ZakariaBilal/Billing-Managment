package com.anp.gestion_facturation.model.dao;

import com.anp.gestion_facturation.model.entity.Reglement;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ReglementRepo
 */
public interface ReglementRepo extends JpaRepository<Reglement,Integer> {

    
}