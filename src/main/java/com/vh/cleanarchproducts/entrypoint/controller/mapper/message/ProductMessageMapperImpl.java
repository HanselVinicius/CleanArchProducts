package com.vh.cleanarchproducts.entrypoint.controller.mapper.message;

import com.vh.cleanarchproducts.core.domain.Product;
import com.vh.cleanarchproducts.entrypoint.consumer.ProductMessage;
import org.springframework.stereotype.Component;

@Component
public class ProductMessageMapperImpl implements ProductMessageMapper{


    @Override
    public Product toProduct(ProductMessage productMessage) {
        return new Product(
                productMessage.getId(),
                productMessage.getName(),
                productMessage.getDescription(),
                productMessage.getPrice(),
                productMessage.getSerialNumber(),
                productMessage.getProductStatusEnum(),
                productMessage.isActive()
        );
    }
}
