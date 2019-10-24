package com.anp.gestion_facturation.model.dao;

import com.anp.gestion_facturation.model.entity.Client;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ClientRepo
 */
public interface ClientRepo extends JpaRepository<Client, Integer> {

}