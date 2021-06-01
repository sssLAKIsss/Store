package ru.tfs.coreService.repositories.productRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.tfs.coreService.entities.product.Info;

import java.util.List;

@Repository
public interface InfoRepository extends JpaRepository<Info, Long> {

    @Query("select description from Info description where description.productId = ?1 and description.languageId = ?2")
    List<Info> findDescriptionOfProduct(Long productId, Long languageId);

}
