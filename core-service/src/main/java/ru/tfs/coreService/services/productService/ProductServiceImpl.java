package ru.tfs.coreService.services.productService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tfs.coreService.entities.product.Product;
import ru.tfs.coreService.repositories.productRepository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAllWithSomeCurrency(Long id) {
        return productRepository.findAllProducts(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    @Override
    public Optional<Product> findByIdWithCurrency(Long currencyId, Long productId) {
        return productRepository.findProductWithCurrency(currencyId, productId);
    }

    @Transactional
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    @Override
    public List<Product> saveAll(List<Product> productList) {
        return productRepository.saveAll(productList);
    }

    @Transactional
    @Override
    public void removeProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void removeAllProducts() {
        productRepository.deleteAll();
    }
}
