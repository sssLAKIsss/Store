package ru.tfs.coreService.entities.order;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shipment")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shipment_id_seq")
    @SequenceGenerator(name = "shipment_id_seq", sequenceName = "shipment_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Positive
    @Column(name = "card_id")
    private Long cardId;

    @NotBlank(message = "Address - required!")
    @Size(min = 1, max = 255,  message = "Required size for address between 1 and 255!")
    @Column(name = "address")
    private String address;

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
