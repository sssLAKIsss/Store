package ru.tfs.coreService.services.directoryServices;


import ru.tfs.coreService.entities.directories.ParameterType;

import java.util.List;
import java.util.Optional;

public interface ParameterTypeService {
    List<ParameterType> findAll();
    Optional<ParameterType> findById(Long id);
    ParameterType save(ParameterType parameterType);
    List<ParameterType> saveAll(List<ParameterType> parameterTypeList);
    void deleteById(Long id);
    void deleteAll();
}
