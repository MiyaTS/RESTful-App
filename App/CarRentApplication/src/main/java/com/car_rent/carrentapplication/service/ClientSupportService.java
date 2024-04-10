package com.car_rent.carrentapplication.service;

import com.car_rent.carrentapplication.model.Client;
import com.car_rent.carrentapplication.model.RentApplication;
import com.car_rent.carrentapplication.repository.ClientRepository;
import com.car_rent.carrentapplication.repository.RentApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientSupportService {
    @Autowired
    private ClientRepository clientRepository;

    public Client getClient(String id) {
        var client = clientRepository.findById(id);
        if (client.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return client.get();
    }

    public void registerClientAccount(Client client) {
        if (checkIfClientExists(client.getId())) {
            throw new IllegalArgumentException();
        }
        clientRepository.save(client);
    }

    public boolean checkIfClientExists(String id) {
        var client = clientRepository.findById(id);
        return client.isPresent();
    }

    public void deleteClient(String id) {
        clientRepository.deleteById(id);
    }

    public void updateClientAccount(Client client) {
        if (!checkIfClientExists(client.getId())) {
            throw new IllegalArgumentException();
        }
        clientRepository.save(client);
    }
}
