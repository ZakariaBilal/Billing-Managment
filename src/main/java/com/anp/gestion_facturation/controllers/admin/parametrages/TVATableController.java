package com.anp.gestion_facturation.controllers.admin.parametrages;

import com.anp.gestion_facturation.model.entity.TVA;
import com.anp.gestion_facturation.service.TVAService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TVATableController
 */
@Controller
@RequestMapping("/parametrages")
public class TVATableController {

    private TVAService tvaService;

    @Autowired
    public TVATableController(TVAService tvaService) {
        this.tvaService = tvaService;
    }

    @GetMapping(value = "/tvas")
    public String displayTVATable(Model model) {
        model.addAttribute("tvas", tvaService.findAll());

        return "admin/parametrages/tva";
    }

    @GetMapping(value = "/tvas/add")
    public String displayAddTVAForm(Model model) {
        model.addAttribute("tva", new TVA());

        return "admin/parametrages/ajout/ajouterTVA";
    }

    @PostMapping(value = "/tvas")
    public String addClient(@ModelAttribute TVA tva) {
        tvaService.save(tva);

        return "redirect:/parametrages/tvas";
    }

    @GetMapping(value = "/tvas/edit/{idTva}")
    public String displayAddTVAForm(Model model, @PathVariable int idTva) {
        model.addAttribute("tva", tvaService.findById(idTva));

        return "admin/parametrages/ajout/ajouterTVA";
    }

    @GetMapping(value = "/tvas/delete/{idTva}")
    public String deleteTVA(@PathVariable int idTva) {
        tvaService.deleteById(idTva);
        return "redirect:/parametrages/tvas";
    }
}