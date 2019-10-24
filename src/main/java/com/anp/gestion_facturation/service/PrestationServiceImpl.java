package com.anp.gestion_facturation.service;

import java.util.List;
import java.util.Optional;

import com.anp.gestion_facturation.model.dao.PrestationRepo;
import com.anp.gestion_facturation.model.entity.Prestation;
import com.anp.gestion_facturation.service.PrestationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PrestationServiceImpl
 */
@Service
public class PrestationServiceImpl implements PrestationService {

    private PrestationRepo prestationRepo;

    @Autowired
    public PrestationServiceImpl(PrestationRepo prestationRepo) {
        this.prestationRepo = prestationRepo;
    }

    @Override
    public List<Prestation> findAll() {
        return prestationRepo.findAll();
    }

    @Override
    public Prestation findById(int id) {

        Optional<Prestation> result = prestationRepo.findById(id);
        Prestation prestation = null;

        if (result.isPresent()) {
            prestation = result.get();
        } else {
            throw new RuntimeException("Couldn t find this prestation with this id " + id);
        }
        return prestation;
    }

    @Override
    public void save(Prestation prestation) {
        prestationRepo.save(prestation);
    }

    @Override
    public void deleteById(int id) {
        prestationRepo.deleteById(id);
    }

    @Override
    public List<Prestation> findByPortId(Integer portId) {
        return prestationRepo.findByPortId(portId);
    }

}