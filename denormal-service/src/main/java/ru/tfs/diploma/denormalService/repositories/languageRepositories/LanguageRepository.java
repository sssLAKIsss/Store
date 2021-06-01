package ru.tfs.diploma.denormalService.repositories.languageRepositories;

import ru.tfs.diploma.denormalService.models.Language;

import java.util.List;
import java.util.Optional;

public interface LanguageRepository {

    void saveLanguagesInMemory();
    void clearLanguagesInMemory();
    List<Language> findAllLanguagesFromInMemoryDB();
    Optional<Language> findLanguageFromInMemoryDB(Long id);
}
