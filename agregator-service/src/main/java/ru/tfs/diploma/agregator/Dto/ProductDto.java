package ru.tfs.diploma.agregator.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public ProductDto(ProductDto productDto, int priceUE) {
        this.productId = productDto.getProductId();
        this.productTitle = productDto.getProductTitle();
        this.priceUE = priceUE;
        this.productCreationTime = productDto.getProductCreationTime();
        this.productLastUpdate = productDto.getProductLastUpdate();
        this.productVersion = productDto.getProductVersion();

        this.infoTitle = productDto.getInfoTitle();
        this.infoDescription = productDto.getInfoDescription();
        this.languageName = productDto.getLanguageName();

        this.parameterName = productDto.getParameterName();
        this.parameterCreationTime = productDto.getParameterCreationTime();
        this.parameterLastUpdate = productDto.getParameterLastUpdate();
        this.parameterVersion = productDto.getParameterVersion();
    }
}
