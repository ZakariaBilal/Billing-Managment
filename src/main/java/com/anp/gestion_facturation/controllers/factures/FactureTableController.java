package com.anp.gestion_facturation.controllers.factures;

import com.anp.gestion_facturation.model.entity.Bulletin;
import com.anp.gestion_facturation.service.BulletinService;
import com.anp.gestion_facturation.service.FactureService;
import com.anp.gestion_facturation.utils.Calculateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * FactureTableController
 */
@Controller
@RequestMapping("/factures")
public class FactureTableController {

    private BulletinService bulletinService;
    private FactureService factureService;

    @Autowired
    public FactureTableController(BulletinService bulletinService, FactureService factureService) {
        this.bulletinService = bulletinService;
        this.factureService = factureService;
    }

    @GetMapping(value = "/facturation")
    public String displayBulletinsTable(Model model, @RequestParam(required = false) String factured) {
        model.addAttribute("factured", factured);
        model.addAttribute("bulletins", bulletinService.findAll());

        return "factures/facturation";
    }

    @GetMapping(value = "/facturation/{bulletinId}")
    public String facturationBulletin(Model model, @PathVariable int bulletinId) {
        Bulletin bulletin = bulletinService.findById(bulletinId);
        if (bulletin.getFactured()) {
            return "redirect:/factures/facturation?factured=" + bulletinId;
        } else {
            model.addAttribute("facture", Calculateur.createFactureFromBulletin(bulletin));
            return "factures/bulletinFacturation";
        }
    }

    @GetMapping(value = "")
    public String displayFactureTable(Model model) {

        model.addAttribute("factures", factureService.findAll());

        return "factures/factures";
    }

    @GetMapping(value = "/facturer/{bulletinId}")
    public String facturerBulletin(Model model, @PathVariable int bulletinId) {
        Bulletin bulletin = bulletinService.findById(bulletinId);

        if (bulletin.getFactured()) {
            return "redirect:/factures/facturation?factured=" + bulletinId;
        } else {
            bulletin.setFactured(true);
            factureService.save(Calculateur.createFactureFromBulletin(bulletin));
            return "redirect:/factures";
        }
    }

    @GetMapping(value = "/view/{factureId}")
    public String viewFacture(Model model, @PathVariable int factureId) {

        model.addAttribute("facture", factureService.findById(factureId));

        return "factures/viewFacture";
    }

}