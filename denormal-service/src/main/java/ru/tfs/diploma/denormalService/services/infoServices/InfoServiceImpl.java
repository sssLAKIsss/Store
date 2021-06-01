package ru.tfs.diploma.denormalService.services.infoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tfs.diploma.denormalService.dto.InfoDto;
import ru.tfs.diploma.denormalService.repositories.infoRepositories.InfoRepositoryImpl;

import java.util.List;
import java.util.Optional;

@Service
public class InfoServiceImpl implements InfoService {

    private final InfoRepositoryImpl infoRepository;

    @Autowired
    public InfoServiceImpl(InfoRepositoryImpl infoRepository) {
        this.infoRepository = infoRepository;
    }

    public List<InfoDto> findAll() {
        return infoRepository.findAllInfoDto();
    }

    public Optional<InfoDto> findById(Long id) {
        return infoRepository.findInfoDtoById(id);
    }

    public void saveAllClientsInMemory() {
        infoRepository.saveAllInfoDto();
    }

    public void clearAllClientsInMemory() {
        infoRepository.clearAllInfoDtoInMemory();
    }
}
