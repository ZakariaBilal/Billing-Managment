package com.anp.gestion_facturation.model.dao;

import com.anp.gestion_facturation.model.entity.Banque;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * BanqueRepo
 */
public interface BanqueRepo extends JpaRepository<Banque, Integer> {

}