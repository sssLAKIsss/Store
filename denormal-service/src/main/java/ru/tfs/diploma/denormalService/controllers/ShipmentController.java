package ru.tfs.diploma.denormalService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tfs.diploma.denormalService.models.Shipment;
import ru.tfs.diploma.denormalService.services.shipmentServices.ShipmentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {

    private ShipmentService shipmentService;

    @Autowired
    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @GetMapping("/findAll")
    public List<Shipment> findAllShipments() {
        return shipmentService.findAllShipments();
    }

    @GetMapping("/{id}")
    public Optional<Shipment> findShipmentById(@PathVariable Long id) {
        return shipmentService.findShipmentById(id);
    }

    @GetMapping("/loadToInMemory")
    public void loadShipmentsToInMemoryDB() {
        shipmentService.saveAllShipmentsInMemory();
    }

    @GetMapping("/clearAllInMemory")
    public void clearAllShipmentsFromInMemoryDB() {
        shipmentService.clearAllShipmentsInMemory();
    }
}
