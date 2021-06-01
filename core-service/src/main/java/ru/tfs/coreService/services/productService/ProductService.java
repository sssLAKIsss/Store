package ru.tfs.coreService.services.productService;


import ru.tfs.coreService.entities.product.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);

    /**
     * Методы для отображения в выбранной валюте
     */
    List<Product> findAllWithSomeCurrency(Long id);
    Optional<Product> findByIdWithCurrency(Long currencyId, Long productId);

    Product save(Product product);
    List<Product> saveAll(List<Product> productList);

    void removeProduct(Long id);
    void removeAllProducts();
}
