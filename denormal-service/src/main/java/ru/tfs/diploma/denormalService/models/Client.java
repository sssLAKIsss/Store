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
public class Client {

    private Long id;
    private String name;
    private String region;
    private String phoneNumber;
    private Instant creationTime;
    private Instant lastUpdate;
    private int version;
}
