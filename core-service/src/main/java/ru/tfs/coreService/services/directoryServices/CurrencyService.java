package ru.tfs.coreService.services.directoryServices;

import ru.tfs.coreService.entities.directories.Currency;

import java.util.List;
import java.util.Optional;

public interface CurrencyService {
    List<Currency> findAll();
    Optional<Currency> findById(Long id);
    Currency save(Currency currency);
    List<Currency> saveAll(List<Currency> currencyList);
    void deleteById(Long id);
    void deleteAll();
}
