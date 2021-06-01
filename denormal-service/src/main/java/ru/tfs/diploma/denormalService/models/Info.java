package ru.tfs.diploma.denormalService.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Info {

    private Long id;
    private String title;
    private String description;
    private Long ProductId;
    private Long LanguageId;
}
