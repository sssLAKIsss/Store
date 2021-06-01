package ru.tfs.diploma.denormalService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tfs.diploma.denormalService.models.ParameterType;
import ru.tfs.diploma.denormalService.services.parameterServices.ParameterTypeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parameters")
public class ParameterTypeController {

    private ParameterTypeService parameterTypeService;

    @Autowired
    public ParameterTypeController(ParameterTypeService parameterTypeService) {
        this.parameterTypeService = parameterTypeService;
    }

    @GetMapping("/findAll")
    public List<ParameterType> findAll() {
        return parameterTypeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ParameterType> findById(@PathVariable Long id) {
        return parameterTypeService.findById(id);
    }

    @GetMapping("/loadToInMemory")
    public void loadParameterTypesToInMemoryDB() {
        parameterTypeService.saveAllClientsInMemory();
    }

    @GetMapping("/clearAllInMemory")
    public void clearAllParameterTypesFromInMemoryDB() {
        parameterTypeService.clearAllClientsInMemory();
    }
}
