package com.anp.gestion_facturation.service;

import java.util.List;

import com.anp.gestion_facturation.model.entity.Client;

/**
 * ClientService
 */
public interface ClientService {

    public List<Client> findAll();

    public Client findById(int id);

    public void save(Client client);

    public void deleteById(int id);

}