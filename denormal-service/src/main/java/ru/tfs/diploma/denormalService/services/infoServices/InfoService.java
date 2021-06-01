package ru.tfs.diploma.denormalService.services.infoServices;

import ru.tfs.diploma.denormalService.dto.InfoDto;

import java.util.List;
import java.util.Optional;

public interface InfoService {

    List<InfoDto> findAll();
    Optional<InfoDto> findById(Long id);
    void saveAllClientsInMemory();
    void clearAllClientsInMemory();
}
