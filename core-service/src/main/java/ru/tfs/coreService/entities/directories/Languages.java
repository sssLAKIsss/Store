package ru.tfs.coreService.entities.directories;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "languages")
public class Languages {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "languages_id_seq")
    @SequenceGenerator(name = "languages_id_seq", sequenceName = "languages_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Name - required!")
    @Size(min = 1, max = 50,  message = "Required size for name between 1 and 50!")
    @Column(name = "name")
    private String name;
}
