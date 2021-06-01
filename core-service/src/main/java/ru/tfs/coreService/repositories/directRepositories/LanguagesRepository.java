package ru.tfs.coreService.repositories.directRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tfs.coreService.entities.directories.Languages;

@Repository
public interface LanguagesRepository extends JpaRepository<Languages, Long> {
}
