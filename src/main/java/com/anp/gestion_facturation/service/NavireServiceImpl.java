package com.anp.gestion_facturation.service;

import java.util.List;
import java.util.Optional;

import com.anp.gestion_facturation.model.dao.NavireRepo;
import com.anp.gestion_facturation.model.entity.Navire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * NavireServiceImpl
 */

@Service
public class NavireServiceImpl implements NavireService {

    private NavireRepo navireRepo;

    @Autowired
    public NavireServiceImpl(NavireRepo navireRepo) {
        this.navireRepo = navireRepo;
    }

    @Override
    public List<Navire> findAll() {
        return navireRepo.findAll();
    }

    @Override
    public Navire findById(int id) {

        Optional<Navire> result = navireRepo.findById(id);
        Navire navire = null;

        if (result.isPresent()) {
            navire = result.get();
        } else {
            throw new RuntimeException("Couldn t find this navire");
        }
        return navire;
    }

    @Override
    public void save(Navire navire) {
        navireRepo.save(navire);
    }

    @Override
    public void deleteById(int id) {
        navireRepo.deleteById(id);
    }

}