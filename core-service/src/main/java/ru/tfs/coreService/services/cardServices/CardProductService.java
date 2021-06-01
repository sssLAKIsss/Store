package ru.tfs.coreService.services.cardServices;

import ru.tfs.coreService.entities.order.CardProduct;

import java.util.List;
import java.util.Optional;

public interface CardProductService {
    List<CardProduct> findAll();
    Optional<CardProduct> findById(Long id);

    CardProduct save(CardProduct cardProduct);
    List<CardProduct> saveAll(List<CardProduct> cardProductList);

    void deleteAll();
    void deleteCardProduct(Long id);
}

