package com.anp.gestion_facturation.service;

import java.util.List;
import java.util.Optional;

import com.anp.gestion_facturation.model.dao.TVARepo;
import com.anp.gestion_facturation.model.entity.TVA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TVAServiceImpl
 */
@Service
public class TVAServiceImpl implements TVAService {

    private TVARepo tvaRepo;

    @Autowired
    public TVAServiceImpl(TVARepo tvaRepo) {
        this.tvaRepo = tvaRepo;
    }

    @Override
    public List<TVA> findAll() {
        return tvaRepo.findAll();
    }

    @Override
    public TVA findById(int id) {

        Optional<TVA> result = tvaRepo.findById(id);
        TVA tva = null;
        if (result.isPresent()) {
            tva = result.get();
        } else {
            throw new RuntimeException("Couldn t find this tva");
        }

        return tva;
    }

    @Override
    public void save(TVA tva) {
        tvaRepo.save(tva);
    }

    @Override
    public void deleteById(int id) {
        tvaRepo.deleteById(id);
    }

}