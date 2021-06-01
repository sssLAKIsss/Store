package ru.tfs.diploma.denormalService.services.productServices;

import ru.tfs.diploma.denormalService.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductDto> findAll(String language);
    Optional<ProductDto> findById(Long id, String language);
    void saveAllClientsInMemory();
    void clearAllClientsInMemory();
}
