package com.anp.gestion_facturation.controllers.admin.parametrages;

import java.util.ListIterator;

import com.anp.gestion_facturation.model.dao.PenaliteRepo;
import com.anp.gestion_facturation.model.dao.PortRepo;
import com.anp.gestion_facturation.model.entity.Prestation;
import com.anp.gestion_facturation.model.entity.TrancheTarif;
import com.anp.gestion_facturation.service.PrestationService;
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
 * PrestationsTableController
 */
@Controller
@RequestMapping("/parametrages")
public class PrestationsTableController {
    private PrestationService prestationService;
    private TVAService tvaService;
    private PenaliteRepo penaliteRepo;
    private PortRepo portRepo;

    @Autowired
    public PrestationsTableController(PrestationService prestationService, TVAService tvaService, PenaliteRepo repo,
            PortRepo portRepo) {
        this.prestationService = prestationService;
        this.tvaService = tvaService;
        this.penaliteRepo = repo;
        this.portRepo = portRepo;
    }

    @GetMapping(value = "/prestations")
    public String displayPrestationsTable(Model model) {
        model.addAttribute("prestations", prestationService.findAll());

        return "admin/parametrages/prestations";
    }

    @GetMapping(value = "/prestations/add")
    public String displayPrestationsForm(Model model) {
        model.addAttribute("prestation", new Prestation());
        model.addAttribute("tvas", tvaService.findAll());
        model.addAttribute("penalites", penaliteRepo.findAll());
        model.addAttribute("ports", portRepo.findAll());

        return "admin/parametrages/ajout/ajouterPrestation";
    }

    @PostMapping(value = "/prestations")
    public String addPrestation(@ModelAttribute Prestation prestation) {

        ListIterator<TrancheTarif> listIterator = prestation.getTranches().listIterator();
        int i = 0;
        while (listIterator.hasNext()) {
            TrancheTarif trancheTarif = listIterator.next();
            prestation.getTranches().get(i).setMaxCondition(trancheTarif.getMinCondition());
            prestation.getTranches().get(i).setMaxJour(trancheTarif.getMinJour());
            i++;
        }
        prestation.getTranches().get(prestation.getTranches().size() - 1).setMaxCondition(Integer.MAX_VALUE);
        prestation.getTranches().get(prestation.getTranches().size() - 1).setMaxJour(Integer.MAX_VALUE);
        prestationService.save(prestation);
        return "redirect:/parametrages/prestations";
    }

    @GetMapping(value = "/prestations/{idPrestation}")
    public String viewPrestation(Model model, @PathVariable int idPrestation) {
        model.addAttribute("prestation", prestationService.findById(idPrestation));

        return "admin/parametrages/viewEntity/viewPrestation";
    }

    @GetMapping(value = "/prestations/edit/{idPrestation}")
    public String editPrestation(Model model, @PathVariable int idPrestation) {
        model.addAttribute("prestation", prestationService.findById(idPrestation));
        model.addAttribute("tvas", tvaService.findAll());

        return "admin/parametrages/edit/editPrestation";
    }

    @GetMapping(value = "/prestations/delete/{idPrestation}")
    public String deletePrestation(@PathVariable int idPrestation) {
        prestationService.deleteById(idPrestation);
        return "redirect:/parametrages/prestations";
    }

}