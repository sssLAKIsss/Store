package ru.tfs.coreService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tfs.coreService.entities.directories.Languages;
import ru.tfs.coreService.services.directoryServices.LanguagesService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/languages")
public class LanguagesController {

    private final LanguagesService languagesService;

    @Autowired
    public LanguagesController(LanguagesService languagesService) {
        this.languagesService = languagesService;
    }

    @GetMapping("/findAll")
    public List<Languages> findAll() {
        return languagesService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Languages> findById(@PathVariable Long id) {
        return languagesService.findById(id);
    }

    @PostMapping("/addLanguage")
    public Languages addLanguage(@Valid  @RequestBody Languages language) {
        return languagesService.save(language);
    }

    @PostMapping("/addLanguages")
    public List<Languages> addListOfLanguage(@Valid @RequestBody List<Languages> languages) {
        return languagesService.saveAll(languages);
    }

    @PutMapping("/updateLanguage")
    public Languages updateLanguage(@Valid @RequestBody Languages language) {
        return languagesService.save(language);
    }

    @PutMapping("/updateLanguages")
    public List<Languages> updateListOfLanguage(@Valid @RequestBody List<Languages> languages) {
        return languagesService.saveAll(languages);
    }

    @DeleteMapping("/removeLanguage/{id}")
    public String deleteLanguage(@PathVariable Long id) {
        languagesService.deleteById(id);
        return "Language removed!";
    }

    @DeleteMapping("/removeAll")
    public String deleteAllLanguages() {
        languagesService.deleteAll();
        return "All languages removed!";
    }
}
