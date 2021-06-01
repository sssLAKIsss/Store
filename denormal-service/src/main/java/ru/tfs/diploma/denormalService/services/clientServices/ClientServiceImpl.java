package ru.tfs.diploma.denormalService.services.clientServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tfs.diploma.denormalService.models.Client;
import ru.tfs.diploma.denormalService.repositories.clientRepositories.ClientRepositoryImpl;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepositoryImpl clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepositoryImpl clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findAll() {
        return clientRepository.findAllFromInMemoryDB();
    }

    public Optional<Client> findById(Long id) {
        return clientRepository.findClientFromInMemoryDB(id);
    }

    public void saveAllClientsInMemory() {
        clientRepository.saveClientsInMemory();
    }

    public void clearAllClientsInMemory() {
        clientRepository.clearClientsInMemory();
    }

}
