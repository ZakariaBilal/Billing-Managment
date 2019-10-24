package com.anp.gestion_facturation.model.dao;

import com.anp.gestion_facturation.model.entity.Port;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PortDAO
 */
public interface PortRepo extends JpaRepository<Port, Integer> {

}