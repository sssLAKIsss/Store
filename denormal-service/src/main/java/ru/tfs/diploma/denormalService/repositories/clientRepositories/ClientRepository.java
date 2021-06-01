package ru.tfs.diploma.denormalService.repositories.clientRepositories;

import ru.tfs.diploma.denormalService.models.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    void saveClientsInMemory();
    void clearClientsInMemory();
    List<Client> findAllFromInMemoryDB();
    Optional<Client> findClientFromInMemoryDB(Long id);
}
