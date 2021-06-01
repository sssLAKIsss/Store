package ru.tfs.coreService.repositories.directRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tfs.coreService.entities.directories.ParameterType;

@Repository
public interface ParameterTypeRepository extends JpaRepository<ParameterType, Long> {
}
