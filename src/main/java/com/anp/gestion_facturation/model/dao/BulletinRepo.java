package com.anp.gestion_facturation.model.dao;

import com.anp.gestion_facturation.model.entity.Bulletin;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * BulletinRepo
 */
public interface BulletinRepo extends JpaRepository<Bulletin, Integer> {

}