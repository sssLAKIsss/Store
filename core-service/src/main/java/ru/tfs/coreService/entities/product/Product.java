package ru.tfs.coreService.entities.product;

import lombok.*;
import org.hibernate.annotations.*;
import ru.tfs.coreService.entities.directories.ParameterType;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_id_seq")
    @SequenceGenerator(name = "products_id_seq", sequenceName = "products_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Title - required!")
    @Size(min = 1, max = 50,  message = "Required size for product title between 1 and 50!")
    @Column(name = "title")
    private String title;

    @Positive
    @Column(name = "price_ue")
    private int priceUE;

    @CreationTimestamp
    @Column(name = "creation")
    private Instant creationTime;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Instant lastUpdate;

    @Version
    @Column(name = "version")
    private int version;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(name = "parameter",
        joinColumns = {@JoinColumn(name = "product_id")},
        inverseJoinColumns = {@JoinColumn(name = "parameter_type_id")})
    private List<ParameterType> parameters;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(name = "info",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "id")})
    private List<Info> infos;
}
