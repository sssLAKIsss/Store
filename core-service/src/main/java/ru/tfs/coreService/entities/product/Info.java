package ru.tfs.coreService.entities.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "info")
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "info_id_seq")
    @SequenceGenerator(name = "info_id_seq", sequenceName = "info_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Title required!")
    @Size(min = 1, max = 50, message = "Title must have between 1 and 50 chars!")
    @Column(name = "title")
    private String title;

    @NotBlank(message = "Description required!")
    @Size(min = 1, max = 50, message = "Description must have between 1 and 50 chars!")
    @Column(name = "description")
    private String description;

    @Positive
    @Column(name = "product_id")
    private Long productId;

    @Positive
    @Column(name = "language_id")
    private Long languageId;
}
