package com.anp.gestion_facturation.service;

import java.util.List;
import java.util.Optional;

import com.anp.gestion_facturation.model.dao.BulletinRepo;
import com.anp.gestion_facturation.model.entity.Bulletin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BulletinServiceImpl
 */
@Service
public class BulletinServiceImpl implements BulletinService {

    private BulletinRepo bulletinRepo;

    @Autowired
    public BulletinServiceImpl(BulletinRepo bulletinRepo) {
        this.bulletinRepo = bulletinRepo;
    }

    @Override
    public List<Bulletin> findAll() {
        return bulletinRepo.findAll();
    }

    @Override
    public Bulletin findById(int id) {
        Optional<Bulletin> result = bulletinRepo.findById(id);
        Bulletin bulletin = null;

        if (result.isPresent()) {
            bulletin = result.get();
        } else {
            throw new RuntimeException("Couldn t find a bulletin with this id" + id);
        }
        return bulletin;
    }

    @Override
    public void save(Bulletin bulletin) {
        bulletinRepo.save(bulletin);
    }

    @Override
    public void deleteById(int id) {
        bulletinRepo.deleteById(id);
        ;
    }

}