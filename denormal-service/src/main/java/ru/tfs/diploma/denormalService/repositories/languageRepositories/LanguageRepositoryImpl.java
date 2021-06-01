package ru.tfs.diploma.denormalService.repositories.languageRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.tfs.diploma.denormalService.feignClient.Feign;
import ru.tfs.diploma.denormalService.models.Language;

import java.util.List;
import java.util.Optional;

@Repository
public class LanguageRepositoryImpl implements LanguageRepository {

    private final Feign feign;
    private List<Language> languageList;

    @Autowired
    public LanguageRepositoryImpl(Feign feign, List<Language> languageList) {
        this.feign = feign;
        this.languageList = languageList;
    }

    public void saveLanguagesInMemory() {
        languageList = feign.findAllLanguages();
    }

    public void clearLanguagesInMemory() {
        languageList.clear();
    }

    public List<Language> findAllLanguagesFromInMemoryDB() {
        return languageList;
    }

    public Optional<Language> findLanguageFromInMemoryDB(Long id) {
        return languageList.stream().
                filter(language -> language.getId() == id).
                findFirst();
    }
}
