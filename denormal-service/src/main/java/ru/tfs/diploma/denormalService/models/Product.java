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
public class Product {

    private Long id;
    private String title;
    private int priceUE;
    private Instant creationTime;
    private Instant lastUpdate;
    private int version;
    private List<ParameterType> parameters;
    private List<Info> infos;
}
