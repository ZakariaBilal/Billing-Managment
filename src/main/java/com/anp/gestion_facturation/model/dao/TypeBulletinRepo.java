package com.anp.gestion_facturation.model.dao;

import com.anp.gestion_facturation.model.entity.TypeBulletin;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TypeBulletinRepo
 */
public interface TypeBulletinRepo extends JpaRepository<TypeBulletin, Integer> {

}