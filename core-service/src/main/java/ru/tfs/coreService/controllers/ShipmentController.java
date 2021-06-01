package ru.tfs.coreService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tfs.coreService.entities.order.Shipment;
import ru.tfs.coreService.services.cardServices.ShipmentService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {

    private final ShipmentService shipmentService;

    @Autowired
    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @GetMapping("/showAll")
    public List<Shipment> findAll() {
        return shipmentService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Shipment> findById(@PathVariable Long id) {
        return shipmentService.findById(id);
    }

    @PostMapping("/addShipment")
    public Shipment addShipment(@Valid @RequestBody Shipment shipment) {
        return shipmentService.save(shipment);
    }

    @PostMapping("/addShipments")
    public List<Shipment> addListOfShipments(@Valid @RequestBody List<Shipment> shipmentList) {
        return shipmentService.saveAll(shipmentList);
    }

    @PutMapping("/updateShipment")
    public Shipment updateShipment(@Valid @RequestBody Shipment shipment) {
        return shipmentService.save(shipment);
    }

    @PutMapping("/updateShipments")
    public List<Shipment> updateListOfShipments(@Valid @RequestBody List<Shipment> shipmentList) {
        return shipmentService.saveAll(shipmentList);
    }

    @DeleteMapping("/remove/{id}")
    public String deleteShipment(@PathVariable Long id) {
        shipmentService.deleteShipment(id);
        return "Shipment removed!";
    }

    @DeleteMapping("/removeAll")
    public String deleteAll() {
        shipmentService.deleteAll();
        return "All shipments removed!";
    }
}
