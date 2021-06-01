package ru.tfs.diploma.denormalService.services.cardServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tfs.diploma.denormalService.dto.CardDto;
import ru.tfs.diploma.denormalService.repositories.cardRepositories.CardRepositoryImpl;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepositoryImpl cardRepository;

    @Autowired
    public CardServiceImpl(CardRepositoryImpl cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<CardDto> findAllCards() {
        return cardRepository.findAllCardsDto();
    }

    public Optional<CardDto> findCardById(Long id) {
        return cardRepository.findCardDtoById(id);
    }

    public void saveAllCardsInMemory() {
        cardRepository.saveAllCardsDto();
    }

    public void clearAllCardsInMemory() {
        cardRepository.clearAllCardsDtoInMemory();
    }
}
