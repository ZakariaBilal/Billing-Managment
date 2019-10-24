package com.anp.gestion_facturation.service;

import java.util.List;
import java.util.Optional;

import com.anp.gestion_facturation.model.dao.ClientRepo;
import com.anp.gestion_facturation.model.entity.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClientServiceImpl
 */
@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepo clientRepo;

    @Autowired
    public ClientServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    public List<Client> findAll() {
        return clientRepo.findAll();
    }

    @Override
    public Client findById(int id) {

        Optional<Client> result = clientRepo.findById(id);

        Client client = null;
        if (result.isPresent()) {
            client = result.get();
        } else {
            throw new RuntimeException("Did not find client");
        }
        return client;
    }

    @Override
    public void save(Client client) {
        clientRepo.save(client);
    }

    @Override
    public void deleteById(int id) {
        clientRepo.deleteById(id);
    }

}