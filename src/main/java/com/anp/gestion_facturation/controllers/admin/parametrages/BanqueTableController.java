package com.anp.gestion_facturation.controllers.admin.parametrages;

import com.anp.gestion_facturation.model.entity.Banque;
import com.anp.gestion_facturation.service.BanqueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * BanqueTableController
 */
@Controller
@RequestMapping("/parametrages")
public class BanqueTableController {

    private BanqueService banqueService;

    @Autowired
    public BanqueTableController(BanqueService banqueService) {
        this.banqueService = banqueService;
    }

    @GetMapping(value = "/banques")
    public String displayBanqueTable(Model model) {
        model.addAttribute("banques", banqueService.findAll());

        return "admin/parametrages/banques";
    }

    @GetMapping(value = "/banques/add")
    public String displayAddBanqueForm(Model model) {
        model.addAttribute("banque", new Banque());

        return "admin/parametrages/ajout/ajouterBanque";
    }

    @PostMapping(value = "/banques")
    public String addBanque(@ModelAttribute Banque banque) {
        banqueService.save(banque);
        return "redirect:/parametrages/banques";
    }

    @GetMapping(value = "/banques/edit/{banqueId}")
    public String editBanque(Model model, @PathVariable int banqueId) {
        model.addAttribute("banque", banqueService.findById(banqueId));

        return "admin/parametrages/ajout/ajouterBanque";
    }

    @GetMapping(value = "/banques/delete/{banqueId}")
    public String deleteBanque(@PathVariable int banqueId) {
        banqueService.deleteById(banqueId);
        return "redirect:/parametrages/banques";
    }
}