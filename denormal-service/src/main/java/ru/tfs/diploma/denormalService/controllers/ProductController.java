package ru.tfs.diploma.denormalService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tfs.diploma.denormalService.dto.ProductDto;
import ru.tfs.diploma.denormalService.services.productServices.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/findAll/{language}")
    public List<ProductDto> findAll(@PathVariable String language) {
        return productService.findAll(language);
    }

    @GetMapping("/{productId}/{language}")
    public Optional<ProductDto> findById(@PathVariable Long productId, @PathVariable String language) {
        return productService.findById(productId, language);
    }

    @GetMapping("/loadToInMemory")
    public void loadProductsDtoInMemoryDB() {
        productService.saveAllClientsInMemory();
    }

    @GetMapping("/clearAllInMemory")
    public void clearAllProductDtoFromInMemoryDB() {
        productService.clearAllClientsInMemory();
    }

}
