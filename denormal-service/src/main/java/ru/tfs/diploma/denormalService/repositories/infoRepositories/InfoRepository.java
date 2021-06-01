package ru.tfs.diploma.denormalService.repositories.infoRepositories;

import ru.tfs.diploma.denormalService.dto.InfoDto;
import ru.tfs.diploma.denormalService.models.Info;

import java.util.List;
import java.util.Optional;

public interface InfoRepository {

    void saveInfosInMemory();
    void clearInfosInMemory();
    List<Info> findAllInfosFromInMemoryDB();
    Optional<Info> findInfoFromInMemoryDB(Long id);

    void saveAllInfoDto();
    void clearAllInfoDtoInMemory();
    List<InfoDto> findAllInfoDto();
    Optional<InfoDto> findInfoDtoById(Long id);
}
