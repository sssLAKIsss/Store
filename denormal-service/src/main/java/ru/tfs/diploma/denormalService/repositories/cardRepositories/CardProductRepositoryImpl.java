package ru.tfs.diploma.denormalService.repositories.cardRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.tfs.diploma.denormalService.feignClient.Feign;
import ru.tfs.diploma.denormalService.models.CardProduct;

import java.util.List;
import java.util.Optional;

@Repository
public class CardProductRepositoryImpl implements CardProductRepository {

    private final Feign feign;
    private List<CardProduct> cardProductList;

    @Autowired
    public CardProductRepositoryImpl(Feign feign,
                                     List<CardProduct> cardProductList) {
        this.feign = feign;
        this.cardProductList = cardProductList;
    }

    public void saveCardProductsInMemory() {
        cardProductList = feign.findAllCardProducts();
    }

    public void clearCardProductsInMemory() {
        cardProductList.clear();
    }

    public List<CardProduct> findAllCardProductFromInMemoryDB() {
        return cardProductList;
    }

    public Optional<CardProduct> findCardProductFromInMemoryDB(Long id) {
        return cardProductList.stream().
                filter(client -> client.getId() == id).
                findFirst();
    }
}
