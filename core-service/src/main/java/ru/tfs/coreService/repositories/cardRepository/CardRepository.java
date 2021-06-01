package ru.tfs.coreService.repositories.cardRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tfs.coreService.entities.order.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}
