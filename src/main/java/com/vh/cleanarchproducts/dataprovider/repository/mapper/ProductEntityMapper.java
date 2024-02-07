package com.vh.cleanarchproducts.dataprovider.repository.mapper;

import com.vh.cleanarchproducts.core.domain.Product;
import com.vh.cleanarchproducts.dataprovider.entity.ProductEntity;

import java.util.List;

public interface ProductEntityMapper {

    Product toProduct(ProductEntity productEntity);

    ProductEntity toProductInsertEntity(Product product);

    ProductEntity toProductUpdateEntity(Product product);

    ProductEntity toProductDeleteEntity(Product product);


    List<Product> toProductList(List<ProductEntity> productEntities);
}
