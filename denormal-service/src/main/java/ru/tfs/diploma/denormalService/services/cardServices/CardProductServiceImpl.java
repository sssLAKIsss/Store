package ru.tfs.diploma.denormalService.services.cardServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tfs.diploma.denormalService.models.CardProduct;
import ru.tfs.diploma.denormalService.repositories.cardRepositories.CardProductRepositoryImpl;

import java.util.List;
import java.util.Optional;

@Service
public class CardProductServiceImpl implements CardProductService {

    private final CardProductRepositoryImpl cardProductRepository;

    @Autowired
    public CardProductServiceImpl(CardProductRepositoryImpl cardProductRepository) {
        this.cardProductRepository = cardProductRepository;
    }

    public List<CardProduct> findAllCardProducts() {
        return cardProductRepository.findAllCardProductFromInMemoryDB();
    }

    public Optional<CardProduct> findCardProductById(Long id) {
        return cardProductRepository.findCardProductFromInMemoryDB(id);
    }

    public void saveAllCardProductsInMemory() {
        cardProductRepository.saveCardProductsInMemory();
    }

    public void clearAllCardProductsInMemory() {
        cardProductRepository.clearCardProductsInMemory();
    }
}
