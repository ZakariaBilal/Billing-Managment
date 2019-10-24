package com.anp.gestion_facturation.service;

import java.util.List;

import com.anp.gestion_facturation.model.entity.LigneBulletin;

/**
 * LigneBulletinService
 */
public interface LigneBulletinService {

    
    public List<LigneBulletin> findAll();

    public LigneBulletin findById(int id);

    public void save(LigneBulletin ligneBulletin);

    public void deleteById(int id);
}