package com.anp.gestion_facturation.controllers.rest;

import com.anp.gestion_facturation.model.entity.Prestation;
import com.anp.gestion_facturation.service.PrestationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PrestationRestController
 */
@RestController
@RequestMapping("/api/prestations")
public class PrestationRestController {

    @Autowired
    private PrestationService prestationService;

    @GetMapping("/{prestationId}")
    public Prestation getPrestationInfo(@PathVariable int prestationId) {
        Prestation prestation = prestationService.findById(prestationId);

        if (prestation == null) {
            throw new RuntimeException("Prestation with this id is not found");
        }
        return prestation;
    }

}