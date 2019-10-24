package com.anp.gestion_facturation.controllers.rest;

import java.util.List;

import com.anp.gestion_facturation.model.entity.Client;
import com.anp.gestion_facturation.model.entity.Navire;
import com.anp.gestion_facturation.service.ClientService;
import com.anp.gestion_facturation.service.NavireService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * NavireRestController
 */
@RestController
@RequestMapping("/api/navires")
public class NavireRestController {

    private NavireService navireService;
    private ClientService clientService;

    @Autowired
    public NavireRestController(NavireService navireService, ClientService clientService) {
        this.navireService = navireService;
        this.clientService = clientService;
    }

    @GetMapping("")
    public List<Navire> findAll() {
        return navireService.findAll();
    }

    @GetMapping("/{navireId}")
    public Navire getNavire(@PathVariable int navireId) {
        Navire navire = navireService.findById(navireId);

        if (navire == null) {
            throw new RuntimeException("Navire with this is not found");
        }

        return navire;

    }

    @GetMapping("/client/{clientId}")
    public List<Navire> getNavireForClient(@PathVariable int clientId) {
        Client client = clientService.findById(clientId);
        if (client == null) {
            throw new RuntimeException("Client with this id is not found");
        }

        return client.getNavires();
    }

}