package ru.tfs.diploma.denormalService.services.productServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tfs.diploma.denormalService.dto.ProductDto;
import ru.tfs.diploma.denormalService.repositories.productRepositoires.ProductRepositoryImpl;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepositoryImpl productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepositoryImpl productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> findAll(String language) {
        return productRepository.findAllProductsDto(language);
    }

    public Optional<ProductDto> findById(Long id, String language) {
        return productRepository.findProductDtoById(id, language);
    }

    public void saveAllClientsInMemory() {
        productRepository.saveAllProductsDto();
    }

    public void clearAllClientsInMemory() {
        productRepository.clearAllProductsDtoInMemory();
    }
}
