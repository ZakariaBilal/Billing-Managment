package com.anp.gestion_facturation.service;

import java.util.List;
import java.util.Optional;

import com.anp.gestion_facturation.model.dao.DecisionRepo;
import com.anp.gestion_facturation.model.entity.Decision;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DecisionServiceImpl
 */
@Service
public class DecisionServiceImpl implements DecisionService {

    private DecisionRepo decisionRepo;

    @Autowired
    public DecisionServiceImpl(DecisionRepo decisionRepo) {
        this.decisionRepo = decisionRepo;
    }

    @Override
    public List<Decision> findAll() {
        return decisionRepo.findAll();
    }

    @Override
    public Decision findById(int id) {

        Optional<Decision> result = decisionRepo.findById(id);
        Decision decision = null;

        if (result.isPresent()) {
            decision = result.get();
        } else {
            throw new RuntimeException("Couldn t find decision with this id " + id);
        }
        return decision;
    }

    @Override
    public void save(Decision decision) {
        decisionRepo.save(decision);
    }

    @Override
    public void deleteById(int id) {
        decisionRepo.deleteById(id);
    }

}