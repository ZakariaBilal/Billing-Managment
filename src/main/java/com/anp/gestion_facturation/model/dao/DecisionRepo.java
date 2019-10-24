package com.anp.gestion_facturation.model.dao;

import com.anp.gestion_facturation.model.entity.Decision;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DecisionRepo
 */
public interface DecisionRepo extends JpaRepository<Decision, Integer> {

}