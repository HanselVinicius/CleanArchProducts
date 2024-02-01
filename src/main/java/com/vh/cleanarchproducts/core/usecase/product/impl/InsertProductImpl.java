package com.vh.cleanarchproducts.core.usecase.product.impl;

import com.vh.cleanarchproducts.core.dataprovider.InsertProductProvider;
import com.vh.cleanarchproducts.core.domain.Product;
import com.vh.cleanarchproducts.core.usecase.product.InsertProductUseCase;

public class InsertProductImpl implements InsertProductUseCase {

    private final InsertProductProvider insertProductProvider;

    public InsertProductImpl(InsertProductProvider insertProductProvider) {
        this.insertProductProvider = insertProductProvider;
    }

    @Override
    public Product insertProduct(Product product) {
        return insertProductProvider.insertProduct(product);
    }
}
