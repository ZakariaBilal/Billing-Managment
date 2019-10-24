package com.anp.gestion_facturation.service;

import java.util.List;
import java.util.Optional;

import com.anp.gestion_facturation.model.dao.ReglementRepo;
import com.anp.gestion_facturation.model.entity.Reglement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ReglementServiceImpl
 */
@Service
public class ReglementServiceImpl implements ReglementService {

    private ReglementRepo reglementRepo;

    @Autowired
    public ReglementServiceImpl(ReglementRepo reglementRepo) {
        this.reglementRepo = reglementRepo;
    }

    @Override
    public List<Reglement> findAll() {
        return reglementRepo.findAll();
    }

    @Override
    public Reglement findById(int id) {

        Optional<Reglement> result = reglementRepo.findById(id);
        Reglement reglement = null;
        if (result.isPresent()) {
            reglement = result.get();
        } else {
            throw new RuntimeException("Couldnt find the reglement with this id " + id);
        }
        return reglement;
    }

    @Override
    public void save(Reglement reglement) {
        reglementRepo.save(reglement);
    }

    @Override
    public void deleteById(int id) {
        reglementRepo.deleteById(id);
    }

}