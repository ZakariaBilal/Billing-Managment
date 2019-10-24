package com.anp.gestion_facturation.service;

import java.util.List;
import java.util.Optional;

import com.anp.gestion_facturation.model.dao.FactureRepo;
import com.anp.gestion_facturation.model.entity.Facture;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * FactureServiceImpl
 */
@Service
public class FactureServiceImpl implements FactureService {

    private FactureRepo factureRepo;

    @Autowired
    public FactureServiceImpl(FactureRepo factureRepo) {
        this.factureRepo = factureRepo;
    }

    @Override
    public List<Facture> findAll() {
        return factureRepo.findAll();
    }

    @Override
    public Facture findById(int id) {

        Optional<Facture> result = factureRepo.findById(id);
        Facture facture = null;

        if (result.isPresent()) {
            facture = result.get();
        } else {
            throw new RuntimeException("Couldn t find the facture with this id " + id);
        }
        return facture;
    }

    @Override
    public void save(Facture facture) {
        factureRepo.save(facture);
    }

    @Override
    public void deleteById(int id) {
        factureRepo.deleteById(id);
    }

}