package com.anp.gestion_facturation.model.dao;

import com.anp.gestion_facturation.model.entity.LigneFacture;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * LigneFactureRepo
 */
public interface LigneFactureRepo extends JpaRepository<LigneFacture, Integer> {

}