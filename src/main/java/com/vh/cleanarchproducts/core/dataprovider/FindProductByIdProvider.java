package com.vh.cleanarchproducts.core.dataprovider;

import com.vh.cleanarchproducts.core.domain.Product;

import java.util.Optional;

public interface FindProductByIdProvider {

    Optional<Product> findProductById(String id);
}
