package ru.tfs.diploma.denormalService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tfs.diploma.denormalService.models.Client;
import ru.tfs.diploma.denormalService.services.clientServices.ClientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/findAll")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Client> findById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @GetMapping("/loadToInMemory")
    public void loadClientsToInMemoryDB() {
        clientService.saveAllClientsInMemory();
    }

    @GetMapping("/clearAllInMemory")
    public void clearAllClientsFromInMemoryDB() {
        clientService.clearAllClientsInMemory();
    }
}
