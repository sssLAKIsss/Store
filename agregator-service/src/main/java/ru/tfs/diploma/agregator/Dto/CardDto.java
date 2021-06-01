package ru.tfs.diploma.agregator.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.tfs.diploma.agregator.models.CardProduct;

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

    public CardDto(CardDto cardDto, int totalBill) {
        this.cardId = cardDto.getCardId();
        this.clientId = cardDto.getClientId();
        this.currencyId = cardDto.getCurrencyId();
        this.creation = cardDto.getCreation();
        this.lastUpdate = cardDto.getLastUpdate();
        this.version = cardDto.getVersion();

        this.shipmentId = cardDto.getShipmentId();
        this.shipmentAddress = cardDto.getShipmentAddress();
        this.shipmentCreation = cardDto.getShipmentCreation();
        this.shipmentLastUpdate = cardDto.getShipmentLastUpdate();
        this.shipmentVersion = cardDto.getShipmentVersion();

        this.cardProductList = cardDto.getCardProductList();

        this.totalBill = totalBill;
    }
}
