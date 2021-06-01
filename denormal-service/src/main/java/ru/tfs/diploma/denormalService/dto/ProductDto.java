package ru.tfs.diploma.denormalService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.tfs.diploma.denormalService.models.Product;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long productId;
    private String productTitle;
    private int priceUE;
    private Instant productCreationTime;
    private Instant productLastUpdate;
    private int productVersion;

    private String infoTitle;
    private String infoDescription;
    private String languageName;

    private String parameterName;
    private Instant parameterCreationTime;
    private Instant parameterLastUpdate;
    private int parameterVersion;

    public ProductDto(Product product, String infoTitle, String infoDescription,
                      String languageName, String parameterName, Instant parameterCreationTime,
                      Instant parameterLastUpdate, int parameterVersion) {
        this.productId = product.getId();
        this.productTitle = product.getTitle();
        this.priceUE = product.getPriceUE();
        this.productCreationTime = product.getCreationTime();
        this.productLastUpdate = product.getLastUpdate();
        this.productVersion = product.getVersion();

        this.infoTitle = infoTitle;
        this.infoDescription = infoDescription;
        this.languageName = languageName;

        this.parameterName = parameterName;
        this.parameterCreationTime = parameterCreationTime;
        this.parameterLastUpdate = parameterLastUpdate;
        this.parameterVersion = parameterVersion;
    }

    public ProductDto(Product product) {
        this.productId = product.getId();
        this.productTitle = product.getTitle();
        this.priceUE = product.getPriceUE();
        this.productCreationTime = product.getCreationTime();
        this.productLastUpdate = product.getLastUpdate();
        this.productVersion = product.getVersion();
    }
}
