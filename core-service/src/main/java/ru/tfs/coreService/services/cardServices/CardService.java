package ru.tfs.coreService.services.cardServices;


import ru.tfs.coreService.entities.order.Card;

import java.util.List;
import java.util.Optional;

public interface CardService {
    List<Card> findAll();
    Optional<Card> findById(Long id);

    Card save(Card card);

    void deleteAll();
    void deleteCard(Long id);
}
