package com.anp.gestion_facturation.controllers.admin.parametrages;

import com.anp.gestion_facturation.model.entity.Client;
import com.anp.gestion_facturation.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClientTableController
 */
@Controller
@RequestMapping("/parametrages")
public class ClientTableController {

    private ClientService clientService;

    @Autowired
    public ClientTableController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/clients")
    public String displayClients(Model model) {
        model.addAttribute("clients", clientService.findAll());

        return "admin/parametrages/clients";
    }

    @GetMapping(value = "/clients/add")
    public String displayAddClientForm(Model model) {
        model.addAttribute("client", new Client());
        return "admin/parametrages/ajout/ajouterClient";
    }

    @PostMapping(value = "/clients")
    public String addClient(@ModelAttribute Client client) {
        clientService.save(client);
        return "redirect:/parametrages/clients";
    }

    @GetMapping(value = "/clients/{idClient}")
    public String displayClient(Model model, @PathVariable int idClient) {
        model.addAttribute("client", clientService.findById(idClient));

        return "admin/parametrages/viewEntity/viewClient";
    }

    @GetMapping(value = "/clients/edit/{idClient}")
    public String editClient(Model model, @PathVariable int idClient) {
        model.addAttribute("client", clientService.findById(idClient));

        return "admin/parametrages/ajout/ajouterClient";
    }

    @GetMapping(value = "/clients/delete/{idClient}")
    public String deleteClient(Model model, @PathVariable int idClient) {
        clientService.deleteById(idClient);

        return "redirect:/parametrages/clients";
    }

}