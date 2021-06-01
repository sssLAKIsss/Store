package ru.tfs.diploma.denormalService.services.clientServices;

import ru.tfs.diploma.denormalService.models.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    List<Client> findAll();
    Optional<Client> findById(Long id);
    void saveAllClientsInMemory();
    void clearAllClientsInMemory();
}
