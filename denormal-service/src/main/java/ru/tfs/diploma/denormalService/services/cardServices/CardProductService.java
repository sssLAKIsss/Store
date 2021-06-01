package ru.tfs.diploma.denormalService.services.cardServices;

import ru.tfs.diploma.denormalService.models.CardProduct;

import java.util.List;
import java.util.Optional;

public interface CardProductService {

    List<CardProduct> findAllCardProducts();
    Optional<CardProduct> findCardProductById(Long id);
    void saveAllCardProductsInMemory();
    void clearAllCardProductsInMemory();
}
