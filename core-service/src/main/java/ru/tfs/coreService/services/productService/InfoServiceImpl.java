package ru.tfs.coreService.services.productService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tfs.coreService.entities.product.Info;
import ru.tfs.coreService.repositories.productRepository.InfoRepository;

import java.util.List;

@Service
public class InfoServiceImpl implements InfoService{

    private final InfoRepository infoRepository;

    @Autowired
    public InfoServiceImpl(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Info> findByProductIdAndLanguageId(Long productId, long languageId) {
        return infoRepository.findDescriptionOfProduct(productId, languageId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Info> findAllInfos() {
        return infoRepository.findAll();
    }

    @Override
    @Transactional
    public Info save(Info info) {
        return infoRepository.save(info);
    }

    @Override
    @Transactional
    public List<Info> saveAll(List<Info> infoList) {
        return infoRepository.saveAll(infoList);
    }

    @Override
    @Transactional
    public void removeInfo(Long id) {
         infoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void removeAllInfos() {
         infoRepository.deleteAll();
    }
}
