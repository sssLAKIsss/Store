package ru.tfs.coreService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tfs.coreService.entities.directories.Currency;
import ru.tfs.coreService.services.directoryServices.CurrencyService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(("/currency"))
public class CurrencyController {

    private final CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/findAll")
    public List<Currency> showAllCurrencies() {
        return currencyService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Currency> getCurrencyById(@PathVariable Long id) {
        return currencyService.findById(id);
    }

    @PostMapping("/addCurrency")
    public Currency addCurrencies(@Valid  @RequestBody Currency currency) {
        return currencyService.save(currency);
    }

    @PostMapping("/addCurrencies")
    public List<Currency> addListOfCurrencies(@Valid @RequestBody List<Currency> currencyList) {
        return currencyService.saveAll(currencyList);
    }

    @PutMapping("/updateCurrency")
    public Currency updateCurrencies(@Valid @RequestBody Currency currency) {
        return currencyService.save(currency);
    }

    @PutMapping("/updateCurrencies")
    public List<Currency> updateListOfCurrencies(@Valid @RequestBody List<Currency> currencyList) {
        return currencyService.saveAll(currencyList);
    }

    @DeleteMapping("/remove/{id}")
    public String removeCurrencyById(@PathVariable Long id) {
        currencyService.deleteById(id);
        return "Currency removed!";
    }

    @DeleteMapping("/remove/removeAll")
    public String removeAllCurrencies() {
        currencyService.deleteAll();
        return "All currencies removed!";
    }

}
