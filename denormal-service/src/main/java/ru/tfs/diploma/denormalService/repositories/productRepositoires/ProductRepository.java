package ru.tfs.diploma.denormalService.repositories.productRepositoires;

import ru.tfs.diploma.denormalService.dto.ProductDto;
import ru.tfs.diploma.denormalService.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    void saveProductsInMemory();
    void clearProductsInMemory();
    List<Product> findAllProductsFromInMemoryDB();
    Optional<Product> findProductFromInMemoryDB(Long id);

    void saveAllProductsDto();
    void clearAllProductsDtoInMemory();
    List<ProductDto> findAllProductsDto(String language);
    Optional<ProductDto> findProductDtoById(Long id, String language);
}
