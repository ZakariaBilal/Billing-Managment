package com.anp.gestion_facturation.service;

import java.util.List;
import java.util.Optional;

import com.anp.gestion_facturation.model.dao.BanqueRepo;
import com.anp.gestion_facturation.model.entity.Banque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BanqueServiceImpl
 */
@Service
public class BanqueServiceImpl implements BanqueService {

    private BanqueRepo banqueRepo;

    @Autowired
    public BanqueServiceImpl(BanqueRepo banqueRepo) {
        this.banqueRepo = banqueRepo;
    }

    @Override
    public List<Banque> findAll() {
        return banqueRepo.findAll();
    }

    @Override
    public Banque findById(int id) {

        Optional<Banque> result = banqueRepo.findById(id);
        Banque banque = null;

        if (result.isPresent()) {
            banque = result.get();
        } else {
            throw new RuntimeException("Couldn t find the banque with this id " + id);
        }
        return banque;
    }

    @Override
    public void save(Banque banque) {
        banqueRepo.save(banque);
    }

    @Override
    public void deleteById(int id) {
        banqueRepo.deleteById(id);
    }

}