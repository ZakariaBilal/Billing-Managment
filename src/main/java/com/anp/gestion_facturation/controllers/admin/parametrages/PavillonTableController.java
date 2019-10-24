package com.anp.gestion_facturation.controllers.admin.parametrages;

import com.anp.gestion_facturation.model.entity.Pavillon;
import com.anp.gestion_facturation.service.PavillonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * PavillonTableController
 */
@Controller
@RequestMapping("/parametrages")
public class PavillonTableController {

    private PavillonService pavillonService;

    @Autowired
    public PavillonTableController(PavillonService pavillonService) {
        this.pavillonService = pavillonService;
    }

    @GetMapping(value = "/pavillons")
    public String displayPavillonTable(Model model) {
        model.addAttribute("pavillons", pavillonService.findAll());
        return "admin/parametrages/pavillonNavires";
    }

    @GetMapping(value = "/pavillons/add")
    public String displayAddTVAForm(Model model) {
        model.addAttribute("pavillon", new Pavillon());

        return "admin/parametrages/ajout/ajouterPavillon";
    }

    @PostMapping(value = "/pavillons")
    public String addClient(@ModelAttribute Pavillon pavillon) {
        pavillonService.save(pavillon);

        return "redirect:/parametrages/pavillons";
    }

    @GetMapping(value = "/pavillons/edit/{idPavillon}")
    public String displayAddTVAForm(Model model, @PathVariable int idPavillon) {
        model.addAttribute("pavillon", pavillonService.findById(idPavillon));

        return "admin/parametrages/ajout/ajouterPavillon";
    }

    @GetMapping(value = "/pavillons/delete/{idPavillon}")
    public String deletePavillon(@PathVariable int idPavillon) {
        pavillonService.deleteById(idPavillon);

        return "redirect:/parametrages/pavillons";
    }

}