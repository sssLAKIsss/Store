package ru.tfs.coreService.services.cardServices;

import ru.tfs.coreService.entities.order.Shipment;

import java.util.List;
import java.util.Optional;

public interface ShipmentService {
    List<Shipment> findAll();
    Optional<Shipment> findById(Long id);

    Shipment save(Shipment card);
    List<Shipment> saveAll(List<Shipment> shipmentList);

    void deleteAll();
    void deleteShipment(Long id);
}
