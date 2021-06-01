package ru.tfs.diploma.denormalService.repositories.parameterRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.tfs.diploma.denormalService.feignClient.Feign;
import ru.tfs.diploma.denormalService.models.ParameterType;

import java.util.List;
import java.util.Optional;

@Repository
public class ParameterTypeRepositoryImpl implements ParameterTypeRepository {

    private final Feign feign;
    private List<ParameterType> parameterTypeList;

    @Autowired
    public ParameterTypeRepositoryImpl(Feign feign, List<ParameterType> parameterTypeList) {
        this.feign = feign;
        this.parameterTypeList = parameterTypeList;
    }

    public void saveParameterTypesInMemory() {
        parameterTypeList = feign.findAllParameters();
    }

    public void clearParameterTypesInMemory() {
        parameterTypeList.clear();
    }

    public List<ParameterType> findAllParameterTypesFromInMemoryDB() {
        return parameterTypeList;
    }

    public Optional<ParameterType> findParameterTypeFromInMemoryDB(Long id) {
        return parameterTypeList.stream().
                filter(client -> client.getId() == id).
                findFirst();
    }
}
