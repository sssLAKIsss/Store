package ru.tfs.coreService.services.directoryServices;


import ru.tfs.coreService.entities.directories.Languages;

import java.util.List;
import java.util.Optional;


public interface LanguagesService {
    List<Languages> findAll();
    Optional<Languages> findById(Long id);
    Languages save(Languages languages);
    List<Languages> saveAll(List<Languages> languagesList);
    void deleteById(Long id);
    void deleteAll();
}
