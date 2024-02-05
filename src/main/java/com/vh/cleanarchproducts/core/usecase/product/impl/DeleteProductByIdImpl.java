package com.vh.cleanarchproducts.core.usecase.product.impl;

import com.vh.cleanarchproducts.core.dataprovider.DeleteProductByIdProvider;
import com.vh.cleanarchproducts.core.domain.Product;
import com.vh.cleanarchproducts.core.usecase.product.DeleteProductByIdUseCase;
import com.vh.cleanarchproducts.core.usecase.product.FindProductByIdUseCase;

public class DeleteProductByIdImpl implements DeleteProductByIdUseCase {

    private FindProductByIdUseCase findProductByIdUseCase;

    private DeleteProductByIdProvider deleteProductByIdProvider;

    public DeleteProductByIdImpl(FindProductByIdUseCase findProductByIdUseCase, DeleteProductByIdProvider deleteProductByIdProvider) {
        this.findProductByIdUseCase = findProductByIdUseCase;
        this.deleteProductByIdProvider = deleteProductByIdProvider;
    }

    @Override
    public void deleteProductById(String id) {
        Product product = findProductByIdUseCase.findProductById(id);
        product.setActive(false);
        this.deleteProductByIdProvider.deleteProductById(product);
    }
}
