package ru.tfs.diploma.denormalService.services.shipmentServices;

import ru.tfs.diploma.denormalService.models.Shipment;

import java.util.List;
import java.util.Optional;

public interface ShipmentService {

    List<Shipment> findAllShipments();
    Optional<Shipment> findShipmentById(Long id);
    void saveAllShipmentsInMemory();
    void clearAllShipmentsInMemory();
}
