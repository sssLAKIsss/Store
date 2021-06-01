package ru.tfs.coreService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tfs.coreService.entities.order.Card;
import ru.tfs.coreService.services.cardServices.CardService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/card")
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/showAll")
    public List<Card> findAll() {
        return cardService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Card> findById(@PathVariable Long id) {
        return cardService.findById(id);
    }

    @PostMapping("/addCard")
    public Card addCard(@Valid @RequestBody Card card) {
        return cardService.save(card);
    }

    @PutMapping("/updateCard")
    public Card updateCard(@Valid @RequestBody Card card) {
        return cardService.save(card);
    }

    @DeleteMapping("/remove/{id}")
    public String deleteById(@PathVariable Long id) {
        cardService.deleteCard(id);
        return "Card removed!";
    }

    @DeleteMapping("/removeAll")
    public String deleteAll() {
        cardService.deleteAll();
        return "All cards removed!";
    }
}
