package ru.tfs.diploma.denormalService.services.parameterServices;

import ru.tfs.diploma.denormalService.models.ParameterType;

import java.util.List;
import java.util.Optional;

public interface ParameterTypeService {

    List<ParameterType> findAll();
    Optional<ParameterType> findById(Long id);
    void saveAllClientsInMemory();
    void clearAllClientsInMemory();
}
