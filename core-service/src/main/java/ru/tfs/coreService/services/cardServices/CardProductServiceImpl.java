package ru.tfs.coreService.services.cardServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tfs.coreService.entities.order.CardProduct;
import ru.tfs.coreService.repositories.cardRepository.CardProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CardProductServiceImpl implements CardProductService{

    private final CardProductRepository cardProductRepository;

    @Autowired
    public CardProductServiceImpl(CardProductRepository cardProductRepository) {
        this.cardProductRepository = cardProductRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<CardProduct> findAll() {
        return cardProductRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<CardProduct> findById(Long id) {
        return cardProductRepository.findById(id);
    }

    @Transactional
    @Override
    public CardProduct save(CardProduct cardProduct) {
        return cardProductRepository.save(cardProduct);
    }

    @Transactional
    @Override
    public List<CardProduct> saveAll(List<CardProduct> cardProductList) {
        return cardProductRepository.saveAll(cardProductList);
    }

    @Transactional
    @Override
    public void deleteAll() {
        cardProductRepository.deleteAll();
    }

    @Transactional
    @Override
    public void deleteCardProduct(Long id) {
        cardProductRepository.deleteById(id);
    }
}
