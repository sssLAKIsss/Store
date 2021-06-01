package ru.tfs.coreService.repositories.productRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.tfs.coreService.entities.product.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select p.id, p.title, (p.prccice_ue * c.multyplier) as price_ue, p.creation, p.last_update, p.version " +
            "from products p, currency c where c.id = :id", nativeQuery = true)
    List<Product> findAllProducts(@Param("id") Long id);

    @Query( value = "select p.id, " +
            "p.title, " +
            "(p.price_ue * c.multyplier) as price_ue, " +
            "p.creation, p.last_update, " +
            "p.version " +
            "from products p, currency c " +
            "where p.id = ?1 and c.id = ?2", nativeQuery = true)
    Optional<Product> findProductWithCurrency(Long productId, Long currencyId);
}
