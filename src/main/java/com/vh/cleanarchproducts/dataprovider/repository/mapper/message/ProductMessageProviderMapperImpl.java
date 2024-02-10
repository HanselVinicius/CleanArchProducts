package com.vh.cleanarchproducts.dataprovider.repository.mapper.message;

import com.vh.cleanarchproducts.core.domain.Product;
import com.vh.cleanarchproducts.entrypoint.consumer.ProductMessage;
import org.springframework.stereotype.Component;

@Component
public class ProductMessageProviderMapperImpl implements ProductMessageProviderMapper {


    @Override
    public ProductMessage toProductMessage(Product product) {
        return new ProductMessage(product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getSerialNumber(),
                product.getProductStatusEnum(),
                product.isActive()
        );
    }
}
