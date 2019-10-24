package com.anp.gestion_facturation.controllers.admin.parametrages;

import com.anp.gestion_facturation.model.entity.CategorieNavire;
import com.anp.gestion_facturation.service.CategorieNavireService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * CategorieNavireTableController
 */
@Controller
@RequestMapping("/parametrages")
public class CategorieNavireTableController {

    private CategorieNavireService categorieNavireService;

    @Autowired
    public CategorieNavireTableController(CategorieNavireService categorieNavireService) {
        this.categorieNavireService = categorieNavireService;
    }

    @GetMapping(value = "/categoriesNavires")
    public String displayCategoriesNaviresTable(Model model) {
        model.addAttribute("categories", categorieNavireService.findAll());

        return "admin/parametrages/categoriesNavires";
    }

    @GetMapping(value = "/categoriesNavires/add")
    public String displayAddNavireCategorieForm(Model model) {
        model.addAttribute("categorie", new CategorieNavire());

        return "admin/parametrages/ajout/ajouterCategorieNavire";
    }

    @GetMapping(value = "/categoriesNavires/edit/{idCategorie}")
    public String editCategorieNavire(Model model, @PathVariable int idCategorie) {
        model.addAttribute("categorie", categorieNavireService.findById(idCategorie));

        return "admin/parametrages/ajout/ajouterCategorieNavire";
    }

    @PostMapping(value = "/categoriesNavires")
    public String addCategorieNavire(@ModelAttribute CategorieNavire categorieNavire) {
        categorieNavireService.save(categorieNavire);

        return "redirect:/categoriesNavires";
    }

    @GetMapping(value = "/categoriesNavires/delete/{idCategorie}")
    public String deleteCategorie(@PathVariable int idCategorie) {
        categorieNavireService.deleteById(idCategorie);

        return "redirect:/categoriesNavires";
    }
}