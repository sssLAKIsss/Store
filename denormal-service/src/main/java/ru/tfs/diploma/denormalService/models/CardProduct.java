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
public class CardProduct {

    private Long id;
    private Long cardId;
    private Long productId;
    private int quantity;
    private Instant creation;
    private Instant lastUpdate;
    private int version;
}
