package ru.tfs.diploma.denormalService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tfs.diploma.denormalService.models.CardProduct;
import ru.tfs.diploma.denormalService.services.cardServices.CardProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cardProduct")
public class CardProductController {

    private CardProductService cardProductService;

    @Autowired
    public CardProductController(CardProductService cardProductService) {
        this.cardProductService = cardProductService;
    }

    @GetMapping("/findAll")
    public List<CardProduct> findAllCardProducts() {
        return cardProductService.findAllCardProducts();
    }

    @GetMapping("/{id}")
    public Optional<CardProduct> findCardProductById(@PathVariable Long id) {
        return cardProductService.findCardProductById(id);
    }

    @GetMapping("/loadToInMemory")
    public void loadCardProductsToInMemoryDB() {
        cardProductService.saveAllCardProductsInMemory();
    }

    @GetMapping("/clearAllInMemory")
    public void clearCardProductsFromInMemoryDB() {
        cardProductService.clearAllCardProductsInMemory();
    }
}
