package ru.tfs.diploma.denormalService.services.languageServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tfs.diploma.denormalService.models.Language;
import ru.tfs.diploma.denormalService.repositories.languageRepositories.LanguageRepositoryImpl;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepositoryImpl languageRepository;

    @Autowired
    public LanguageServiceImpl(LanguageRepositoryImpl languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<Language> findAll() {
        return languageRepository.findAllLanguagesFromInMemoryDB();
    }

    public Optional<Language> findById(Long id) {
        return languageRepository.findLanguageFromInMemoryDB(id);
    }

    public void saveAllClientsInMemory() {
        languageRepository.saveLanguagesInMemory();
    }

    public void clearAllClientsInMemory() {
        languageRepository.clearLanguagesInMemory();
    }
}
