package ru.tfs.diploma.denormalService.repositories.cardRepositories;

import ru.tfs.diploma.denormalService.models.CardProduct;

import java.util.List;
import java.util.Optional;

public interface CardProductRepository {

    void saveCardProductsInMemory();
    void clearCardProductsInMemory();
    List<CardProduct> findAllCardProductFromInMemoryDB();
    Optional<CardProduct> findCardProductFromInMemoryDB(Long id);
}
