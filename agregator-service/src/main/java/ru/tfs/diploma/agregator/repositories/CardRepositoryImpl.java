package ru.tfs.diploma.agregator.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.tfs.diploma.agregator.Dto.CardDto;
import ru.tfs.diploma.agregator.models.Currency;

@Repository
public class CardRepositoryImpl implements CardRepository {

    private final WebClient.Builder webClient;

    @Autowired
    public CardRepositoryImpl(WebClient.Builder webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<CardDto> findCardWithCurrency(Long cardId, Long currencyId) {
        Mono<Currency> currencyMono = webClient.build()
                .get().uri("http://localhost:8088/currency/{id}", currencyId)
                .retrieve().bodyToMono(Currency.class);

        Mono<CardDto> cardDtoFlux = webClient.build()
                .get().uri("http://localhost:8088/card/{id}", cardId)
                .retrieve().bodyToMono(CardDto.class);

        return Mono.zip(cardDtoFlux, currencyMono, CardRepositoryImpl::mapToCardDto);
    }

    @Override
    public Flux<CardDto> findAllCardsWithCurrency(Long currencyId) {
        Mono<Currency> currencyMono = webClient.build()
                .get().uri("http://localhost:8088/currency/{id}", currencyId)
                .retrieve().bodyToMono(Currency.class);

        Flux<CardDto> cardDtoFlux = webClient.build()
                .get().uri("http://localhost:8088/card/findAll")
                .retrieve().bodyToFlux(CardDto.class);

        return cardDtoFlux.flatMap(cardDto -> currencyMono.map(currency -> mapToCardDto(cardDto, currency)));
    }

    private static CardDto mapToCardDto(CardDto cardDto, Currency currency) {
        int totalBill = cardDto.getTotalBill() * currency.getMultyplier();
        return new CardDto(cardDto, totalBill);
    }
}
