package ru.tfs.diploma.denormalService.repositories.shipmentRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.tfs.diploma.denormalService.feignClient.Feign;
import ru.tfs.diploma.denormalService.models.Shipment;

import java.util.List;
import java.util.Optional;

@Repository
public class ShipmentRepositoryImpl implements ShipmentRepository {

    private final Feign feign;
    private List<Shipment> shipmentList;

    @Autowired
    public ShipmentRepositoryImpl(Feign feign, List<Shipment> shipmentList) {
        this.feign = feign;
        this.shipmentList = shipmentList;
    }

    public void saveShipmentsInMemory() {
        shipmentList = feign.findAllShipments();
    }

    public void clearShipmentsInMemory() {
        shipmentList.clear();
    }

    public List<Shipment> findAllShipmentsFromInMemoryDB() {
        return shipmentList;
    }

    public Optional<Shipment> findShipmentFromInMemoryDB(Long id) {
        return shipmentList.stream().
                filter(client -> client.getId() == id).
                findFirst();
    }
}
