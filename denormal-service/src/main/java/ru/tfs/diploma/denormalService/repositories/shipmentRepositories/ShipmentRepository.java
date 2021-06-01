package ru.tfs.diploma.denormalService.repositories.shipmentRepositories;

import ru.tfs.diploma.denormalService.models.Shipment;

import java.util.List;
import java.util.Optional;

public interface ShipmentRepository {

    void saveShipmentsInMemory();
    void clearShipmentsInMemory();
    List<Shipment> findAllShipmentsFromInMemoryDB();
    Optional<Shipment> findShipmentFromInMemoryDB(Long id);
}
