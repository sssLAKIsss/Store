package ru.tfs.diploma.denormalService.repositories.productRepositoires;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.tfs.diploma.denormalService.dto.InfoDto;
import ru.tfs.diploma.denormalService.dto.ProductDto;
import ru.tfs.diploma.denormalService.feignClient.Feign;
import ru.tfs.diploma.denormalService.models.Info;
import ru.tfs.diploma.denormalService.models.ParameterType;
import ru.tfs.diploma.denormalService.models.Product;
import ru.tfs.diploma.denormalService.repositories.infoRepositories.InfoRepository;
import ru.tfs.diploma.denormalService.repositories.parameterRepositories.ParameterTypeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class ProductRepositoryImpl implements ProductRepository {

    private final Feign feign;
    private final InfoRepository infoRepository;
    private final ParameterTypeRepository parameterTypeRepository;
    private List<Product> productList;
    private final List<ProductDto> productDtoList;

    @Autowired
    public ProductRepositoryImpl(Feign feign, InfoRepository infoRepository,
                                 ParameterTypeRepository parameterTypeRepository, List<Product> productList,
                                 List<ProductDto> productDtoList) {
        this.feign = feign;
        this.infoRepository = infoRepository;
        this.parameterTypeRepository = parameterTypeRepository;
        this.productList = productList;
        this.productDtoList = productDtoList;
    }

    public void saveProductsInMemory() {
        productList = feign.findAllProducts();
    }

    public void clearProductsInMemory() {
        productList.clear();
    }

    public List<Product> findAllProductsFromInMemoryDB() {
        return productList;
    }

    public Optional<Product> findProductFromInMemoryDB(Long id) {
        return productList.stream().
                filter(product -> product.getId().equals(id)).
                findFirst();
    }

    public void saveAllProductsDto() {
        for (Product p : productList) {
            for (ParameterType par : p.getParameters()) {
                for (Info info : p.getInfos()) {
                    productDtoList.add(mapToDto(p, par.getId(), info.getId()));
                }
            }
        }
    }

    public void clearAllProductsDtoInMemory() {
        productDtoList.clear();
    }

    public List<ProductDto> findAllProductsDto(String language) {
        return productDtoList.stream()
                .filter(productDto -> productDto.getLanguageName().equals(language))
                .collect(Collectors.toList());
    }

    public Optional<ProductDto> findProductDtoById(Long id, String language) {
        return productDtoList.stream()
                .filter(productDto -> productDto.getProductId().equals(id))
                .filter(productDto -> productDto.getLanguageName().equals(language))
                .findFirst();
    }

    private ProductDto mapToDto(Product product, Long parId, Long infoId) {

        Optional<InfoDto> optionalInfoDto = infoRepository.findInfoDtoById(infoId);
        Optional<ParameterType> newParameterType = parameterTypeRepository
                .findParameterTypeFromInMemoryDB(parId);

        if (optionalInfoDto.isEmpty() || newParameterType.isEmpty()) {
            log.info("infosDto or parameters is empty, so creating new product");
            return new ProductDto(product);
        }
        return new ProductDto(
                product.getId(),
                product.getTitle(),
                product.getPriceUE(),
                product.getCreationTime(),
                product.getLastUpdate(),
                product.getVersion(),
                optionalInfoDto.get().getTitle(),
                optionalInfoDto.get().getDescription(),
                optionalInfoDto.get().getLanguageName(),
                newParameterType.get().getName(),
                newParameterType.get().getCreationTime(),
                newParameterType.get().getLastUpdate(),
                newParameterType.get().getVersion()
        );
    }
}
