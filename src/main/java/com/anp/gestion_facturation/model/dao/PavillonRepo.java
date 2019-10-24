package com.anp.gestion_facturation.model.dao;

import com.anp.gestion_facturation.model.entity.Pavillon;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PavillonRepo
 */
public interface PavillonRepo extends JpaRepository<Pavillon, Integer> {

}