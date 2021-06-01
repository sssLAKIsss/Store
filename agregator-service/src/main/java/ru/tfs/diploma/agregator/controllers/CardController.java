package ru.tfs.diploma.agregator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.tfs.diploma.agregator.Dto.CardDto;
import ru.tfs.diploma.agregator.repositories.CardRepository;


@RestController
public class CardController {

    private final CardRepository cardRepository;

    @Autowired
    public CardController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @GetMapping("/cardInfo/{cardId}/{currencyId}")
    public Mono<CardDto> findCardWithCurrency(@PathVariable Long cardId, @PathVariable Long currencyId) {
        return cardRepository.findCardWithCurrency(cardId, currencyId);
    }

    @GetMapping("/cardInfo/findAll/{currencyId}")
    public Flux<CardDto> findCardWithCurrency(@PathVariable Long currencyId) {
        return cardRepository.findAllCardsWithCurrency(currencyId);
    }
}
