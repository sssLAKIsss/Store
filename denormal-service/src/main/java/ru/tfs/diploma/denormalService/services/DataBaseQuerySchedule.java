package ru.tfs.diploma.denormalService.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.tfs.diploma.denormalService.repositories.cardRepositories.CardProductRepository;
import ru.tfs.diploma.denormalService.repositories.cardRepositories.CardRepository;
import ru.tfs.diploma.denormalService.repositories.clientRepositories.ClientRepository;
import ru.tfs.diploma.denormalService.repositories.infoRepositories.InfoRepository;
import ru.tfs.diploma.denormalService.repositories.parameterRepositories.ParameterTypeRepository;
import ru.tfs.diploma.denormalService.repositories.productRepositoires.ProductRepository;
import ru.tfs.diploma.denormalService.repositories.shipmentRepositories.ShipmentRepository;

/**
 * Ходит по расписанию за данными на localhost:8189
 */
@Component
@Slf4j
public class DataBaseQuerySchedule {

    private final ProductRepository productRepository;
    private final ClientRepository clientRepository;
    private final ShipmentRepository shipmentRepository;
    private final CardProductRepository cardProductRepository;
    private final CardRepository cardRepository;
    private final ParameterTypeRepository parameterTypeRepository;
    private final InfoRepository infoRepository;

    @Autowired
    public DataBaseQuerySchedule(ProductRepository productRepository,
                                 ClientRepository clientRepository,
                                 ShipmentRepository shipmentRepository,
                                 CardProductRepository cardProductRepository,
                                 CardRepository cardRepository,
                                 ParameterTypeRepository parameterTypeRepository,
                                 InfoRepository infoRepository) {
        this.productRepository = productRepository;
        this.clientRepository = clientRepository;
        this.shipmentRepository = shipmentRepository;
        this.cardProductRepository = cardProductRepository;
        this.cardRepository = cardRepository;
        this.parameterTypeRepository = parameterTypeRepository;
        this.infoRepository = infoRepository;
    }

    @Scheduled(fixedDelay = 100_000)
    public void updateDB() {
        log.info("Start clear");
        clientRepository.clearClientsInMemory();
        shipmentRepository.clearShipmentsInMemory();
        infoRepository.clearInfosInMemory();
        infoRepository.clearAllInfoDtoInMemory();
        parameterTypeRepository.clearParameterTypesInMemory();
        productRepository.clearProductsInMemory();
        productRepository.clearAllProductsDtoInMemory();
        cardProductRepository.clearCardProductsInMemory();
        cardRepository.clearAllCardsDtoInMemory();
        log.info("End clear");

        log.info("Start client load");
        clientRepository.saveClientsInMemory();
        log.info("Start shipment load");
        shipmentRepository.saveShipmentsInMemory();
        log.info("Start infos load");
        infoRepository.saveInfosInMemory();
        log.info("Start infosDTO load");
        infoRepository.saveAllInfoDto();
        log.info("Start parameters load");
        parameterTypeRepository.saveParameterTypesInMemory();
        log.info("Start products load");
        productRepository.saveProductsInMemory();
        log.info("Start productDTO load");
        productRepository.saveAllProductsDto();
        log.info("Start cardProducts load");
        cardProductRepository.saveCardProductsInMemory();
        log.info("Start card load");
        cardRepository.saveCardsInMemory();
        log.info("Start cardDTO load");
        cardRepository.saveAllCardsDto();
    }
}
