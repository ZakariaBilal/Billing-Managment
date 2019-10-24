package com.anp.gestion_facturation.service;

import java.util.List;
import java.util.Optional;

import com.anp.gestion_facturation.model.dao.CategorieNavireRepo;
import com.anp.gestion_facturation.model.entity.CategorieNavire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CategorieNavireServiceImpl
 */
@Service
public class CategorieNavireServiceImpl implements CategorieNavireService {

    private CategorieNavireRepo categorieNavireRepo;

    @Autowired
    public CategorieNavireServiceImpl(CategorieNavireRepo categorieNavireRepo) {
        this.categorieNavireRepo = categorieNavireRepo;
    }

    @Override
    public List<CategorieNavire> findAll() {
        return categorieNavireRepo.findAll();
    }

    @Override
    public CategorieNavire findById(int id) {

        Optional<CategorieNavire> result = categorieNavireRepo.findById(id);

        CategorieNavire categorieNavire = null;

        if (result.isPresent()) {
            categorieNavire = result.get();
        } else {
            throw new RuntimeException("Couldn t find this categorie navire");
        }
        return categorieNavire;
    }

    @Override
    public void save(CategorieNavire categorieNavire) {
        categorieNavireRepo.save(categorieNavire);
    }

    @Override
    public void deleteById(int id) {
        categorieNavireRepo.deleteById(id);
    }

}