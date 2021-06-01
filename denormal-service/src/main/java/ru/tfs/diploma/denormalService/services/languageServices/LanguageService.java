package ru.tfs.diploma.denormalService.services.languageServices;

import ru.tfs.diploma.denormalService.models.Language;

import java.util.List;
import java.util.Optional;

public interface LanguageService {

    List<Language> findAll();
    Optional<Language> findById(Long id);
    void saveAllClientsInMemory();
    void clearAllClientsInMemory();
}
