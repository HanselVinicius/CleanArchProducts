package com.vh.cleanarchproducts.entrypoint.controller.mapper.message;

import com.vh.cleanarchproducts.core.domain.Product;
import com.vh.cleanarchproducts.entrypoint.consumer.ProductMessage;

public interface ProductMessageMapper {

    Product toProduct(ProductMessage productMessage);

}
