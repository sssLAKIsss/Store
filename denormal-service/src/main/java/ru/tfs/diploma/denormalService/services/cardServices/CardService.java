package ru.tfs.diploma.denormalService.services.cardServices;

import ru.tfs.diploma.denormalService.dto.CardDto;

import java.util.List;
import java.util.Optional;

public interface CardService {

    List<CardDto> findAllCards();
    Optional<CardDto> findCardById(Long id);
    void saveAllCardsInMemory();
    void clearAllCardsInMemory();
}
