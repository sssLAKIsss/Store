package ru.tfs.coreService.services.productService;

import ru.tfs.coreService.entities.product.Info;

import java.util.List;

public interface InfoService {
    List<Info> findByProductIdAndLanguageId(Long productId, long languageId);
    List<Info> findAllInfos();

    Info save(Info info);
    List<Info> saveAll(List<Info> infoList);

    void removeInfo(Long id);
    void removeAllInfos();

}
