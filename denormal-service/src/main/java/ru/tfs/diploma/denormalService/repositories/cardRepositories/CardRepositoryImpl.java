package ru.tfs.diploma.denormalService.repositories.cardRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.tfs.diploma.denormalService.dto.CardDto;
import ru.tfs.diploma.denormalService.feignClient.Feign;
import ru.tfs.diploma.denormalService.models.Card;
import ru.tfs.diploma.denormalService.models.Shipment;
import ru.tfs.diploma.denormalService.repositories.productRepositoires.ProductRepository;
import ru.tfs.diploma.denormalService.repositories.shipmentRepositories.ShipmentRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CardRepositoryImpl implements CardRepository {

    private final Feign feign;
    private final CardProductRepository cardProductRepository;
    private final ShipmentRepository shipmentRepository;
    private final ProductRepository productRepository;
    private List<Card> cardList;
    private List<CardDto> cardDtoList;

    @Autowired
    public CardRepositoryImpl(Feign feign, CardProductRepository cardProductRepository,
                              ShipmentRepository shipmentRepository, ProductRepository productRepository,
                              List<Card> cardList, List<CardDto> cardDtoList) {
        this.feign = feign;
        this.cardProductRepository = cardProductRepository;
        this.shipmentRepository = shipmentRepository;
        this.productRepository = productRepository;
        this.cardList = cardList;
        this.cardDtoList = cardDtoList;
    }

    public void saveCardsInMemory() {
        cardList = feign.findAllCards();
    }

    public void clearCardsInMemory() {
        cardList.clear();
    }

    public List<Card> findAllCardsFromInMemoryDB() {
        return cardList;
    }

    public Optional<Card> findCardFromInMemoryDB(Long id) {
        return cardList.stream().
                filter(client -> client.getId().equals(id)).
                findFirst();
    }

    public void saveAllCardsDto() {
        cardDtoList = cardList.stream().
                map(this::mapToDto).
                collect(Collectors.toList());
    }

    public void clearAllCardsDtoInMemory() {
        cardDtoList.clear();
    }

    public List<CardDto> findAllCardsDto() {
        return cardDtoList;
    }

    public Optional<CardDto> findCardDtoById(Long id) {
        return cardDtoList.stream()
                .filter(cardDto -> cardDto.getCardId().equals(id))
                .findFirst();
    }


    private CardDto mapToDto(Card card) {
        int cardBill = card.getCardProductList().stream()
                .mapToInt(cardProduct -> cardProduct.getQuantity() *
                        productRepository.findProductFromInMemoryDB(cardProduct.getProductId())
                .orElseThrow(NullPointerException::new).getPriceUE())
                .sum();

        if(card.getShipment() == null) {
            return new CardDto(card, cardBill);
        }

        Long shipmentId = card.getShipment().getId();
        Optional<Shipment> shipment =
                shipmentRepository.findShipmentFromInMemoryDB(shipmentId);

        return new CardDto(
                card.getId(),
                card.getClientId(),
                card.getCurrencyId(),
                card.getCreation(),
                card.getLastUpdate(),
                card.getVersion(),
                shipment.get().getId(),
                shipment.get().getAddress(),
                shipment.get().getCreation(),
                shipment.get().getLastUpdate(),
                shipment.get().getVersion(),
                card.getCardProductList(),
                cardBill
        );
    }
}
