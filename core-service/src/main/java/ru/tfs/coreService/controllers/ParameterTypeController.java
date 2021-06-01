package ru.tfs.coreService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tfs.coreService.entities.directories.ParameterType;
import ru.tfs.coreService.services.directoryServices.ParameterTypeService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parameters")
public class ParameterTypeController {

    private final ParameterTypeService parameterTypeService;

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

    @PostMapping("/addParameter")
    public ParameterType addParameterType(@Valid  @RequestBody ParameterType parameterType) {
        return parameterTypeService.save(parameterType);
    }

    @PostMapping("/addParameters")
    public List<ParameterType> addListOfParametersType(@Valid @RequestBody List<ParameterType> parameterTypes) {
        return parameterTypeService.saveAll(parameterTypes);
    }

    @PutMapping("/updateParameter")
    public ParameterType updateParameterType(@Valid @RequestBody ParameterType parameterType) {
        return parameterTypeService.save(parameterType);
    }

    @PutMapping("/updateParameters")
    public List<ParameterType> updateListOfParametersType(@Valid @RequestBody List<ParameterType> parameterTypes) {
        return parameterTypeService.saveAll(parameterTypes);
    }

    @DeleteMapping("/remove/{id}")
    public String deleteById(@PathVariable Long id) {
        parameterTypeService.deleteById(id);
        return "ParameterType removed!";
    }

    @DeleteMapping("/removeAll")
    public String deleteAll() {
        parameterTypeService.deleteAll();
        return "All parameterTypes removed!";
    }

}
