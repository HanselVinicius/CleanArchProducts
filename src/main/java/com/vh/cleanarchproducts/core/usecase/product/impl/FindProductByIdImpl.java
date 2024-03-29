package com.vh.cleanarchproducts.core.usecase.product.impl;

import com.vh.cleanarchproducts.core.dataprovider.FindProductByIdProvider;
import com.vh.cleanarchproducts.core.domain.Product;
import com.vh.cleanarchproducts.core.usecase.product.FindProductByIdUseCase;
import org.apache.kafka.common.errors.ResourceNotFoundException;

public class FindProductByIdImpl implements FindProductByIdUseCase {

    private final FindProductByIdProvider findProductByIdProvider;

    public FindProductByIdImpl(FindProductByIdProvider findProductByIdProvider) {
        this.findProductByIdProvider = findProductByIdProvider;
    }


    @Override
    public Product findProductById(String id) {
        return findProductByIdProvider.findProductById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found"));
    }
}
