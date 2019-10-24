package com.anp.gestion_facturation.service;

import java.util.List;
import java.util.Optional;

import com.anp.gestion_facturation.model.dao.TypeBulletinRepo;
import com.anp.gestion_facturation.model.entity.TypeBulletin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TypeBulletinServiceImpl
 */
@Service
public class TypeBulletinServiceImpl implements TypeBulletinService {

    private TypeBulletinRepo typeBulletinRepo;

    @Autowired
    public TypeBulletinServiceImpl(TypeBulletinRepo typeBulletinRepo) {
        this.typeBulletinRepo = typeBulletinRepo;
    }

    @Override
    public List<TypeBulletin> findAll() {
        return typeBulletinRepo.findAll();
    }

    @Override
    public TypeBulletin findById(int id) {

        Optional<TypeBulletin> result = typeBulletinRepo.findById(id);
        TypeBulletin typeBulletin = null;

        if (result.isPresent()) {
            typeBulletin = result.get();
        } else {
            throw new RuntimeException("Couldn t find this type bulletin with this id " + id);
        }
        return typeBulletin;
    }

    @Override
    public void save(TypeBulletin typeBulletin) {
        typeBulletinRepo.save(typeBulletin);
    }

    @Override
    public void deleteById(int id) {
        typeBulletinRepo.deleteById(id);
    }

}