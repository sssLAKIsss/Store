package ru.tfs.coreService.repositories.directRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tfs.coreService.entities.directories.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

}
