package ru.tfs.diploma.denormalService.repositories.cardRepositories;

import ru.tfs.diploma.denormalService.dto.CardDto;
import ru.tfs.diploma.denormalService.models.Card;

import java.util.List;
import java.util.Optional;

public interface CardRepository {

    void saveCardsInMemory();
    void clearCardsInMemory();
    List<Card> findAllCardsFromInMemoryDB();
    Optional<Card> findCardFromInMemoryDB(Long id);

    void saveAllCardsDto();
    void clearAllCardsDtoInMemory();
    List<CardDto> findAllCardsDto();
    Optional<CardDto> findCardDtoById(Long id);
}
