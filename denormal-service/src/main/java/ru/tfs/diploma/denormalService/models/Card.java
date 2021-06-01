package ru.tfs.diploma.denormalService.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    private Long id;
    private Long clientId;
    private Long currencyId;
    private Instant creation;
    private Instant lastUpdate;
    private int version;
    private Shipment shipment;
    private List<CardProduct> cardProductList;
}
