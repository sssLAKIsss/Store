package ru.tfs.diploma.agregator.repositories;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.tfs.diploma.agregator.Dto.CardDto;


public interface CardRepository {
    Mono<CardDto> findCardWithCurrency(Long cardId, Long currencyId);
    Flux<CardDto> findAllCardsWithCurrency(Long currencyId);
}
