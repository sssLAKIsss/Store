package ru.tfs.diploma.denormalService.services.shipmentServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tfs.diploma.denormalService.models.Shipment;
import ru.tfs.diploma.denormalService.repositories.shipmentRepositories.ShipmentRepositoryImpl;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepositoryImpl shipmentRepository;

    @Autowired
    public ShipmentServiceImpl(ShipmentRepositoryImpl shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public List<Shipment> findAllShipments() {
        return shipmentRepository.findAllShipmentsFromInMemoryDB();
    }

    public Optional<Shipment> findShipmentById(Long id) {
        return shipmentRepository.findShipmentFromInMemoryDB(id);
    }

    public void saveAllShipmentsInMemory() {
        shipmentRepository.saveShipmentsInMemory();
    }

    public void clearAllShipmentsInMemory() {
        shipmentRepository.clearShipmentsInMemory();
    }

}
