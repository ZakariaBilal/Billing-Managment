package com.anp.gestion_facturation.service;

import java.util.List;
import java.util.Optional;

import com.anp.gestion_facturation.model.dao.PavillonRepo;
import com.anp.gestion_facturation.model.entity.Pavillon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PavillonServiceImpl
 */
@Service
public class PavillonServiceImpl implements PavillonService {

    private PavillonRepo pavillonRepo;

    @Autowired
    public PavillonServiceImpl(PavillonRepo pavillonRepo) {
        this.pavillonRepo = pavillonRepo;
    }

    @Override
    public List<Pavillon> findAll() {
        return pavillonRepo.findAll();
    }

    @Override
    public Pavillon findById(int id) {

        Optional<Pavillon> result = pavillonRepo.findById(id);
        Pavillon pavillon = null;
        if (result.isPresent()) {
            pavillon = result.get();
        } else {
            throw new RuntimeException("Couldnt find pavillon with this id" + id);
        }
        return pavillon;
    }

    @Override
    public void save(Pavillon pavillon) {
        pavillonRepo.save(pavillon);
    }

    @Override
    public void deleteById(int id) {
        pavillonRepo.deleteById(id);
    }
}