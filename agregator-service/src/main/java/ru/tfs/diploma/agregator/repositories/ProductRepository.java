package ru.tfs.diploma.agregator.repositories;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.tfs.diploma.agregator.Dto.ProductDto;


public interface ProductRepository {
    Mono<ProductDto> getProductWithSomeCurrency(Long productDtoId, String languageDescription, Long currencyId);
    Flux<ProductDto> getAllProductsByLanguageAndCurrency(String languageDescription, Long currencyId);
}
