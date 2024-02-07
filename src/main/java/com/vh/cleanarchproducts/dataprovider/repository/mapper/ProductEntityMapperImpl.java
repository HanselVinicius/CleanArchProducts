package com.vh.cleanarchproducts.dataprovider.repository.mapper;


import com.vh.cleanarchproducts.core.domain.Product;
import com.vh.cleanarchproducts.core.domain.ProductStatusEnum;
import com.vh.cleanarchproducts.dataprovider.entity.ProductEntity;
import com.vh.cleanarchproducts.dataprovider.entity.ProductStatusEntityEnum;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ProductEntityMapperImpl implements ProductEntityMapper {

    @Override
    public Product toProduct(ProductEntity productEntity) {
        return Product.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .price(productEntity.getPrice())
                .stock(productEntity.getStock())
                .productStatusEnum(toProductStatusEnum(productEntity.getStatusEntityEnum()))
                .build();
    }

    @Override
    public ProductEntity toProductInsertEntity(Product product) {
        return new ProductEntity(UUID.randomUUID().toString(), product.getName(), product.getDescription(), product.getPrice(), product.getStock());
    }

    @Override
    public ProductEntity toProductUpdateEntity(Product product) {
        return new ProductEntity(product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                toProductStatusEntityEnum(product.getProductStatusEnum()),
                product.isActive()

        );
    }

    @Override
    public ProductEntity toProductDeleteEntity(Product product) {
        return new ProductEntity(product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                toProductStatusEntityEnum(product.getProductStatusEnum()),
                false

        );
    }

    @Override
    public List<Product> toProductList(List<ProductEntity> productEntities) {
        return productEntities.stream().map(this::toProduct).toList();
    }

    private ProductStatusEntityEnum toProductStatusEntityEnum(ProductStatusEnum productStatusEnum) {
        return ProductStatusEntityEnum.valueOf(productStatusEnum.name());
    }

    private ProductStatusEnum toProductStatusEnum(ProductStatusEntityEnum productStatusEntityEnum) {
        return ProductStatusEnum.valueOf(productStatusEntityEnum.name());
    }
}
