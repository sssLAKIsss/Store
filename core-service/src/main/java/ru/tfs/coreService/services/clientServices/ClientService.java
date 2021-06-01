package ru.tfs.coreService.services.clientServices;

import ru.tfs.coreService.entities.client.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> findAll();
    Optional<Client> findById(Long id);
    Optional<Client> findByName(String name);
    Client save(Client client);
    List<Client> saveAll(List<Client> clientList);
    void deleteById(Long id);
    void deleteAll();
}
