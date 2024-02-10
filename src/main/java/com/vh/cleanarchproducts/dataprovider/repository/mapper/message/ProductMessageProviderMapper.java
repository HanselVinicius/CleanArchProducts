package com.vh.cleanarchproducts.dataprovider.repository.mapper.message;

import com.vh.cleanarchproducts.core.domain.Product;
import com.vh.cleanarchproducts.entrypoint.consumer.ProductMessage;

public interface ProductMessageProviderMapper {
    ProductMessage toProductMessage(Product product);
}
