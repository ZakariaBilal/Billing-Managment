package com.anp.gestion_facturation.controllers.admin.parametrages;

import com.anp.gestion_facturation.model.entity.Navire;
import com.anp.gestion_facturation.service.CategorieNavireService;
import com.anp.gestion_facturation.service.ClientService;
import com.anp.gestion_facturation.service.NavireService;
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
 * NavireTableController
 */
@Controller
@RequestMapping("/parametrages")
public class NavireTableController {

    private NavireService navireService;
    private ClientService clientService;
    private PavillonService pavillonService;
    private CategorieNavireService categorieNavireService;

    @Autowired
    public NavireTableController(NavireService navireService, ClientService clientService,
            PavillonService pavillonService, CategorieNavireService categorieNavireService) {
        this.navireService = navireService;
        this.clientService = clientService;
        this.pavillonService = pavillonService;
        this.categorieNavireService = categorieNavireService;
    }

    @GetMapping(value = "/navires")
    public String displayNavireTable(Model model) {

        model.addAttribute("navires", navireService.findAll());

        return "admin/parametrages/navires";
    }

    @GetMapping(value = "/navires/add")
    public String displayNavireAddForm(Model model) {
        model.addAttribute("navire", new Navire());
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("pavillons", pavillonService.findAll());
        model.addAttribute("categories", categorieNavireService.findAll());

        return "admin/parametrages/ajout/ajouterNavire";
    }

    @PostMapping(value = "/navires")
    public String addNavire(@ModelAttribute Navire navire) {
        navireService.save(navire);
        return "redirect:/parametrages/navires";
    }

    @GetMapping(value = "/navires/{idNavire}")
    public String displayClient(Model model, @PathVariable int idNavire) {
        model.addAttribute("navire", navireService.findById(idNavire));

        return "admin/parametrages/viewEntity/viewNavire";
    }

    @GetMapping(value = "/navires/edit/{idNavire}")
    public String editNavire(Model model, @PathVariable int idNavire) {
        model.addAttribute("navire", navireService.findById(idNavire));
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("pavillons", pavillonService.findAll());
        model.addAttribute("categories", categorieNavireService.findAll());
        return "admin/parametrages/edit/editNavire";
    }

    @GetMapping(value = "/navires/delete/{idNavire}")
    public String deleteNavire(@PathVariable int idNavire) {
        navireService.deleteById(idNavire);
        return "redirect:/parametrages/navires";
    }
}