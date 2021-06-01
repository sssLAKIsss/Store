package ru.tfs.diploma.denormalService.repositories.parameterRepositories;

import ru.tfs.diploma.denormalService.models.ParameterType;

import java.util.List;
import java.util.Optional;

public interface ParameterTypeRepository {

    void saveParameterTypesInMemory();
    void clearParameterTypesInMemory();
    List<ParameterType> findAllParameterTypesFromInMemoryDB();
    Optional<ParameterType> findParameterTypeFromInMemoryDB(Long id);
}
