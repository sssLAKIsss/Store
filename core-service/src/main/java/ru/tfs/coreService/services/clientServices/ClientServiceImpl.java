package ru.tfs.coreService.services.clientServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tfs.coreService.entities.client.Client;
import ru.tfs.coreService.repositories.clientRepository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Client> findByName(String name) {
        return clientRepository.findByName(name);
    }

    @Transactional
    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Transactional
    @Override
    public List<Client> saveAll(List<Client> clientList) {
        return clientRepository.saveAll(clientList);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteAll() {
        clientRepository.deleteAll();
    }
}
