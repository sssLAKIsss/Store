package ru.tfs.coreService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tfs.coreService.entities.product.Product;
import ru.tfs.coreService.services.productService.ProductService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/findAll")
    public List<Product> findALl() {
        return productService.findAll();
    }

    @GetMapping("/findAll/{id}")
    public List<Product> findAllBySomeCurrency(@PathVariable Long id) {
        return productService.findAllWithSomeCurrency(id);
    }

    @GetMapping("/{id}")
    public Optional<Product> findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("/{productId}/{currencyId}")
    public Optional<Product> findByIdWithCurrency(@PathVariable Long productId, @PathVariable Long currencyId) {
        return productService.findByIdWithCurrency(productId, currencyId);
    }

    @PostMapping("/addProduct")
    public Product addProduct(@Valid  @RequestBody Product product) {
        return productService.save(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addListOfProduct(@Valid @RequestBody List<Product> productList) {
        return productService.saveAll(productList);
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@Valid @RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/updateProducts")
    public List<Product> updateListOfProduct(@Valid @RequestBody List<Product> productList) {
        return productService.saveAll(productList);
    }

    @DeleteMapping("/remove/{id}")
    public String deleteById(@PathVariable Long id) {
        productService.removeProduct(id);
        return "Product removed!";
    }

    @DeleteMapping("/removeAll")
    public String deleteAll() {
        productService.removeAllProducts();
        return "All products removed!";
    }
}
