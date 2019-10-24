package com.anp.gestion_facturation.controllers.admin.parametrages;

import com.anp.gestion_facturation.model.dao.PortRepo;
import com.anp.gestion_facturation.model.entity.Port;

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
public class PortTableController {

    private PortRepo portRepo;

    @Autowired
    public PortTableController(PortRepo portRepo) {
        this.portRepo = portRepo;
    }

    @GetMapping(value = "/ports")
    public String displayPortTable(Model model) {
        model.addAttribute("ports", portRepo.findAll());

        return "admin/parametrages/ports";
    }

    @GetMapping(value = "/ports/add")
    public String displayAddPortForm(Model model) {
        model.addAttribute("port", new Port());

        return "admin/parametrages/ajout/ajouterPort";
    }

    @PostMapping(value = "/ports")
    public String addPort(@ModelAttribute Port port) {
        portRepo.save(port);
        return "redirect:/parametrages/ports";
    }

    @GetMapping(value = "/ports/edit/{portId}")
    public String editBanque(Model model, @PathVariable int portId) {
        model.addAttribute("port", portRepo.findById(portId));

        return "admin/parametrages/ajout/ajouterPort";
    }

    @GetMapping(value = "/ports/delete/{portId}")
    public String deleteBanque(@PathVariable int portId) {
        portRepo.deleteById(portId);
        return "redirect:/parametrages/ports";
    }
}