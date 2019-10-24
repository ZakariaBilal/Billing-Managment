package com.anp.gestion_facturation.service;

import java.util.List;
import java.util.Optional;

import com.anp.gestion_facturation.model.dao.LigneBulletinRepo;
import com.anp.gestion_facturation.model.entity.LigneBulletin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * LigneBulletinServiceImpl
 */
@Service
public class LigneBulletinServiceImpl implements LigneBulletinService {

    private LigneBulletinRepo ligneBulletinRepo;

    @Autowired
    public LigneBulletinServiceImpl(LigneBulletinRepo ligneBulletinRepo) {
        this.ligneBulletinRepo = ligneBulletinRepo;
    }

    @Override
    public List<LigneBulletin> findAll() {
        return ligneBulletinRepo.findAll();
    }

    @Override
    public LigneBulletin findById(int id) {

        Optional<LigneBulletin> result = ligneBulletinRepo.findById(id);
        LigneBulletin ligneBulletin = null;

        if (result.isPresent()) {
            ligneBulletin = result.get();
        } else {
            throw new RuntimeException("Couldn t find this ligne bulletin with this id" + id);
        }
        return ligneBulletin;
    }

    @Override
    public void save(LigneBulletin ligneBulletin) {
        ligneBulletinRepo.save(ligneBulletin);
    }

    @Override
    public void deleteById(int id) {
        ligneBulletinRepo.deleteById(id);
    }

}