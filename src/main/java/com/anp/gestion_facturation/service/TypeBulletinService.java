package com.anp.gestion_facturation.service;

import java.util.List;

import com.anp.gestion_facturation.model.entity.TypeBulletin;

/**
 * TypeBulletinService
 */
public interface TypeBulletinService {

    public List<TypeBulletin> findAll();

    public TypeBulletin findById(int id);

    public void save(TypeBulletin typeBulletin);

    public void deleteById(int id);
}