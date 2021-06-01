package ru.tfs.diploma.denormalService.services.parameterServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tfs.diploma.denormalService.models.ParameterType;
import ru.tfs.diploma.denormalService.repositories.parameterRepositories.ParameterTypeRepositoryImpl;

import java.util.List;
import java.util.Optional;

@Service
public class ParameterTypeServiceImpl implements ParameterTypeService {

    private final ParameterTypeRepositoryImpl parameterTypeRepository;

    @Autowired
    public ParameterTypeServiceImpl(ParameterTypeRepositoryImpl parameterTypeRepository) {
        this.parameterTypeRepository = parameterTypeRepository;
    }

    public List<ParameterType> findAll() {
        return parameterTypeRepository.findAllParameterTypesFromInMemoryDB();
    }

    public Optional<ParameterType> findById(Long id) {
        return parameterTypeRepository.findParameterTypeFromInMemoryDB(id);
    }

    public void saveAllClientsInMemory() {
        parameterTypeRepository.saveParameterTypesInMemory();
    }

    public void clearAllClientsInMemory() {
        parameterTypeRepository.clearParameterTypesInMemory();
    }
}
