package ru.tfs.diploma.denormalService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.tfs.diploma.denormalService.models.Card;
import ru.tfs.diploma.denormalService.models.CardProduct;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {

    private Long cardId;
    private Long clientId;
    private Long currencyId;
    private Instant creation;
    private Instant lastUpdate;
    private int version;

    private Long shipmentId;
    private String shipmentAddress;
    private Instant shipmentCreation;
    private Instant shipmentLastUpdate;
    private int shipmentVersion;

    private List<CardProduct> cardProductList;
    private int totalBill;

    public CardDto(Card card, int cardBull) {
        this.cardId = card.getId();
        this.clientId = card.getClientId();
        this.currencyId = card.getCurrencyId();
        this.creation = card.getCreation();
        this.lastUpdate = card.getLastUpdate();
        this.version = card.getVersion();
        this.cardProductList = card.getCardProductList();
        this.totalBill = cardBull;
    }
}
