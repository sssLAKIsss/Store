package ru.tfs.diploma.denormalService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.tfs.diploma.denormalService.models.Info;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InfoDto {
    private Long id;
    private String title;
    private String description;
    private Long productId;
    private Long languageId;
    private String languageName;

    public InfoDto(Info info, String languageName) {
        this.id = info.getId();
        this.title = info.getTitle();
        this.description = info.getDescription();
        this.productId = info.getProductId();
        this.languageId = info.getLanguageId();
        this.languageName = languageName;
    }

    public InfoDto(Info info) {
        this.id = info.getId();
        this.title = info.getTitle();
        this.description = info.getDescription();
        this.productId = info.getProductId();
        this.languageId = info.getLanguageId();
    }
}
