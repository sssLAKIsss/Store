package ru.tfs.diploma.denormalService.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Shipment {

    private Long id;
    private Long orderId;
    private String address;
    private Instant creation;
    private Instant lastUpdate;
    private int version;
}
