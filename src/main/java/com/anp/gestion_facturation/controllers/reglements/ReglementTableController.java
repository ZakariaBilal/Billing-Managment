package com.anp.gestion_facturation.controllers.reglements;

import com.anp.gestion_facturation.model.entity.Facture;
import com.anp.gestion_facturation.model.entity.Reglement;
import com.anp.gestion_facturation.service.BanqueService;
import com.anp.gestion_facturation.service.FactureService;
import com.anp.gestion_facturation.service.ReglementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * ReglementTableController
 */
@Controller
public class ReglementTableController {

    private ReglementService reglementService;
    private BanqueService banqueService;
    private FactureService factureService;

    @Autowired
    public ReglementTableController(ReglementService reglementService, BanqueService banqueService) {
        this.reglementService = reglementService;
        this.banqueService = banqueService;
    }

    @GetMapping("/reglementation")
    public String displayFacturesToReglementation(Model model) {
        model.addAttribute("factures", factureService.findAll());

        return "reglement/reglement";
    }

    @GetMapping("/reglement/{factureId}")
    public String displayReglementForm(Model model, @PathVariable int factureId) {

        Facture facture = factureService.findById(factureId);
        Reglement reglement = new Reglement();
        reglement.setFacture(facture);
        model.addAttribute("banques", banqueService.findAll());
        model.addAttribute("reglement", reglement);

        return "reglement/ajouterReglement";
    }

    @PostMapping("/ajouterReglement")
    public String ajouterReglement(@ModelAttribute Reglement reglement) {
        reglement.getFacture().setFactureReglee(true);
        reglementService.save(reglement);
        return "redirect:/reglementation";
    }

}