package ru.tfs.coreService.services.cardServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tfs.coreService.entities.order.Card;
import ru.tfs.coreService.repositories.cardRepository.CardRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService{

    private final CardRepository cardRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Card> findById(Long id) {
        return cardRepository.findById(id);
    }

    @Transactional
    @Override
    public Card save(Card card) {
        return cardRepository.save(card);
    }

    @Transactional
    @Override
    public void deleteAll() {
        cardRepository.deleteAll();
    }

    @Transactional
    @Override
    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }
}
