package ru.tfs.coreService.controllers;

import org.springframework.web.bind.annotation.*;
import ru.tfs.coreService.entities.client.Client;
import ru.tfs.coreService.services.clientServices.ClientService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;
//    private ClientValidator clientValidator;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
//        this.clientValidator = clientValidator;
    }

    @GetMapping("/findAll")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Client> findById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @PostMapping("/addClient")
    public Client addClient(@Valid @RequestBody  Client client) {
        return clientService.save(client);
    }

    @PostMapping("/addClients")
    public List<Client> addListOfClients(@Valid @RequestBody List<Client> clientList) {

        return clientService.saveAll(clientList);
    }

    @PutMapping("/updateClient")
    public Client updateClient(@Valid @RequestBody Client client) {
        return clientService.save(client);
    }

    @PutMapping("/updateClients")
    public List<Client> updateListOfClients(@Valid @RequestBody List<Client> clientList) {
        return clientService.saveAll(clientList);
    }

    @DeleteMapping("/remove/{id}")
    public String deleteById(@PathVariable Long id) {
        clientService.deleteById(id);
        return "Client removed!";
    }

    @DeleteMapping("/removeAll")
    public String deleteAll() {
        clientService.deleteAll();
        return "All clients removed!";
    }

}
