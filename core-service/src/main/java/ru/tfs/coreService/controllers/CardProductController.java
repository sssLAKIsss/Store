package ru.tfs.coreService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tfs.coreService.entities.order.CardProduct;
import ru.tfs.coreService.services.cardServices.CardProductService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cardProduct")
public class CardProductController {

    private final CardProductService cardProductService;

    @Autowired
    public CardProductController(CardProductService cardProductService) {
        this.cardProductService = cardProductService;
    }

    @GetMapping("/showAll")
    public List<CardProduct> findAll() {
        return cardProductService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<CardProduct> findById(@PathVariable Long id) {
        return cardProductService.findById(id);
    }

    @PostMapping("/addCardProduct")
    public CardProduct addCardProduct(@Valid @RequestBody CardProduct cardProduct) {
        return cardProductService.save(cardProduct);
    }

    @PostMapping("/addCardProducts")
    public List<CardProduct> addCardProductList(@Valid @RequestBody List<CardProduct> cardProductList) {
        return cardProductService.saveAll(cardProductList);
    }

    @PutMapping("/updateCardProduct")
    public CardProduct updateCardProduct(@Valid @RequestBody CardProduct cardProduct) {
        return cardProductService.save(cardProduct);
    }

    @PutMapping("/updateCardProducts")
    public List<CardProduct> updateCardProductList(@Valid @RequestBody List<CardProduct> cardProductList) {
        return cardProductService.saveAll(cardProductList);
    }

    @DeleteMapping("/remove/{id}")
    public String deleteCardProduct(@PathVariable Long id) {
        cardProductService.deleteCardProduct(id);
        return "CardProduct removed!";
    }

    @DeleteMapping("/removeAll")
    public String deleteAll() {
        cardProductService.deleteAll();
        return "All cardProducts removed!";
    }
}
