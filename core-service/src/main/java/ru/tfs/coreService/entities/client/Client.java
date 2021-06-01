package ru.tfs.coreService.entities.client;

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
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_id_seq")
    @SequenceGenerator(name = "client_id_seq", sequenceName = "client_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Name - required!")
    @Size(min = 1, max = 50,  message = "Required size for name between 1 and 50!")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Region - required!")
    @Size(min = 1, max = 30,  message = "Required size for region between 1 and 30!")
    @Column(name = "region")
    private String region;

    @NotBlank(message = "Phone number - required!")
    @Size(min = 12, max = 12,  message = "Required size for phone number 12!")
    @Column(name = "phone")
    private String phoneNumber;

    @CreationTimestamp
    @Column(name = "creation")
    private Instant creationTime;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Instant lastUpdate;

    @Version
    @Column(name = "version")
    private int version;

//    @OneToOne
//    @JoinTable(name = "card",
//            joinColumns = @JoinColumn(name = "id"),
//            inverseJoinColumns = @JoinColumn(name = "client_id"))
//    private Card card;
}
