package ru.tfs.coreService.entities.order;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "card_product")
public class CardProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_product_id_seq")
    @SequenceGenerator(name = "card_product_id_seq", sequenceName = "card_product_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Positive
    @Column(name = "card_id")
    private Long cardId;

    @Positive
    @Column(name = "product_id")
    private Long productId;

    @Positive
    @Column(name = "quantity")
    private int quantity;

    @CreationTimestamp
    @Column(name = "creation")
    private Instant creation;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Instant lastUpdate;

    @Version
    @Column(name = "version")
    private int version;
}
