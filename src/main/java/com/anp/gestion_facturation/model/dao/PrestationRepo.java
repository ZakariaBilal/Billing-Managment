package com.anp.gestion_facturation.model.dao;

import java.util.List;

import com.anp.gestion_facturation.model.entity.Prestation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * PrestationRepo
 */
public interface PrestationRepo extends JpaRepository<Prestation, Integer> {

    @Query(value = "SELECT * FROM prestation where port = ?1", nativeQuery = true)
    List<Prestation> findByPortId(Integer portId);
}