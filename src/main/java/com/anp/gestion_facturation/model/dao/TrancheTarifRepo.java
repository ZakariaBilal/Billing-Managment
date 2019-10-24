package com.anp.gestion_facturation.model.dao;

import com.anp.gestion_facturation.model.entity.TrancheTarif;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TrancheTarifRepo
 */
public interface TrancheTarifRepo extends JpaRepository<TrancheTarif, Integer> {

}