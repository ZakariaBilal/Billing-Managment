package com.anp.gestion_facturation.model.dao;

import com.anp.gestion_facturation.model.entity.Penalite;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PenaliteRepo
 */
public interface PenaliteRepo extends JpaRepository<Penalite, Integer> {

}