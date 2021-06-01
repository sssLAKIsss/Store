package ru.tfs.diploma.denormalService.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.tfs.diploma.denormalService.models.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "core")
public interface Feign {

    @GetMapping("/client/findAll")
    List<Client> findAllClients();

    @GetMapping("/client/{id}")
    Optional<Client> findClientById(@PathVariable Long id);


    @GetMapping("/languages/findAll")
    List<Language> findAllLanguages();

    @GetMapping("/info/findAll")
    List<Info> findAllInfos();

    @GetMapping("/parameters/findAll")
    List<ParameterType> findAllParameters();


    @GetMapping("/product/findAll")
    List<Product> findAllProducts();


    @GetMapping("/shipment/showAll")
    List<Shipment> findAllShipments();


    @GetMapping("/cardProduct/showAll")
    List<CardProduct> findAllCardProducts();

    @GetMapping("/card/showAll")
    List<Card> findAllCards();
}
