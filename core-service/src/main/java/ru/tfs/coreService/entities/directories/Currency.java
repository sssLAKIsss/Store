package ru.tfs.coreService.entities.directories;

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
@Table(name = "currency")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "currency_id_seq")
    @SequenceGenerator(name = "currency_id_seq", sequenceName = "currency_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Name - required!")
    @Size(min = 1, max = 50,  message = "Required size for name between 1 and 50!")
    @Column
    private String name;

    @Positive
    @Column
    private int multyplier;

    @CreationTimestamp
    @Column(name = "creation")
    private Instant creationTime;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Instant lastUpdate;

    @Version
    @Column(name = "version")
    private int version;
}