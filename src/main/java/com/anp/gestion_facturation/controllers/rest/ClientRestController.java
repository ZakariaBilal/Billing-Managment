package com.anp.gestion_facturation.controllers.rest;

import java.util.List;

import com.anp.gestion_facturation.model.entity.Client;
import com.anp.gestion_facturation.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClientRestController
 */

@RestController
@RequestMapping("/api/clients")
public class ClientRestController {

    private ClientService clientService;

    @Autowired
    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/{clientId}")
    public Client getClient(@PathVariable int clientId) {
        Client client = clientService.findById(clientId);

        if (client == null) {
            throw new RuntimeException("Client with this is not found");
        }

        return client;

    }

}