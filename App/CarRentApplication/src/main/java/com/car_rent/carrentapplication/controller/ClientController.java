package com.car_rent.carrentapplication.controller;

import com.car_rent.carrentapplication.model.Client;
import com.car_rent.carrentapplication.service.ClientSupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/client")
public class ClientController {
    private final ClientSupportService clientSupportService;

    @Autowired
    public ClientController(ClientSupportService clientSupportService) {
        this.clientSupportService = clientSupportService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{clientId}"
    )
    public @ResponseBody Client getClient(@PathVariable String clientId) {
        return clientSupportService.getClient(clientId);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/account",
            headers = "Accept=" + MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public void createClientAccount(@RequestBody Client client) {
        clientSupportService.registerClientAccount(client);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/account",
            headers = "Accept=" + MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public void updateClient(@RequestBody Client client) {
        clientSupportService.updateClientAccount(client);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{clientId}"
    )
    @ResponseStatus(HttpStatus.OK)
    public void deleteClient(@PathVariable String clientId) {
        clientSupportService.deleteClient(clientId);
    }

    @RequestMapping(
            method = RequestMethod.HEAD,
            value = "/account/{clientId}"
    )
    @ResponseStatus(HttpStatus.OK)
    public void clientExists(@PathVariable String clientId) {
        if (clientSupportService.checkIfClientExists(clientId)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Client already exists");
        }
    }
}
