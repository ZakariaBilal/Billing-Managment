package com.anp.gestion_facturation.model.dao;

import com.anp.gestion_facturation.model.entity.Navire;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * NavireRepo
 */
public interface NavireRepo extends JpaRepository<Navire, Integer> {

}