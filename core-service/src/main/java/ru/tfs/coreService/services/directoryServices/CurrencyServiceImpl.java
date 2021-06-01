package ru.tfs.coreService.services.directoryServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tfs.coreService.entities.directories.Currency;
import ru.tfs.coreService.repositories.directRepositories.CurrencyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyServiceImpl implements CurrencyService{

    private final CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Currency> findAll() {
        return currencyRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Currency> findById(Long id) {
        return currencyRepository.findById(id);
    }

    @Transactional
    @Override
    public Currency save(Currency currency) {
        return currencyRepository.save(currency);
    }

    @Transactional
    @Override
    public List<Currency> saveAll(List<Currency> currencyList) {
        return currencyRepository.saveAll(currencyList);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
         currencyRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteAll() {
         currencyRepository.deleteAll();
    }

}
