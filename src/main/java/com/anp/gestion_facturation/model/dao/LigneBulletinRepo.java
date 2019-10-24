package com.anp.gestion_facturation.model.dao;

import com.anp.gestion_facturation.model.entity.LigneBulletin;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * LigneBulletinRepo
 */
public interface LigneBulletinRepo extends JpaRepository<LigneBulletin,Integer>{

    
}