package ru.tfs.diploma.agregator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.tfs.diploma.agregator.Dto.ProductDto;
import ru.tfs.diploma.agregator.repositories.ProductRepository;


@RestController
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/productInfo/{productId}/{language}/{currencyId}")
    public Mono<ProductDto> getProductWithCurrencyAndLanguage(@PathVariable Long productId,
                                                              @PathVariable String language,
                                                              @PathVariable Long currencyId) {
        return productRepository.getProductWithSomeCurrency(productId, language, currencyId);
    }

    @GetMapping("/productInfo/findAll/{language}/{currencyId}")
    public Flux<ProductDto> getAllProductsWithCurrencyAndLanguage(@PathVariable String language,
                                                                  @PathVariable Long currencyId) {
        return productRepository.getAllProductsByLanguageAndCurrency(language, currencyId);
    }
}