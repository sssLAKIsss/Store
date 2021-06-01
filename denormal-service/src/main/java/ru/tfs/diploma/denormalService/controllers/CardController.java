package ru.tfs.diploma.denormalService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tfs.diploma.denormalService.dto.CardDto;
import ru.tfs.diploma.denormalService.services.cardServices.CardService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/card")
public class CardController {

    private CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/findAll")
    public List<CardDto> findAllCards() {
        return cardService.findAllCards();
    }

    @GetMapping("/{id}")
    public Optional<CardDto> findCardById(@PathVariable Long id) {
        return cardService.findCardById(id);
    }

    @GetMapping("/loadToInMemory")
    public void loadCardsToInMemoryDB() {
        cardService.saveAllCardsInMemory();
    }

    @GetMapping("/clearAllInMemory")
    public void clearCardsFromInMemoryDB() {
        cardService.clearAllCardsInMemory();
    }
}
