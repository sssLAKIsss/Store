package ru.tfs.coreService.entities.directories;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "parameter_type")
public class ParameterType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parameter_type_id_seq")
    @SequenceGenerator(name = "parameter_type_id_seq", sequenceName = "parameter_type_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Name - required!")
    @Size(min = 1, max = 50,  message = "Required size for name between 1 and 50!")
    @Column
    private String name;

    @CreationTimestamp
    @Column(name = "creation")
    private Instant creationTime;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Instant lastUpdate;

    @Version
    @Column(name = "version")
    private int version;

//    @ManyToMany
//    @JoinTable(name = "parameter",
//        joinColumns = {@JoinColumn(name = "parameter_type_id")},
//        inverseJoinColumns = {@JoinColumn(name = "product_id")})
//    private Set<Product> products;
}