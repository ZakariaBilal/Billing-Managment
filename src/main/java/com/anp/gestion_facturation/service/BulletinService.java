package com.anp.gestion_facturation.service;

import java.util.List;



import com.anp.gestion_facturation.model.entity.Bulletin;

/**
 * BulletinService
 */
public interface BulletinService {

    public List<Bulletin> findAll();

    public Bulletin findById(int id);

    public void save(Bulletin bulletin);

    public void deleteById(int id);


}