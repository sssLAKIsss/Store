package ru.tfs.coreService.services.directoryServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tfs.coreService.entities.directories.ParameterType;
import ru.tfs.coreService.repositories.directRepositories.ParameterTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ParameterTypeServiceImpl implements ParameterTypeService{

    private final ParameterTypeRepository parameterTypeRepository;

    @Autowired
    public ParameterTypeServiceImpl(ParameterTypeRepository parameterTypeRepository) {
        this.parameterTypeRepository = parameterTypeRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<ParameterType> findAll() {
        return parameterTypeRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<ParameterType> findById(Long id) {
        return parameterTypeRepository.findById(id);
    }

    @Transactional
    @Override
    public ParameterType save(ParameterType parameterType) {
        return parameterTypeRepository.save(parameterType);
    }

    @Transactional
    @Override
    public List<ParameterType> saveAll(List<ParameterType> parameterTypeList) {
        return parameterTypeRepository.saveAll(parameterTypeList);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        parameterTypeRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteAll() {
        parameterTypeRepository.deleteAll();
    }
}
