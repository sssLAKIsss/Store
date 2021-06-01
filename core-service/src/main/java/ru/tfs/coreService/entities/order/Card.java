package ru.tfs.coreService.entities.order;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_id_seq")
    @SequenceGenerator(name = "card_id_seq", sequenceName = "card_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Positive
    @Column(name = "client_id")
    private Long clientId;

    @Positive
    @Column(name = "currency_id")
    private Long currencyId;

    @CreationTimestamp
    @Column(name = "creation")
    private Instant creation;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Instant lastUpdate;

    @Version
    @Column(name = "version")
    private int version;

    @OneToOne
    @JoinTable(name = "shipment",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "card_id"))
    private Shipment shipment;

    @ManyToMany
    @JoinTable(name = "card_product",
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<CardProduct> cardProductList;
}
