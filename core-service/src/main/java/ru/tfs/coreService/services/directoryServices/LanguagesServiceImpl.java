package ru.tfs.coreService.services.directoryServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tfs.coreService.entities.directories.Languages;
import ru.tfs.coreService.repositories.directRepositories.LanguagesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LanguagesServiceImpl implements LanguagesService{

    private final LanguagesRepository languagesRepository;

    @Autowired
    public LanguagesServiceImpl(LanguagesRepository languagesRepository) {
        this.languagesRepository = languagesRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Languages> findAll() {
        return languagesRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Languages> findById(Long id) {
        return languagesRepository.findById(id);
    }

    @Transactional
    @Override
    public Languages save(Languages languages) {
        return languagesRepository.save(languages);
    }

    @Transactional
    @Override
    public List<Languages> saveAll(List<Languages> languagesList) {
        return languagesRepository.saveAll(languagesList);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        languagesRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteAll() {
        languagesRepository.deleteAll();
    }
}
