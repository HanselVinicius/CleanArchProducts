package com.vh.cleanarchproducts.core.usecase.product;

import com.vh.cleanarchproducts.core.domain.Product;

public interface UpdateProductUseCase {

    Product updateProduct(String id,Product product);

}
