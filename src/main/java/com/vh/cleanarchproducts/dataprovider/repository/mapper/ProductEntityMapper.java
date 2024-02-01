package com.vh.cleanarchproducts.dataprovider.repository.mapper;

import com.vh.cleanarchproducts.core.domain.Product;
import com.vh.cleanarchproducts.dataprovider.entity.ProductEntity;

public interface ProductEntityMapper {

    Product toProduct(ProductEntity productEntity);

    ProductEntity toProductInsertEntity(Product product);

    ProductEntity toProductUpdateEntity(Product product);


}
