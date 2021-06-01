package ru.tfs.diploma.denormalService.repositories.clientRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.tfs.diploma.denormalService.feignClient.Feign;
import ru.tfs.diploma.denormalService.models.Client;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private final Feign feign;
    private List<Client> clientList;

    @Autowired
    public ClientRepositoryImpl(Feign feign, List<Client> clientList) {
        this.feign = feign;
        this.clientList = clientList;
    }

    public void saveClientsInMemory() {
        clientList = feign.findAllClients();
    }

    public void clearClientsInMemory() {
        clientList.clear();
    }

    public List<Client> findAllFromInMemoryDB() {
        return clientList;
    }

    public Optional<Client> findClientFromInMemoryDB(Long id) {
        return clientList.stream().
                filter(client -> client.getId() == id).
                findFirst();
    }

}
