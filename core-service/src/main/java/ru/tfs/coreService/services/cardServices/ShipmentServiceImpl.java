package ru.tfs.coreService.services.cardServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tfs.coreService.entities.order.Shipment;
import ru.tfs.coreService.repositories.cardRepository.ShipmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentServiceImpl implements ShipmentService{

    private final ShipmentRepository shipmentRepository;

    @Autowired
    public ShipmentServiceImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }


    @Transactional(readOnly = true)
    @Override
    public List<Shipment> findAll() {
        return shipmentRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Shipment> findById(Long id) {
        return shipmentRepository.findById(id);
    }

    @Transactional
    @Override
    public Shipment save(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    @Transactional
    @Override
    public List<Shipment> saveAll(List<Shipment> shipmentList) {
        return shipmentRepository.saveAll(shipmentList);
    }

    @Transactional
    @Override
    public void deleteAll() {
        shipmentRepository.deleteAll();
    }

    @Transactional
    @Override
    public void deleteShipment(Long id) {
        shipmentRepository.deleteById(id);
    }
}
