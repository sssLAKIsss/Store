package ru.tfs.diploma.agregator.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class Currency {

    private Long id;
    private String name;
    private int multyplier;
    private Instant creationTime;
    private Instant lastUpdate;
    private int version;

    public Currency(Long id, String name, int multyplier, Instant creationTime, Instant lastUpdate, int version) {
        this.id = id;
        this.name = name;
        this.multyplier = multyplier;
        this.creationTime = creationTime;
        this.lastUpdate = lastUpdate;
        this.version = version;
    }
}
