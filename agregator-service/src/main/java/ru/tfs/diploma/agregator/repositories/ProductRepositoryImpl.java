package ru.tfs.diploma.agregator.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.tfs.diploma.agregator.models.Currency;
import ru.tfs.diploma.agregator.Dto.ProductDto;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final WebClient.Builder webClient;

    @Autowired
    public ProductRepositoryImpl(WebClient.Builder webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<ProductDto> getProductWithSomeCurrency(Long productDtoId, String language, Long currencyId) {
        Mono<Currency> currencyMono = webClient.build()
                .get().uri("http://localhost:8088/currency/{id}", currencyId)
                .retrieve().bodyToMono(Currency.class);

        Mono<ProductDto> productDtoMono = webClient.build()
                .get().uri("http://localhost:8088/product/{id}/{language}", productDtoId, language)
                .retrieve().bodyToMono(ProductDto.class);

        return Mono.zip(productDtoMono, currencyMono, ProductRepositoryImpl::mapToProductDto);
    }

    @Override
    public Flux<ProductDto> getAllProductsByLanguageAndCurrency(String language, Long currencyId) {
        Mono<Currency> currencyMono = webClient.build()
                .get().uri("http://localhost:8088/currency/{id}", currencyId)
                .retrieve().bodyToMono(Currency.class);

        Flux<ProductDto> productDtoFlux = webClient.build()
                .get().uri("http://localhost:8088/product/findAll/{language}", language)
                .retrieve().bodyToFlux(ProductDto.class);

        return productDtoFlux.flatMap(p -> currencyMono.map(c -> mapToProductDto(p, c)));
    }

    private static ProductDto mapToProductDto(ProductDto productDto, Currency currency) {
        int price = currency.getMultyplier() * productDto.getPriceUE();
        return new ProductDto(productDto, price);
    }
}
