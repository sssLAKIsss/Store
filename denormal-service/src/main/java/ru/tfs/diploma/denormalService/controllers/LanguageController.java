package ru.tfs.diploma.denormalService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tfs.diploma.denormalService.models.Language;
import ru.tfs.diploma.denormalService.services.languageServices.LanguageService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/languages")
public class LanguageController {

    private LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/findAll")
    public List<Language> findAll() {
        return languageService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Language> findById(@PathVariable Long id) {
        return languageService.findById(id);
    }

    @GetMapping("/loadToInMemory")
    public void loadClientsToInMemoryDB() {
        languageService.saveAllClientsInMemory();
    }

    @GetMapping("/clearAllInMemory")
    public void clearAllClientsFromInMemoryDB() {
        languageService.clearAllClientsInMemory();
    }
}
