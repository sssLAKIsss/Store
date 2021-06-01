package ru.tfs.coreService.repositories.cardRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tfs.coreService.entities.order.CardProduct;

@Repository
public interface CardProductRepository extends JpaRepository<CardProduct, Long> {
}
