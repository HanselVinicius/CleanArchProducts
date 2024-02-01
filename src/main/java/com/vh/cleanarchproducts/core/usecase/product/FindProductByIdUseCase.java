package com.vh.cleanarchproducts.core.usecase.product;

import com.vh.cleanarchproducts.core.domain.Product;



public interface FindProductByIdUseCase {


    Product findProductById(String id);
}
